package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.LottoResult;

import java.text.DecimalFormat;
import java.util.*;

public class OutputView {
    public void printBuyingLottos(List<Lotto> lottoList) {
        System.out.println(String.format("%d개를 구매했습니다.", lottoList.size()));
        for (Lotto lotto : lottoList) {
            printLotto(lotto);
        }
    }

    public void printLottoResult(Map<LottoResult, Integer> result) {
        System.out.println("당첨 통계\n---\n");
        printResults(result);
    }

    public void printLottoProfitRate(float rate) {
        float makeRateToPercent = rate * 100;
        System.out.printf("총 수익률은 %.1f%%입니다.", makeRateToPercent);
    }

    private void printLotto(Lotto lotto) {
        StringJoiner lottoPrintFormat = new StringJoiner(", ", "[", "]");
        List<Integer> intLottoNumbers = lotto.getIntLottoNumbers();
        intLottoNumbers.sort(Comparator.naturalOrder());
        for (int number : intLottoNumbers) {
            lottoPrintFormat.add(String.valueOf(number));
        }
        System.out.println(lottoPrintFormat);
    }

    private void printResults(Map<LottoResult, Integer> result) {
        List<LottoResult> lottoResults = Arrays.asList(LottoResult.values());
        orderListByPrize(lottoResults);
        for (LottoResult lottoResult : lottoResults) {
            printPrize(lottoResult, result.getOrDefault(lottoResult, 0));
        }
    }

    private void orderListByPrize(List<LottoResult> results) {
        results.sort(new Comparator<LottoResult>() {
            @Override
            public int compare(LottoResult o1, LottoResult o2) {
                return o1.getPrize() - o2.getPrize();
            }
        });
    }

    private void printPrize(LottoResult lottoResult, int count) {
        if (lottoResult == LottoResult.MISS) {
            return;
        }
        if (lottoResult == LottoResult.SECOND) {
            System.out.println(String.format("%d개 일치, 보너스 볼 일치 (%s원) - %d개", lottoResult.getMatchingNumber(), getPrizeString(lottoResult.getPrize()), count));
            return;
        }
        System.out.println(String.format("%d개 일치 (%s원) - %d개", lottoResult.getMatchingNumber(), getPrizeString(lottoResult.getPrize()), count));
    }

    private String getPrizeString(int prize) {
        DecimalFormat decFormat = new DecimalFormat("###,###");
        return decFormat.format(prize);
    }
}
