package lotto.domain;

import java.util.List;

public class WinningResult {

    private final List<Rank> ranks;

    public WinningResult(List<Rank> ranks) {
        this.ranks = List.copyOf(ranks);
    }

    public int countOf(Rank rank) {
        return (int) ranks.stream()
                .filter(each -> each == rank)
                .count();
    }

    public double calculateProfitRate(PurchaseAmount purchaseAmount) {
        return (double) calculateTotalPrize() / purchaseAmount.getMoney();
    }

    private long calculateTotalPrize() {
        return ranks.stream()
                .mapToLong(Rank::getPrize)
                .sum();
    }

}
