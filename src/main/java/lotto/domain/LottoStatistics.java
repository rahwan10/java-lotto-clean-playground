package lotto.domain;

import java.util.List;

/** 구매한 로또의 당첨 결과와 수익률을 계산해 관리한다. */
public final class LottoStatistics {

    private final List<WinningResult> winningResults;
    private final ProfitRate profitRate;

    /**
     * 로또별 일치 개수와 구매 금액으로 당첨 결과와 수익률을 생성한다.
     *
     * @param matchCounts 구매한 로또마다 계산한 일치 개수 목록
     * @param purchaseAmount 로또 구매 금액
     */
    public LottoStatistics(List<MatchCount> matchCounts, PurchaseAmount purchaseAmount) {
        this.winningResults = createWinningResults(matchCounts);
        this.profitRate = calculateProfitRate(purchaseAmount);
    }

    /** 당첨 규칙별 당첨 장수와 총상금을 반환한다. */
    public List<WinningResult> winningResults() {
        return winningResults;
    }

    /** 총상금과 구매 금액을 반영한 수익률을 반환한다. */
    public ProfitRate profitRate() {
        return profitRate;
    }

    /** 모든 당첨 규칙에 대해 당첨 장수를 계산한 결과 목록을 만든다. */
    private List<WinningResult> createWinningResults(List<MatchCount> matchCounts) {
        return WinningRule.all().stream()
                .map(winningRule -> createWinningResult(winningRule, matchCounts))
                .toList();
    }

    /** 하나의 당첨 규칙에 해당하는 당첨 결과를 만든다. */
    private WinningResult createWinningResult(WinningRule winningRule, List<MatchCount> matchCounts) {
        WinningCount winningCount = countWinningLottos(winningRule, matchCounts);
        return new WinningResult(winningRule, winningCount);
    }

    /** 특정 당첨 규칙을 만족한 로또 장수를 계산한다. */
    private WinningCount countWinningLottos(WinningRule winningRule, List<MatchCount> matchCounts) {
        int winningLottoCount = Math.toIntExact(matchCounts.stream().filter(winningRule::matches).count());
        return new WinningCount(winningLottoCount);
    }

    /** 당첨 결과 전체의 총상금으로 수익률을 계산한다. */
    private ProfitRate calculateProfitRate(PurchaseAmount purchaseAmount) {
        Prize totalPrize = winningResults.stream()
                .map(WinningResult::totalPrize)
                .reduce(Prize.ZERO, Prize::add);
        return ProfitRate.calculate(totalPrize, purchaseAmount);
    }
}
