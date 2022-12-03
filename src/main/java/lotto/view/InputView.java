package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.Money;

public class InputView {

    public Money readMoneyByConsole() {
        System.out.println("구입금액을 입력해 주세요.");
        return new Money(makeMoney(Console.readLine());)
    }

    private int makeMoney(String moneyString) {
        try {
            return Integer.parseInt(moneyString);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 숫자를 입력해 주세요");
        }
    }
}
