package lotto.domain;

/** 로또 당첨으로 받는 상금 금액을 표현한다. */
public record Prize(long value) {

    public static final Prize ZERO = new Prize(0);

    /**
     * 음수가 아닌 상금 금액을 생성한다.
     *
     * @param value 상금 금액
     * @throws IllegalArgumentException 상금이 음수인 경우
     */
    public Prize {
        validateNonNegative(value);
    }

    /**
     * 다른 상금과 현재 상금을 더한다.
     *
     * @param other 더할 상금
     * @return 두 상금을 더한 새 상금 객체
     */
    public Prize add(Prize other) {
        return new Prize(Math.addExact(value, other.value));
    }

    /**
     * 당첨 횟수만큼 현재 상금을 곱한다.
     *
     * @param winningCount 상금이 지급되는 횟수
     * @return 당첨 횟수를 반영한 총상금
     */
    public Prize multiply(WinningCount winningCount) {
        return new Prize(Math.multiplyExact(value, winningCount.value()));
    }

    /**
     * 상금이 음수가 아닌지 확인한다.
     *
     * @param value 확인할 상금 금액
     * @throws IllegalArgumentException 상금이 음수인 경우
     */
    private static void validateNonNegative(long value) {
        if (value < 0) {
            throw new IllegalArgumentException("상금은 음수일 수 없습니다.");
        }
    }
}
