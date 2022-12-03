package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoNumber {
    private static final String OUT_OF_NUMBER_RANGE_ERROR_MESSAGE = "[ERROR] 로또 번호는 1~45 사이 값 입니다.";
    private static final int minValue = 1;
    private static final int maxValue = 45;
    private final int lottoNumber;

    public LottoNumber(int number) {
        checkNumberRange(number);
        this.lottoNumber = number;
    }

    public boolean isNumber(int number) {
        return number == this.lottoNumber;
    }

    public boolean isSameLottoNumber(LottoNumber otherLottoNumber) {
        return this.lottoNumber == otherLottoNumber.lottoNumber;
    }

    public static List<LottoNumber> makeNumberToLottoNumber(List<Integer> numbers) {
        List<LottoNumber> result = new ArrayList<>();
        for (Integer number : numbers) {
            result.add(new LottoNumber(number));
        }
        return result;
    }

    public static int getMinLottoNumber(){
        return minValue;
    }

    public static int getMaxLottoNumber(){
        return maxValue;
    }

    private void checkNumberRange(int number) {
        if (number < minValue || number > maxValue) {
            throw new IllegalArgumentException(OUT_OF_NUMBER_RANGE_ERROR_MESSAGE);
        }
    }
}
