package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class ManualCountTest {

    private final PurchaseAmount purchaseAmount = new PurchaseAmount(14000);

    @DisplayName("수동 구매 개수가 0개 이상 총 구매 가능 개수 이하면 생성된다.")
    @ParameterizedTest
    @ValueSource(ints = {0, 3, 14})
    void createManualCount(int count) {
        ManualCount manualCount = new ManualCount(count, purchaseAmount);

        assertThat(manualCount.getCount()).isEqualTo(count);
    }

    @DisplayName("수동 구매 개수가 음수면 예외가 발생한다.")
    @Test
    void negativeCount() {
        assertThatThrownBy(() -> new ManualCount(-1, purchaseAmount))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("수동 구매 개수가 구매 가능한 개수를 넘으면 예외가 발생한다.")
    @Test
    void exceedCount() {
        assertThatThrownBy(() -> new ManualCount(15, purchaseAmount))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("총 구매 개수에서 수동 개수를 뺀 만큼 자동으로 구매한다.")
    @Test
    void calculateAutoCount() {
        ManualCount manualCount = new ManualCount(3, purchaseAmount);

        assertThat(manualCount.calculateAutoCount()).isEqualTo(11);
    }
}
