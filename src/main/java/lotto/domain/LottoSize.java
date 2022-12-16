package lotto.domain;

public class LottoSize {
    private static final int LOTTO_SIZE_VALUE = 6;
    private final int lottoSize;

    public LottoSize(int size) {
        validateSize(size)
        this.lottoSize = size;
    }

    private void validateSize(int size) {
        if (size != LOTTO_SIZE_VALUE) {
            throw new IllegalArgumentException(String.format("[ERROR] 로또의 크기는 %d이여야 합니다.", LOTTO_SIZE_VALUE));
        }
    }
}
