package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoNumberGeneratorTest {

    private final LottoNumberGenerator lottoNumberGenerator = new LottoNumberGenerator();

    @Test
    @DisplayName("생성된 로또 번호는 6개이다")
    void generateSixNumbers() {
        List<Integer> numbers = lottoNumberGenerator.generate();

        assertThat(numbers).hasSize(6);
    }

    @Test
    @DisplayName("생성된 로또 번호는 모두 1부터 45 사이이다")
    void generateNumbersInRange() {
        List<Integer> numbers = lottoNumberGenerator.generate();

        assertThat(numbers).allMatch(number -> number >= 1 && number <= 45);
    }

    @Test
    @DisplayName("생성된 로또 번호는 중복되지 않는다")
    void generateNumbersWithoutDuplicate() {
        List<Integer> numbers = lottoNumberGenerator.generate();

        Set<Integer> uniqueNumbers = new HashSet<>(numbers);
        assertThat(uniqueNumbers).hasSize(6);
    }
}