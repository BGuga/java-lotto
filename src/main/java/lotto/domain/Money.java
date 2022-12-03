package lotto.domain;

public class Money {
    public static final String INVALID_MONEY_INPUT_ERROR_MESSAGE = "[ERROR] 로또의 가격으로 나누어 지지 않는 금액의 입력 입니다.";
    private final int money;

    public Money(int money) {
        moneyValidation(money);
        this.money = money;
    }

    public int getQuotient(Money divider) {
        return this.money/divider.money;
    }

    public int getMoney() {
        return money;
    }

    private void moneyValidation(int money) {
        if (money % LottoMachine.getLottoPrice() != 0) {
            throw new IllegalArgumentException(INVALID_MONEY_INPUT_ERROR_MESSAGE);
        }
    }
}
