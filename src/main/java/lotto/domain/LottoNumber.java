package lotto.domain;

import java.util.List;
import java.util.stream.IntStream;

/** 1부터 45까지의 범위를 가지는 불변 로또 번호 값 객체다. */
public record LottoNumber(int value) implements Comparable<LottoNumber> {

    private static final int MINIMUM_VALUE = 1;
    private static final int MAXIMUM_VALUE = 45;

    /**
     * 전달받은 값이 유효한 로또 번호인지 검증해 번호 객체를 생성한다.
     *
     * @param value 생성할 로또 번호 값
     * @throws IllegalArgumentException 번호가 1부터 45 사이가 아닌 경우
     */
    public LottoNumber {
        validateRange(value);
    }

    /**
     * 자동 생성에 사용할 1부터 45까지의 모든 유효한 로또 번호를 만든다.
     *
     * @return 중복 없이 번호가 하나씩 들어 있는 수정 불가 목록
     */
    public static List<LottoNumber> allNumbers() {
        return IntStream.rangeClosed(MINIMUM_VALUE, MAXIMUM_VALUE)
                .mapToObj(LottoNumber::new)
                .toList();
    }

    /**
     * 하나의 정수 값이 로또 번호로 사용할 수 있는 범위인지 확인한다.
     *
     * @param value 확인할 정수 값
     * @throws IllegalArgumentException 번호가 허용 범위를 벗어난 경우
     */
    private static void validateRange(int value) {
        if (value < MINIMUM_VALUE || value > MAXIMUM_VALUE) {
            throw new IllegalArgumentException("로또 번호는 1부터 45 사이여야 합니다.");
        }
    }

    /**
     * 번호 값의 크기를 기준으로 다른 로또 번호와 자연스러운 순서를 비교한다.
     *
     * @param other 비교할 다른 로또 번호
     * @return 현재 번호가 작으면 음수, 같으면 0, 크면 양수
     */
    @Override
    public int compareTo(LottoNumber other) {
        return Integer.compare(value, other.value);
    }
}
