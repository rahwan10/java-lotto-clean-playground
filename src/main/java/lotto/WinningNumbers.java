package lotto;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WinningNumbers {
    private static final int SIZE = 6;

    private final List<Integer> numbers;

    public WinningNumbers(List<Integer> numbers) {
        validateSize(numbers);
        validateNoDuplicate(numbers);
        this.numbers = numbers;
    }

    private void validateSize(List<Integer> numbers) {
        if (numbers.size() != SIZE) {
            throw new IllegalArgumentException("당첨 번호는 6개여야 합니다.");
        }
    }

    private void validateNoDuplicate(List<Integer> numbers) {
        Set<Integer> uniqueNumbers = new HashSet<>(numbers);
        if (uniqueNumbers.size() != numbers.size()) {
            throw new IllegalArgumentException("당첨 번호는 중복될 수 없습니다.");
        }
    }

    public int countMatch(List<Integer> lottoNumbers) {
        int matchCount = 0;
        for (Integer number : lottoNumbers) {
            matchCount += countIfMatch(number);
        }
        return matchCount;
    }

    private int countIfMatch(Integer number) {
        if (numbers.contains(number)) {
            return 1;
        }
        return 0;
    }
}