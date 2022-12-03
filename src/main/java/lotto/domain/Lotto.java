package lotto.domain;

import java.util.List;

public class Lotto {
    private static final String LOTTO_SIZE_ERROR_MESSAGE = "[ERROR] 로또는 6자리 숫자로 이루어져 있습니다.";
    public static final String LOTTO_NUMBER_DUPLICATE_ERROR_MESSAGE = "[ERROR] 로또는 중복되지 않은 숫자들로 생성 됩니다.";
    private static final int lottoNumberCount = 6;

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        checkLottoNumberCount(numbers);
        checkDuplication(numbers);
    }

    private void checkLottoNumberCount(List<Integer> numbers) {
        if (numbers.size() != lottoNumberCount) {
            throw new IllegalArgumentException(LOTTO_SIZE_ERROR_MESSAGE);
        }
    }

    private void checkDuplication(List<Integer> numbers) {
        long nonDuplicatedNumberCount = numbers.stream().distinct().count();
        if (nonDuplicatedNumberCount != numbers.size()) {
            throw new IllegalArgumentException(LOTTO_NUMBER_DUPLICATE_ERROR_MESSAGE);
        }
    }

    // TODO: 추가 기능 구현
}
