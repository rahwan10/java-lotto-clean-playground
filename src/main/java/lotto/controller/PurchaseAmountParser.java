package lotto.controller;

import lotto.domain.PurchaseAmount;

/** 콘솔에서 받은 구매 금액 문자열을 PurchaseAmount로 변환한다. */
public class PurchaseAmountParser {

    /**
     * 숫자 문자열을 구매 금액 객체로 변환한다.
     *
     * @param inputAmount 사용자가 입력한 구매 금액 문자열
     * @return 검증을 통과한 구매 금액 객체
     * @throws IllegalArgumentException 숫자가 아닌 문자열을 입력한 경우
     */
    public PurchaseAmount parse(String inputAmount) {
        try {
            return new PurchaseAmount(Integer.parseInt(inputAmount));
        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException("구매 금액은 숫자여야 합니다.");
        }
    }
}
