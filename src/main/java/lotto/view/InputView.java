package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.Lotto;
import lotto.domain.LottoNumber;
import lotto.domain.Money;
import lotto.domain.WinningLotto;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputView {

    public Money readMoneyByConsole() {
        System.out.println("구입금액을 입력해 주세요.");
        return new Money(makeInt(Console.readLine()));
    }

    public WinningLotto readWinningLotto() {
        new WinningLotto()
    }

    public Lotto readLotto() {
        try {
            System.out.println("당첨 번호를 입력해 주세요.");
            return new Lotto(makeStringListToIntList(splitByComma(Console.readLine())));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return readLotto();
        }
    }

    public LottoNumber readBonusNumber() {
        System.out.println("보너스 (로또)번호를 입력해 주세요.");
        return new LottoNumber()
    }

    private int makeInt(String moneyString) {
        try {
            return Integer.parseInt(moneyString);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 숫자를 입력해 주세요");
        }
    }

    private List<Integer> makeStringListToIntList(List<String> data) {
        return data.stream()
                .map(ch -> makeInt(ch))
                .collect(Collectors.toList());
    }

    private List<String> splitByComma(String lottoNumData) {
        return Arrays.asList(lottoNumData.split(","));
    }
}
