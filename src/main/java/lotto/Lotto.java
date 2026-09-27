package lotto;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validateSize(numbers);
        validateNoDuplicate(numbers);
        validateRange(numbers);
        this.numbers = numbers;   // 검증 다 통과한 뒤에 저장
    }

    private void validateNoDuplicate(List<Integer>numbers){
        // numbers 복사해서 Set으로 만들고 hashSet의 size와 비교해서 중복 체크
        Set<Integer> uniqueNumbers = new HashSet<>(numbers);
        if (uniqueNumbers.size() != numbers.size()) {
            throw new IllegalArgumentException("로또 번호는 중복될 수 없습니다.");
        }
    }

    private void validateSize(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("로또 번호는 6개여야 합니다.");
        }
    }

    private void validateRange(List<Integer> numbers) {
        for (Integer number : numbers) {
            validateNumberInRange(number);
        }
    }

    private void validateNumberInRange(int number) {
        if (number < 1 || number > 45) {
            throw new IllegalArgumentException("로또 번호는 1부터 45까지의 숫자여야 합니다.");
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public int countMatchNumbers(WinningNumbers winningNumbers) {
        return winningNumbers.countMatch(numbers);
    }
}
