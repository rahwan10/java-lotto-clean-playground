package lotto.domain;

/** 특정 당첨 조건을 만족한 로또 장수를 표현한다. */
public record WinningCount(int value) {

    /**
     * 음수가 아닌 당첨 장수를 생성한다.
     *
     * @param value 당첨 장수
     * @throws IllegalArgumentException 당첨 장수가 음수인 경우
     */
    public WinningCount {
        validateNonNegative(value);
    }

    /** 당첨 장수가 음수가 아닌지 확인한다. */
    private static void validateNonNegative(int value) {
        if (value < 0) {
            throw new IllegalArgumentException("당첨 장수는 음수일 수 없습니다.");
        }
    }
}
