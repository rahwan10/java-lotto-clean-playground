package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoMachineTest {

    @DisplayName("구입 금액만큼 로또를 발급한다.")
    @Test
    void sell() {
        LottoMachine lottoMachine = new LottoMachine(new LottoNumbersGenerator());

        Lottos lottos = lottoMachine.sell(new PurchaseAmount(14000));

        assertThat(lottos.size()).isEqualTo(14);
    }
}
