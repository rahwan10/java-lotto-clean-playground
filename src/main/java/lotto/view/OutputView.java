package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.Lottos;
import lotto.domain.WinningResult;
import lotto.domain.Rank;

import java.util.List;

public class OutputView {

    private static final List<Rank> PRINT_ORDER = List.of(
            Rank.FOURTH, Rank.THIRD, Rank.SECOND, Rank.FIRST);

    private OutputView() {
    }


    public static void printLottos(Lottos lottos) {
        System.out.println();
        System.out.println(lottos.size() + "개를 구매했습니다.");
        lottos.getLottos().forEach(OutputView::printLotto);
    }

    private static void printLotto(Lotto lotto) {
        System.out.println(lotto.getNumbers());
    }

    public static void printWinningResult(WinningResult winningResult) {
        System.out.println();
        System.out.println("당첨 통계");
        System.out.println("---------");
        PRINT_ORDER.forEach(rank -> printRankResult(rank, winningResult.countOf(rank)));
    }

    private static void printRankResult(Rank rank, int count) {
        System.out.println(rank.getMatchCount() + "개 일치 (" + rank.getPrize() + "원)- " + count + "개");
    }

    public static void printProfitRate(double profitRate) {
        double truncatedProfitRate = Math.floor(profitRate * 100) / 100;
        System.out.println("총 수익률은 " + truncatedProfitRate + "입니다.");
    }
}
