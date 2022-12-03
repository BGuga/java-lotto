package lotto.domain;

public class WinningLotto {

    public static final String LOTTO_INCLUDE_BONUS_NUMBER_ERROR_MESSAGE = "[ERROR] 보너스 번호는 로또 번호에 포함되면 안됩니다.";
    private final Lotto lotto;
    public final LottoNumber bonusNumber;

    public WinningLotto(Lotto lotto, LottoNumber bonusNumber) {
        checkBonusInLotto(lotto, bonusNumber);
        this.lotto = lotto;
        this.bonusNumber = bonusNumber;
    }

    private void checkBonusInLotto(Lotto lotto, LottoNumber bonusNumber) {
        if (lotto.isIncluded(bonusNumber)) {
            throw new IllegalArgumentException(LOTTO_INCLUDE_BONUS_NUMBER_ERROR_MESSAGE);
        }
    }
}
