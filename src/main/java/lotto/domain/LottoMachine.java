package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class LottoMachine {
    static {
        lottoPrice = new Money(1000);
    }

    private static final Money lottoPrice;

    public static List<Lotto> getRandomLottos(Money money) {
        List<Lotto> result = new ArrayList<>();
        for (int i = 0; i < money.getQuotient(lottoPrice); i++) {
            result.add(makeRandomLotto());
        }
        return result;
    }

    public static Money getLottoPrice() {
        return lottoPrice;
    }

    public static Lotto getLotto(List<Integer> lottoNumbers) {
        return new Lotto(lottoNumbers);
    }

    public static WinningLotto getWinningLotto(List<Integer> lottoNumbers, int bonusNumber) {
        Lotto lotto = new Lotto(lottoNumbers);
        LottoNumber bonusNum = new LottoNumber(bonusNumber);
        return new WinningLotto(lotto, bonusNum);
    }

    private static Lotto makeRandomLotto() {
        return getLotto(Randoms.pickUniqueNumbersInRange(
                LottoNumber.getMinLottoNumber(),
                LottoNumber.getMaxLottoNumber(),
                Lotto.getLottoNumberCount())
        );
    }

}
