package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class MatchCountTest {

    @ParameterizedTest
    @ValueSource(ints = {0, 3, 6})
    void 일치_개수는_0부터_6까지_생성할_수_있다(int value) {
        MatchCount matchCount = new MatchCount(value);

        assertThat(matchCount.value()).isEqualTo(value);
    }

    @ParameterizedTest
    @ValueSource(ints = {-1, 7})
    void 범위를_벗어난_일치_개수는_예외를_발생시킨다(int value) {
        assertThatThrownBy(() -> new MatchCount(value))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("일치 개수는 0부터 6 사이여야 합니다.");
    }
}
