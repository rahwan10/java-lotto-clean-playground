package lotto.view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class InputView {
    private static final Scanner SCANNER = new Scanner(System.in);
    private static final String WINNING_NUMBERS_DELIMITER = ",";

    private InputView() {
    }

    public static int readPurchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        return parseNumber(SCANNER.nextLine());
    }

    public static List<Integer> readWinningNumbers() {
        System.out.println();
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        return parseWinningNumbers(SCANNER.nextLine());
    }


    private static List<Integer> parseWinningNumbers(String input) {
        return Arrays.stream(input.split(WINNING_NUMBERS_DELIMITER))
                .map(InputView::parseNumber)
                .toList();
    }

    private static int parseNumber(String input) {
        try {
            return Integer.parseInt(input.trim());
        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException("구입금액은 숫자만 입력할 수 있습니다.");
        }
    }
}
