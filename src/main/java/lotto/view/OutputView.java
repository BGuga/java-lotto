package lotto.view;

import lotto.domain.Lotto;

import java.util.List;
import java.util.StringJoiner;

public class OutputView {
    public void printBuyingLottos(List<Lotto> lottoList) {
        System.out.println(String.format("%d개를 구입했습니다.", lottoList.size()));
        for (Lotto lotto : lottoList) {
            printLotto(lotto);
        }
    }

    private void printLotto(Lotto lotto) {
        StringJoiner lottoPrintFormat = new StringJoiner(", ", "[", "]");
        for (int number : lotto.getIntLottoNumbers()) {
            lottoPrintFormat.add(String.valueOf(number));
        }
        System.out.println(lottoPrintFormat);
    }
}
