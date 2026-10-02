package lotto.view;

import lotto.domain.WinningResult;
import lotto.domain.Rank;

import java.util.List;

public class OutputView {

    private static final List<Rank> PRINT_ORDER = List.of(
            Rank.FIFTH, Rank.FOURTH, Rank.THIRD, Rank.SECOND, Rank.FIRST);

    public void printLottos(List<List<Integer>> lottoNumbers) {
        System.out.println();
        System.out.println(lottoNumbers.size() + "개를 구매했습니다.");
        lottoNumbers.forEach(this::printLotto);
    }

    private void printLotto(List<Integer> numbers) {
        List<Integer> sortedNumbers = numbers.stream()
                .sorted()
                .toList();
        System.out.println(sortedNumbers);
    }

    public void printWinningResult(WinningResult winningResult) {
        System.out.println();
        System.out.println("당첨 통계");
        System.out.println("---------");
        PRINT_ORDER.forEach(rank -> printRankResult(rank, winningResult.countOf(rank)));
    }

    private void printRankResult(Rank rank, int count) {
        if (rank == Rank.SECOND) {
            System.out.println(rank.getMatchCount() + "개 일치, 보너스 볼 일치(" + rank.getPrize() + "원) - " + count + "개");
            return;
        }
        System.out.println(rank.getMatchCount() + "개 일치 (" + rank.getPrize() + "원)- " + count + "개");
    }

    public void printProfitRate(double profitRate) {
        double truncatedProfitRate = Math.floor(profitRate * 100) / 100;
        System.out.println("총 수익률은 " + truncatedProfitRate + "입니다.");
    }
}
