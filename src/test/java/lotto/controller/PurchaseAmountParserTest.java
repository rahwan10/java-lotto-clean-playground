package lotto.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

class PurchaseAmountParserTest {

    private final PurchaseAmountParser purchaseAmountParser = new PurchaseAmountParser();

    @Test
    void 구매_금액_문자열을_구매_금액_객체로_변환한다() {
        assertThat(purchaseAmountParser.parse("14000").lottoCount()).isEqualTo(14);
    }

    @Test
    void 숫자가_아닌_구매_금액은_예외를_발생시킨다() {
        assertThatThrownBy(() -> purchaseAmountParser.parse("만원"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("구매 금액은 숫자여야 합니다.");
    }
}
