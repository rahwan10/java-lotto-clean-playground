package lotto.view;

import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.LottoNumber;
import lotto.domain.LottoPurchase;
import lotto.domain.LottoStatistics;
import lotto.domain.WinningResult;

/** 로또 구매 결과와 당첨 통계를 콘솔에 출력한다. */
public class OutputView {

    /**
     * 구매한 로또 장수와 각 로또 번호를 콘솔에 출력한다.
     *
     * @param lottoPurchase 구매 금액과 구매한 여러 장의 로또
     */
    public void printPurchaseResult(LottoPurchase lottoPurchase) {
        printBlankLine();
        System.out.println(lottoPurchase.lottos().size() + "개를 구매했습니다.");
        lottoPurchase.lottos().lottos().forEach(this::printLotto);
    }

    /**
     * 로또 한 장의 번호를 요구사항에 맞는 목록 형태로 출력한다.
     *
     * @param lotto 출력할 로또 한 장
     */
    private void printLotto(Lotto lotto) {
        List<Integer> lottoValues = lotto.numbers().stream().map(LottoNumber::value).toList();
        System.out.println(lottoValues);
    }

    /** 구매 결과 앞에 출력할 빈 줄을 콘솔에 출력한다. */
    private void printBlankLine() {
        System.out.println();
    }

    /**
     * 당첨 규칙별 당첨 장수와 전체 수익률을 콘솔에 출력한다.
     *
     * @param lottoStatistics 구매한 로또의 당첨 통계
     */
    public void printLottoStatistics(LottoStatistics lottoStatistics) {
        printBlankLine();
        System.out.println("당첨 통계");
        System.out.println("---------");
        lottoStatistics.winningResults().forEach(this::printWinningResult);
        printProfitRate(lottoStatistics);
    }

    /** 당첨 규칙 하나에 해당하는 상금과 당첨 장수를 출력한다. */
    private void printWinningResult(WinningResult winningResult) {
        System.out.println(winningResult.matchCount().value() + "개 일치 ("
                + winningResult.prize().value() + "원)- " + winningResult.winningCount().value() + "개");
    }

    /** 전체 수익률과 기준값 1의 의미를 출력한다. */
    private void printProfitRate(LottoStatistics lottoStatistics) {
        System.out.println("총 수익률은 " + lottoStatistics.profitRate().value()
                + "입니다.(기준이 1이기 때문에 결과적으로 손해라는 의미임)");
    }
}
