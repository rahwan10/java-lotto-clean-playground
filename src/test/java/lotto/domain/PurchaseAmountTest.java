package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class PurchaseAmountTest {

    @DisplayName("구입 금액으로 살 수 있는 로또 개수를 계산한다.")
    @Test
    void calculateLottoCount() {
        PurchaseAmount purchaseAmount = new PurchaseAmount(14000);

        assertThat(purchaseAmount.calculateLottoCount()).isEqualTo(14);
    }

    @DisplayName("1000원이면 로또 1장을 살 수 있다.")
    @Test
    void minimumAmount() {
        PurchaseAmount purchaseAmount = new PurchaseAmount(1000);

        assertThat(purchaseAmount.calculateLottoCount()).isEqualTo(1);
    }

    @DisplayName("구입 금액이 1000원 미만이면 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(ints = {0, 999})
    void underMinimumAmount(int money) {
        assertThatThrownBy(() -> new PurchaseAmount(money))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("구입 금액이 1000원 단위가 아니면 예외가 발생한다.")
    @Test
    void invalidUnit() {
        assertThatThrownBy(() -> new PurchaseAmount(1500))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
