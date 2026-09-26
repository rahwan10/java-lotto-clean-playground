package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class RankTest {

    @DisplayName("일치 개수에 맞는 등수를 찾는다.")
    @ParameterizedTest
    @CsvSource({"6, FIRST", "5, SECOND", "4, THIRD", "3, FOURTH"})
    void findRank(int matchCount, Rank expected) {
        assertThat(Rank.from(matchCount)).isEqualTo(expected);
    }

    @DisplayName("일치 개수가 3개 미만이면 꽝이다.")
    @ParameterizedTest
    @CsvSource({"0", "1", "2"})
    void findMiss(int matchCount) {
        assertThat(Rank.from(matchCount)).isEqualTo(Rank.MISS);
    }
}
