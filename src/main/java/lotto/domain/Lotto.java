package lotto.domain;

import java.util.List;

public final class Lotto {

    public static final int NUMBER_COUNT = 6;

    private final List<LottoNumber> numbers;

    public Lotto(List<LottoNumber> numbers) {
        validateSize(numbers);
        validateDuplicatedNumbers(numbers);
        this.numbers = numbers.stream().sorted().toList();
    }

    private void validateSize(List<LottoNumber> numbers) {
        if (numbers.size() != NUMBER_COUNT) {
            throw new IllegalArgumentException("로또 번호는 6개여야 합니다.");
        }
    }

    private void validateDuplicatedNumbers(List<LottoNumber> numbers) {
        if (numbers.stream().distinct().count() != NUMBER_COUNT) {
            throw new IllegalArgumentException("로또 번호는 중복될 수 없습니다.");
        }
    }

    public List<LottoNumber> numbers() {
        return numbers;
    }
}
