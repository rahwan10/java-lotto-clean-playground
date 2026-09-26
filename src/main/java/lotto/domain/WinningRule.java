package lotto.domain;

import java.util.List;

/** 일치 번호 개수와 상금으로 구성된 로또 당첨 규칙을 표현한다. */
public final class WinningRule {

    private static final List<WinningRule> RULES = List.of(
            new WinningRule(new MatchCount(3), new Prize(5_000)),
            new WinningRule(new MatchCount(4), new Prize(50_000)),
            new WinningRule(new MatchCount(5), new Prize(1_500_000)),
            new WinningRule(new MatchCount(6), new Prize(2_000_000_000))
    );

    private final MatchCount matchCount;
    private final Prize prize;

    /**
     * 일치 번호 개수와 그에 대응하는 상금을 가진 당첨 규칙을 생성한다.
     *
     * @param matchCount 당첨에 필요한 일치 번호 개수
     * @param prize 해당 조건의 상금
     */
    private WinningRule(MatchCount matchCount, Prize prize) {
        this.matchCount = matchCount;
        this.prize = prize;
    }

    /**
     * 보너스 번호가 없는 로또 당첨 규칙 전체를 반환한다.
     *
     * @return 3개부터 6개 일치까지의 당첨 규칙 목록
     */
    public static List<WinningRule> all() {
        return RULES;
    }

    /**
     * 전달받은 일치 번호 개수가 현재 당첨 규칙과 같은지 확인한다.
     *
     * @param otherMatchCount 비교할 일치 번호 개수
     * @return 현재 규칙의 일치 개수와 같으면 true, 다르면 false
     */
    public boolean matches(MatchCount otherMatchCount) {
        return matchCount.equals(otherMatchCount);
    }

    /** 현재 당첨 규칙에 필요한 일치 번호 개수를 반환한다. */
    public MatchCount matchCount() {
        return matchCount;
    }

    /** 현재 당첨 규칙의 상금을 반환한다. */
    public Prize prize() {
        return prize;
    }
}
