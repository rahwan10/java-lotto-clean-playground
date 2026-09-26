package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoTest {

    @DisplayName("로또 번호는 오름차순으로 정렬된다.")
    @Test
    void sortNumbers() {
        Lotto lotto = new Lotto(List.of(45, 3, 21, 8, 1, 30));

        assertThat(lotto.getNumbers()).containsExactly(1, 3, 8, 21, 30, 45);
    }

    @DisplayName("로또 번호가 6개가 아니면 예외가 발생한다.")
    @Test
    void invalidSize() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName(" 중복된 번호가 있으면 예외가 발생한다.")
    @Test
    void invalidDuplicate() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 2, 3, 4, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("다른 로또와 겹치는 번호 개수를 센다.")
    @Test
    void countMatchingNumbers() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Lotto other = new Lotto(List.of(1, 2, 3, 4, 5, 7));

        int matchCount = lotto.countMatchingNumbers(other);

        assertThat(matchCount).isEqualTo(5);
    }
}
