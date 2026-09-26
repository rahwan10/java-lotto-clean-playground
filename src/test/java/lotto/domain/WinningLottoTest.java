package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WinningLottoTest {

    private final WinningLotto winningLotto = new WinningLotto(List.of(1, 2, 3, 4, 5, 6));

    @DisplayName("번호 3개가 일치하면 4등이다.")
    @Test
    void matchFourth() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 7, 8, 9));

        assertThat(winningLotto.match(lotto)).isEqualTo(Rank.FOURTH);
    }

    @DisplayName("번호 6개가 모두 일치하면 1등이다.")
    @Test
    void matchFirst() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));

        assertThat(winningLotto.match(lotto)).isEqualTo(Rank.FIRST);
    }

    @DisplayName("일치하는 번호가 없으면 꽝이다.")
    @Test
    void matchMiss() {
        Lotto lotto = new Lotto(List.of(7, 8, 9, 10, 11, 12));

        assertThat(winningLotto.match(lotto)).isEqualTo(Rank.MISS);
    }

    @DisplayName("당첨 번호가 6개가 아니면 예외가 발생한다.")
    @Test
    void invalidWinningNumbers() {
        assertThatThrownBy(() -> new WinningLotto(List.of(1, 2, 3, 4, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
