package lotto;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class InputView {
    private final Scanner scanner = new Scanner(System.in);

    public int readPurchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        return Integer.parseInt(scanner.nextLine());
    }

    public List<Integer> readWinningNumbers() {
        System.out.println();
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        String input = scanner.nextLine();
        return parseNumbers(input);
    }

    private List<Integer> parseNumbers(String input) {
        List<Integer> numbers = new ArrayList<>();
        for (String number : input.split(",")) {
            numbers.add(Integer.parseInt(number.trim()));
        }
        return numbers;
    }
}