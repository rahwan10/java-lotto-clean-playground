package lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoTest {

    @Test
    @DisplayName("정상적인 로또 번호로 생성할 수 있다")
    void createLottoWithValidNumbers() {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);

        Lotto lotto = new Lotto(numbers);

        assertThat(lotto.getNumbers()).isEqualTo(numbers);
    }

    @Test
    @DisplayName("로또 번호가 6개가 아니면 예외가 발생한다")
    void throwExceptionWhenSizeIsNotSix() {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5);

        assertThatThrownBy(() -> new Lotto(numbers))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("로또 번호에 1보다 작은 값이 있으면 예외가 발생한다")
    void throwExceptionWhenNumberIsLessThanMin() {
        List<Integer> numbers = List.of(0, 2, 3, 4, 5, 6);

        assertThatThrownBy(() -> new Lotto(numbers))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("로또 번호에 45보다 큰 값이 있으면 예외가 발생한다")
    void throwExceptionWhenNumberIsGreaterThanMax() {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 46);

        assertThatThrownBy(() -> new Lotto(numbers))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("로또 번호에 중복이 있으면 예외가 발생한다")
    void throwExceptionWhenDuplicateNumbers() {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 5);

        assertThatThrownBy(() -> new Lotto(numbers))
                .isInstanceOf(IllegalArgumentException.class);
    }
}