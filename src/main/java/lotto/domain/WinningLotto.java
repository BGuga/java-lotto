package lotto.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WinningLotto {

    public static final String LOTTO_INCLUDE_BONUS_NUMBER_ERROR_MESSAGE = "[ERROR] 보너스 번호는 로또 번호에 포함되면 안됩니다.";
    private final Lotto lotto;
    public final LottoNumber bonusNumber;

    public WinningLotto(Lotto lotto, LottoNumber bonusNumber) {
        checkBonusInLotto(lotto, bonusNumber);
        this.lotto = lotto;
        this.bonusNumber = bonusNumber;
    }

    public Map<LottoResult, Integer> getResults(List<Lotto> lottos) {
        Map<LottoResult, Integer> result = new HashMap<>();
        for (Lotto lotto : lottos) {
            LottoResult lottoResult = getResult(lotto);
            result.computeIfPresent(lottoResult, (k, v) -> v + 1);
            result.computeIfAbsent(lottoResult, (v) -> 1);
        }
        return result;
    }

    public LottoResult getResult(Lotto lotto) {
        return LottoResult.getResult(this.lotto.countSameLottoNumber(lotto), lotto.isIncluded(bonusNumber));
    }

    public float getProfitRate(List<Lotto> lottos) {
        Map<LottoResult, Integer> results = getResults(lottos);
        int prizeAmount = results.keySet().stream()
                .map(result -> results.get(result) * result.getPrize())
                .reduce((x, y) -> x + y)
                .get();
        return (float)prizeAmount / LottoMachine.getLottoPrice();
    }

    private void checkBonusInLotto(Lotto lotto, LottoNumber bonusNumber) {
        if (lotto.isIncluded(bonusNumber)) {
            throw new IllegalArgumentException(LOTTO_INCLUDE_BONUS_NUMBER_ERROR_MESSAGE);
        }
    }
}
