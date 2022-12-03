package lotto.domain;

import java.util.Arrays;

public enum LottoResult {
    FIRST(6, 2_000_000_000),
    SECOND(5, 30_000_000),
    THIRD(5, 1_500_000),
    FOURTH(4, 50_000),
    FIFTH(3, 5_000),
    MISS(0, 0);

    private final int matchingNumber;
    private final int prize;

    LottoResult(int matchingNumber, int prize) {
        this.matchingNumber = matchingNumber;
        this.prize = prize;
    }

    public static LottoResult getResult(int matchingCount, boolean bonusNumberMatched) {
        LottoResult lottoResult = Arrays.stream(values())
                .filter(result -> result.matchingNumber == matchingCount)
                .findAny()
                .orElse(LottoResult.MISS);
        if (lottoResult == LottoResult.SECOND || lottoResult == LottoResult.THIRD) {
            return checkSecondOrThird(bonusNumberMatched);
        }
        return lottoResult;
    }

    public int getPrize() {
        return prize;
    }

    public int getMatchingNumber() {
        return matchingNumber;
    }

    private static LottoResult checkSecondOrThird(boolean bonusNumberMatched) {
        if (bonusNumberMatched) {
            return LottoResult.SECOND;
        }
        return LottoResult.THIRD;
    }
}
