package lotto.domain;

import java.util.List;
import java.util.stream.IntStream;

public record LottoNumber(int value) implements Comparable<LottoNumber> {

    private static final int MINIMUM_VALUE = 1;
    private static final int MAXIMUM_VALUE = 45;

    public LottoNumber {
        validateRange(value);
    }

    public static List<LottoNumber> allNumbers() {
        return IntStream.rangeClosed(MINIMUM_VALUE, MAXIMUM_VALUE)
                .mapToObj(LottoNumber::new)
                .toList();
    }

    private static void validateRange(int value) {
        if (value < MINIMUM_VALUE || value > MAXIMUM_VALUE) {
            throw new IllegalArgumentException("로또 번호는 1부터 45 사이여야 합니다.");
        }
    }

    @Override
    public int compareTo(LottoNumber other) {
        return Integer.compare(value, other.value);
    }
}
