package lotto;

import java.util.ArrayList;
import java.util.List;

public class WinningStatistics {
    private final List<Rank> ranks;

    public WinningStatistics(Lottos lottos, WinningNumbers winningNumbers) {
        this.ranks = createRanks(lottos, winningNumbers);
    }

    private List<Rank> createRanks(Lottos lottos, WinningNumbers winningNumbers) {
        List<Rank> ranks = new ArrayList<>();
        for (Lotto lotto : lottos.getLottos()) {
            ranks.add(createRank(lotto, winningNumbers));
        }
        return ranks;
    }

    private Rank createRank(Lotto lotto, WinningNumbers winningNumbers) {
        int matchCount = lotto.countMatchNumbers(winningNumbers);
        return Rank.valueOf(matchCount);
    }

    public int countRank(Rank rank) {
        int count = 0;
        for (Rank eachRank : ranks) {
            count += countIfSameRank(eachRank, rank);
        }
        return count;
    }

    private int countIfSameRank(Rank eachRank, Rank rank) {
        if (eachRank == rank) {
            return 1;
        }
        return 0;
    }

    public double calculateProfitRate(int purchaseAmount) {
        int totalPrize = calculateTotalPrize();
        return (double) totalPrize / purchaseAmount;
    }

    private int calculateTotalPrize() {
        int totalPrize = 0;
        for (Rank rank : ranks) {
            totalPrize += rank.getPrize();
        }
        return totalPrize;
    }
}