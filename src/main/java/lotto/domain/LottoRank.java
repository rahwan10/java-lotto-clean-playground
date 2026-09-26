package lotto.domain;

import java.util.List;

/** 일치 번호 개수와 상금으로 구성된 로또 당첨 등수다. */
public enum LottoRank {

    THREE_MATCH(3, 5_000),
    FOUR_MATCH(4, 50_000),
    FIVE_MATCH(5, 1_500_000),
    SIX_MATCH(6, 2_000_000_000L);

    private static final List<LottoRank> RANKS = List.of(values());

    private final int matchCount;
    private final long prize;

    LottoRank(int matchCount, long prize) {
        this.matchCount = matchCount;
        this.prize = prize;
    }

    /** 당첨 통계에 출력할 모든 등수를 순서대로 반환한다. */
    public static List<LottoRank> ranks() {
        return RANKS;
    }

    /** 전달받은 일치 번호 개수가 현재 등수 조건과 같은지 확인한다. */
    public boolean matches(int otherMatchCount) {
        return matchCount == otherMatchCount;
    }

    /** 현재 등수에 필요한 일치 번호 개수를 반환한다. */
    public int matchCount() {
        return matchCount;
    }

    /** 현재 등수의 로또 한 장당 상금을 반환한다. */
    public long prize() {
        return prize;
    }
}
