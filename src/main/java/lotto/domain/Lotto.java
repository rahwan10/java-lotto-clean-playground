package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {

    public static final int LOTTO_NUMBER_COUNT = 6;
    private final List<LottoNumber> numbers;

    public Lotto(List<Integer> numbers) {
        validateSize(numbers);
        validateDuplicate(numbers);
        this.numbers = toSortedLottoNumbers(numbers);
    }

    private void validateSize(List<Integer> numbers) {
        if (numbers.size() != LOTTO_NUMBER_COUNT) {
            throw new IllegalArgumentException("로또 번호는 6개여야 합니다.");
        }
    }

    private void validateDuplicate(List<Integer> numbers) {
        Set<Integer> uniqueNumbers = new HashSet<>(numbers);
        if (uniqueNumbers.size() != numbers.size()) {
            throw new IllegalArgumentException("로또 번호는 중복될 수 없습니다.");
        }
    }

    private List<LottoNumber> toSortedLottoNumbers(List<Integer> numbers) {
        List<Integer> sortedNumbers = new ArrayList<>(numbers);
        Collections.sort(sortedNumbers);// 정렬
        return sortedNumbers.stream()
                .map(LottoNumber::new)
                .toList();
    }

    public List<Integer> getNumbers() {
        return numbers.stream()
                .map(LottoNumber::number)
                .toList();
    }

    public int countMatchingNumbers(Lotto other) {
        return (int) numbers.stream()
                .filter(other::contains)
                .count();
    }

    private boolean contains(   LottoNumber lottoNumber) {
        return numbers.contains(lottoNumber);
    }
}
