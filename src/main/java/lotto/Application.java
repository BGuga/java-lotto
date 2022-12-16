package lotto;

import lotto.controller.LottoController;
import lotto.domain.LottoResult;

import java.util.Arrays;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        List<LottoResult> lottoResults = Arrays.asList(LottoResult.values());
        for(LottoResult a : lottoResults){
            System.out.println(a.getPrize());
        }
        // TODO: 프로그램 구현
//        LottoController lottoController = new LottoController();
//        lottoController.process();
    }
}
