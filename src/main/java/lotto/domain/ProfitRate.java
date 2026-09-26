package lotto.domain;

import java.math.BigDecimal;
import java.math.RoundingMode;

/** 총상금과 구매 금액의 비율을 소수점 둘째 자리까지 표현한다. */
public record ProfitRate(BigDecimal value) {

    private static final int SCALE = 2;

    /**
     * 총상금과 구매 금액을 이용해 수익률을 계산한다.
     *
     * @param totalPrize 당첨으로 받은 총상금
     * @param purchaseAmount 로또 구매 금액
     * @return 소수점 둘째 자리에서 버린 수익률
     */
    public static ProfitRate calculate(Prize totalPrize, PurchaseAmount purchaseAmount) {
        BigDecimal dividend = BigDecimal.valueOf(totalPrize.value());
        BigDecimal divisor = BigDecimal.valueOf(purchaseAmount.value());
        return new ProfitRate(dividend.divide(divisor, SCALE, RoundingMode.DOWN));
    }
}
