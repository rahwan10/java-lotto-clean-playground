package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class LottoGeneratorTest {

    private final LottoGenerator lottoGenerator = new LottoGenerator();

    @Test
    void 자동_생성한_로또는_중복_없는_번호_6개를_가진다() {
        Lotto lotto = lottoGenerator.generate();

        assertThat(lotto.numbers()).hasSize(Lotto.NUMBER_COUNT).doesNotHaveDuplicates();
        assertThat(lotto.numbers()).extracting(LottoNumber::value)
                .allSatisfy(value -> assertThat(value).isBetween(1, 45));
    }
}
