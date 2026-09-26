package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;

class LottoPurchaseTest {

    @Test
    void 구매한_로또와_당첨_번호로_당첨_통계를_계산한다() {
        Lottos lottos = new Lottos(List.of(lotto(1, 2, 3, 7, 8, 9), lotto(1, 2, 3, 4, 5, 6)));
        LottoPurchase lottoPurchase = new LottoPurchase(new PurchaseAmount(2_000), lottos);
        WinningLotto winningLotto = new WinningLotto(lotto(1, 2, 3, 4, 5, 6));

        LottoStatistics lottoStatistics = lottoPurchase.calculateStatistics(winningLotto);

        assertThat(lottoStatistics.winningResults())
                .extracting(WinningResult::winningCount)
                .extracting(WinningCount::value)
                .containsExactly(1, 0, 0, 1);
    }

    private Lotto lotto(int... values) {
        return new Lotto(java.util.Arrays.stream(values)
                .mapToObj(LottoNumber::new)
                .toList());
    }
}
