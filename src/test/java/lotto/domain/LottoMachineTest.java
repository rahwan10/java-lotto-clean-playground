package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoMachineTest {

    private final LottoMachine lottoMachine = new LottoMachine(new LottoNumbersGenerator());
    private final PurchaseAmount purchaseAmount = new PurchaseAmount(14000);

    @DisplayName("수동 3장과 자동 11장을 합쳐 구입 금액만큼 로또를 발급한다.")
    @Test
    void sellWithManualAndAuto() {
        ManualCount manualCount = new ManualCount(3, purchaseAmount);
        List<List<Integer>> manualNumbers = List.of(
                List.of(8, 21, 23, 41, 42, 43),
                List.of(3, 5, 11, 16, 32, 38),
                List.of(7, 11, 16, 35, 36, 44));

        Lottos lottos = lottoMachine.sell(manualCount, manualNumbers);

        assertThat(lottos.size()).isEqualTo(14);
    }

    @DisplayName("수동 로또가 입력한 번호 그대로 앞에 담긴다.")
    @Test
    void manualLottosComeFirst() {
        ManualCount manualCount = new ManualCount(2, purchaseAmount);
        List<List<Integer>> manualNumbers = List.of(
                List.of(8, 21, 23, 41, 42, 43),
                List.of(3, 5, 11, 16, 32, 38));

        Lottos lottos = lottoMachine.sell(manualCount, manualNumbers);

        assertThat(lottos.getLottoNumbers().subList(0, 2)).isEqualTo(manualNumbers);
    }

    @DisplayName("수동 구매가 0장이면 전부 자동으로 발급한다.")
    @Test
    void sellWithoutManual() {
        ManualCount manualCount = new ManualCount(0, purchaseAmount);

        Lottos lottos = lottoMachine.sell(manualCount, List.of());

        assertThat(lottos.size()).isEqualTo(14);
    }

    @DisplayName("수동 구매 개수와 입력한 번호 줄 수가 다르면 예외가 발생한다.")
    @Test
    void mismatchedManualNumbers() {
        ManualCount manualCount = new ManualCount(3, purchaseAmount);
        List<List<Integer>> manualNumbers = List.of(
                List.of(8, 21, 23, 41, 42, 43),
                List.of(3, 5, 11, 16, 32, 38));

        assertThatThrownBy(() -> lottoMachine.sell(manualCount, manualNumbers))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
