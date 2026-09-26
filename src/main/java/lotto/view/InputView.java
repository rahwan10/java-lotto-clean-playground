package lotto.view;

import java.util.Scanner;

/** 콘솔에서 로또 자동 구매에 필요한 값을 입력받는다. */
public class InputView {

    private static final String PURCHASE_AMOUNT_MESSAGE = "구입금액을 입력해 주세요.";

    private final Scanner scanner = new Scanner(System.in);

    /**
     * 구매 금액 입력 안내를 출력하고 사용자가 입력한 원본 문자열을 반환한다.
     *
     * @return 사용자가 입력한 구매 금액 문자열
     */
    public String readPurchaseAmount() {
        System.out.println(PURCHASE_AMOUNT_MESSAGE);
        return scanner.nextLine();
    }
}
