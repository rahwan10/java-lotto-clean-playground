package lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class OutputView {

    public void printPurchaseResult(int lottoCount) {
        System.out.println();
        System.out.println(lottoCount + "개를 구매했습니다.");
    }

    public void printLottoNumbers(List<Integer> numbers) {
        List<Integer> sortedNumbers = new ArrayList<>(numbers);
        Collections.sort(sortedNumbers);
        System.out.println(sortedNumbers);
    }

    public void printWinningStatistics(WinningStatistics statistics, int purchaseAmount) {
        System.out.println();
        System.out.println("당첨 통계");
        System.out.println("---------");
        printRankResult(statistics, Rank.FOURTH);
        printRankResult(statistics, Rank.THIRD);
        printRankResult(statistics, Rank.SECOND);
        printRankResult(statistics, Rank.FIRST);
        printProfitRate(statistics, purchaseAmount);
    }

    private void printRankResult(WinningStatistics statistics, Rank rank) {
        int count = statistics.countRank(rank);
        System.out.println(rank.getMatchCount() + "개 일치 ("
                + rank.getPrize() + "원)- " + count + "개");
    }

    private void printProfitRate(WinningStatistics statistics, int purchaseAmount) {
        double profitRate = statistics.calculateProfitRate(purchaseAmount);
        double roundedProfitRate = Math.round(profitRate * 100) / 100.0;
        System.out.println("총 수익률은 " + roundedProfitRate + "입니다."
                + "(기준이 1이기 때문에 결과적으로 손해라는 의미임)");
    }
}