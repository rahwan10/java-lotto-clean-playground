package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class LottoNumberTest {

    @DisplayName("1부터 45 사이의 숫자로 로또 번호를 생성한다.")
    @ParameterizedTest
    @ValueSource(ints = {1, 45})
    void createLottoNumber(int number) {
        LottoNumber lottoNumber = new LottoNumber(number);

        assertThat(lottoNumber.number()).isEqualTo(number);
    }

    @DisplayName("번호가 1부터 45 사이가 아니면 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(ints = {0, 46})
    void invalidRange(int number) {
        assertThatThrownBy(() -> new LottoNumber(number))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
