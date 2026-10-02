package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class RankTest {

    @DisplayName("일치 개수와 보너스 일치 여부에 맞는 등수를 찾는다.")
    @ParameterizedTest
    @CsvSource({
            "6, false, FIRST",
            "5, true, SECOND",
            "5, false, THIRD",
            "4, false, FOURTH",
            "3, false, FIFTH"
    })
    void findRank(int matchCount, boolean bonusMatched, Rank expected) {
        assertThat(Rank.from(matchCount, bonusMatched)).isEqualTo(expected);
    }

    @DisplayName("보너스 번호는 5개 일치일 때만 등수에 영향을 준다.")
    @ParameterizedTest
    @CsvSource({
            "6, true, FIRST",
            "4, true, FOURTH",
            "3, true, FIFTH"
    })
    void bonusMatchedDoesNotAffectOtherRanks(int matchCount, boolean bonusMatched, Rank expected) {
        assertThat(Rank.from(matchCount, bonusMatched)).isEqualTo(expected);
    }

    @DisplayName("일치 개수가 3개 미만이면 보너스 여부와 상관없이 꽝이다.")
    @ParameterizedTest
    @CsvSource({
            "0, false",
            "1, false",
            "2, false",
            "2, true"
    })
    void findMiss(int matchCount, boolean bonusMatched) {
        assertThat(Rank.from(matchCount, bonusMatched)).isEqualTo(Rank.MISS);
    }
}
