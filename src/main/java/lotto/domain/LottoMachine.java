package lotto.domain;

public class LottoMachine {
    static {
        lottoPrice = 1000;
    }
    private static final int lottoPrice;


    public static int getLottoPrice() {
        return lottoPrice;
    }
}
