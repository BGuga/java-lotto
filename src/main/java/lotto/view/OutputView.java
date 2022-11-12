package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.LottoRanking;
import lotto.domain.LottoResult;

import java.text.DecimalFormat;
import java.util.*;
import java.util.stream.Collectors;

public class OutputView {
    private static final String LOTTO_ISSUE_MESSAGE = "%d개를 구매했습니다.";
    private static final String LOTTO_FRAME = "[%s]";
    private static final String LOTTO_RESULT_STARTING_MESSAGE = "당첨 통계\n---";
    private static final String LOTTO_RANKING_MESSAGE = "%d개 일치 (%s원) - %d개";
    private static final String LOTTO_SECOND_RANKING_MESSAGE = "%d개 일치, 보너스 볼 일치 (%s원) - %d개";
    private static final String LOTTO_RETURN_RATE_MESSAGE = "총 수익률은 %.1f%%입니다.";

    public static void printNumberOfIssuedLotto(int lottoNumbers) {
        printEmptyLine();
        System.out.println(String.format(LOTTO_ISSUE_MESSAGE, lottoNumbers));
    }

    public static void printLottosInformation(List<Lotto> lottos) {
        for (Lotto lotto : lottos) {
            List<Integer> lottoNumbers = lotto.getNumbers();
            sortLottoNumbers(lottoNumbers);
            printLottoInformation(lottoNumbers);
        }
        printEmptyLine();
    }

    public static void printLottoResult(Map<LottoRanking, Integer> lottoResult) {
        System.out.println(LOTTO_RESULT_STARTING_MESSAGE);
        printOrderLottoResult(lottoResult);
    }

    public static void printReturnRate(double returnRate) {
        double result = returnRate * 100;
        System.out.println(String.format(LOTTO_RETURN_RATE_MESSAGE, result));
    }

    public static void printEmptyLine() {
        System.out.println();
    }

    private static void printLottoInformation(List<Integer> lottonumbers) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < lottonumbers.size(); i++) {
            int number = lottonumbers.get(i);
            if (i == lottonumbers.size() - 1) {
                result.append(number);
                continue;
            }
            result.append(number);
            result.append(", ");
        }
        System.out.println(String.format(LOTTO_FRAME, result));
    }

    private static void sortLottoNumbers(List<Integer> lottoNumbers) {
        Collections.sort(lottoNumbers);
    }

    private static void printOrderLottoResult(Map<LottoRanking, Integer> lottoResult) {
        List<LottoRanking> orderedLottoRanking = Arrays.stream(LottoRanking.values())
                .sorted(Comparator.comparing(LottoRanking::getNumberScore))
                .collect(Collectors.toList());
        for (LottoRanking ranking : orderedLottoRanking) {
            Integer count = lottoResult.get(ranking);
            if (count == null) {
                printLotto(ranking, 0);
                continue;
            }
            printLotto(ranking, count);
        }
    }

    private static void printLotto(LottoRanking lottoRanking, int count) {
        String messageFrame = LOTTO_RANKING_MESSAGE;
        if (lottoRanking == LottoRanking.MISS) {
            return;
        }
        if (lottoRanking == LottoRanking.SECOND) {
            messageFrame = LOTTO_SECOND_RANKING_MESSAGE;
        }
        String Reward = makeMoneyString(lottoRanking.getReward());
        System.out.println(String.format(messageFrame,
                (int) lottoRanking.getSameNumber(),
                Reward,
                count));
    }

    private static String makeMoneyString(int number) {
        DecimalFormat decFormat = new DecimalFormat("###,###");
        return decFormat.format(number);
    }
}
