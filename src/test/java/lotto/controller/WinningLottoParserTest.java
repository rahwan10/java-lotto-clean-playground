package lotto.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.LottoNumber;
import org.junit.jupiter.api.Test;

class WinningLottoParserTest {

    private final WinningLottoParser winningLottoParser = new WinningLottoParser();

    @Test
    void 쉼표로_구분한_당첨_번호를_당첨_로또로_변환한다() {
        assertThat(winningLottoParser.parse("1, 2, 3, 4, 5, 6")
                .countMatchingNumbers(lotto()).value()).isEqualTo(6);
    }

    @Test
    void 숫자가_아닌_당첨_번호는_예외를_발생시킨다() {
        assertThatThrownBy(() -> winningLottoParser.parse("1, 2, 3, 4, 5, six"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("당첨 번호는 숫자여야 합니다.");
    }

    private Lotto lotto() {
        return new Lotto(List.of(
                new LottoNumber(1),
                new LottoNumber(2),
                new LottoNumber(3),
                new LottoNumber(4),
                new LottoNumber(5),
                new LottoNumber(6)
        ));
    }
}
