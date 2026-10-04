package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class PurchaseAmountTest {

    @ParameterizedTest
    @ValueSource(ints = {1_000, 14_000})
    void 구매_금액에_해당하는_로또_장수를_계산한다(int value) {
        PurchaseAmount purchaseAmount = new PurchaseAmount(value);

        assertThat(purchaseAmount.lottoCount()).isEqualTo(value / 1_000);
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 999})
    void 구매_금액이_1000원보다_작으면_예외를_발생시킨다(int value) {
        assertThatThrownBy(() -> new PurchaseAmount(value))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("구매 금액은 1,000원 이상이어야 합니다.");
    }

    @ParameterizedTest
    @ValueSource(ints = {1_001, 14_500})
    void 구매_금액이_1000원_단위가_아니면_예외를_발생시킨다(int value) {
        assertThatThrownBy(() -> new PurchaseAmount(value))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("구매 금액은 1,000원 단위여야 합니다.");
    }
}
