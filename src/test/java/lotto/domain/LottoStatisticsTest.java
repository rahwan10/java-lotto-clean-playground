package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.junit.jupiter.api.Test;

class LottoStatisticsTest {

    @Test
    void 일치_개수에_따라_당첨_통계와_수익률을_계산한다() {
        LottoStatistics lottoStatistics = new LottoStatistics(
                List.of(new MatchCount(3), new MatchCount(3), new MatchCount(4)),
                new PurchaseAmount(14_000));

        assertThat(lottoStatistics.winningResults())
                .extracting(WinningResult::winningCount)
                .extracting(WinningCount::value)
                .containsExactly(2, 1, 0, 0);
        assertThat(lottoStatistics.profitRate().value()).isEqualByComparingTo("4.28");
    }

    @Test
    void 수익률은_소수점_둘째_자리까지_버린다() {
        List<MatchCount> matchCounts = new ArrayList<>(Collections.nCopies(13, new MatchCount(0)));
        matchCounts.add(new MatchCount(3));
        LottoStatistics lottoStatistics = new LottoStatistics(matchCounts, new PurchaseAmount(14_000));

        assertThat(lottoStatistics.profitRate().value()).isEqualByComparingTo("0.35");
    }
}
