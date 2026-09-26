package lotto.domain;

/** 하나의 당첨 규칙에 대한 당첨 장수와 총상금을 표현한다. */
public record WinningResult(WinningRule winningRule, WinningCount winningCount) {

    /** 현재 결과의 당첨 기준인 일치 번호 개수를 반환한다. */
    public MatchCount matchCount() {
        return winningRule.matchCount();
    }

    /** 현재 결과의 로또 한 장당 상금을 반환한다. */
    public Prize prize() {
        return winningRule.prize();
    }

    /** 현재 등수에서 발생한 총상금을 계산한다. */
    public Prize totalPrize() {
        return prize().multiply(winningCount);
    }
}
