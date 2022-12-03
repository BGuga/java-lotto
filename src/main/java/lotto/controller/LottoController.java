package lotto.controller;

import lotto.domain.*;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;

public class LottoController {
    InputView inputView = new InputView();
    OutputView outputView = new OutputView();

    public void process() {
        List<Lotto> lottoList = getLottosByConsole();
        WinningLotto winningLotto = getWinningLottoByConsole();
        printResult(winningLotto, lottoList);
    }

    private List<Lotto> getLottosByConsole() {
        Money money = getMoneyByConsole();
        List<Lotto> lottos = LottoMachine.getRandomLottos(money);
        outputView.printBuyingLottos(lottos);
        return lottos;
    }

    private Money getMoneyByConsole() {
        return inputView.readMoneyByConsole();
    }

    private WinningLotto getWinningLottoByConsole() {
        Lotto lotto = new Lotto(inputView.readLottoNumbers());
        LottoNumber lottoNumber = new LottoNumber(inputView.readBonusNumber());
        return new WinningLotto(lotto, lottoNumber);
    }

    private void printResult(WinningLotto winningLotto, List<Lotto> lottos) {
        outputView.printLottoResult(winningLotto.getResults(lottos));
        outputView.printLottoProfitRate(winningLotto.getProfitRate(lottos));
    }
}
