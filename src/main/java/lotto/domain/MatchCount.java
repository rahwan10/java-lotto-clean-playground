package lotto.domain;

/** 로또 한 장과 당첨 번호 사이에 일치한 번호의 개수를 표현한다. */
public record MatchCount(int value) {

    /**
     * 일치 개수가 0부터 로또 번호 개수 사이인지 검증해 생성한다.
     *
     * @param value 일치한 번호 개수
     * @throws IllegalArgumentException 일치 개수가 0부터 6 사이가 아닌 경우
     */
    public MatchCount {
        validateRange(value);
    }

    /**
     * 일치 개수가 로또 한 장에서 나올 수 있는 범위인지 확인한다.
     *
     * @param value 확인할 일치 개수
     * @throws IllegalArgumentException 일치 개수가 허용 범위를 벗어난 경우
     */
    private static void validateRange(int value) {
        if (value < 0 || value > Lotto.NUMBER_COUNT) {
            throw new IllegalArgumentException("일치 개수는 0부터 6 사이여야 합니다.");
        }
    }
}
