package lotto;

public enum Rank {
    FIRST(6, 2_000_000_000),
    SECOND(5, 1_500_000),
    THIRD(4, 50_000),
    FOURTH(3, 5_000),
    MISS(0, 0);

    private final int matchCount;
    private final int prize;

    Rank(int matchCount, int prize) {
        this.matchCount = matchCount;
        this.prize = prize;
    }

    public static Rank valueOf(int matchCount) {
        for (Rank rank : values()) {
            if (rank.matchCount == matchCount) {
                return rank;
            }
        }
        return MISS;
    }

    public int getPrize() {
        return prize;
    }

    public int getMatchCount() {
        return matchCount;
    }
}