package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.within;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WinningResultTest {

    @DisplayName("등수별 당첨 개수를 센다.")
    @Test
    void countOf() {
        WinningResult winningResult = new WinningResult(
                List.of(Rank.FOURTH, Rank.FOURTH, Rank.FIRST, Rank.MISS));

        assertThat(winningResult.countOf(Rank.FOURTH)).isEqualTo(2);
        assertThat(winningResult.countOf(Rank.FIRST)).isEqualTo(1);
        assertThat(winningResult.countOf(Rank.THIRD)).isEqualTo(0);
    }

    @DisplayName("총 당첨금을 구입 금액으로 나눠 수익률을 계산한다.")
    @Test
    void calculateProfitRate() {
        WinningResult winningResult = new WinningResult(
                List.of(Rank.FOURTH, Rank.MISS, Rank.MISS, Rank.MISS, Rank.MISS));

        double profitRate = winningResult.calculateProfitRate(new PurchaseAmount(5000));

        assertThat(profitRate).isCloseTo(1.0, within(0.001));
    }

    @DisplayName("당첨금이 구입 금액보다 적으면 수익률이 1보다 작다.")
    @Test
    void calculateLossProfitRate() {
        WinningResult winningResult = new WinningResult(
                List.of(Rank.FOURTH, Rank.MISS));

        double profitRate = winningResult.calculateProfitRate(new PurchaseAmount(14000));

        assertThat(profitRate).isCloseTo(0.357, within(0.001));
    }
}
