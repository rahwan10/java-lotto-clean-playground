package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class LottoNumberTest {

    @ParameterizedTest
    @ValueSource(ints = {1, 45})
    void 로또_번호는_1부터_45까지_생성할_수_있다(int value) {
        LottoNumber lottoNumber = new LottoNumber(value);

        assertThat(lottoNumber.value()).isEqualTo(value);
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 46})
    void 범위를_벗어난_로또_번호는_예외를_발생시킨다(int value) {
        assertThatThrownBy(() -> new LottoNumber(value))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("로또 번호는 1부터 45 사이여야 합니다.");
    }
}
