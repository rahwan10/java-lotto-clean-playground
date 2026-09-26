package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.Test;

class LottoTest {

    @Test
    void 로또는_번호_6개를_오름차순으로_보관한다() {
        Lotto lotto = new Lotto(numbers(6, 1, 4, 2, 5, 3));

        assertThat(lotto.numbers()).extracting(LottoNumber::value)
                .containsExactly(1, 2, 3, 4, 5, 6);
    }

    @Test
    void 로또_번호가_6개가_아니면_예외를_발생시킨다() {
        assertThatThrownBy(() -> new Lotto(numbers(1, 2, 3, 4, 5)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("로또 번호는 6개여야 합니다.");
    }

    @Test
    void 중복된_로또_번호가_있으면_예외를_발생시킨다() {
        assertThatThrownBy(() -> new Lotto(numbers(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("로또 번호는 중복될 수 없습니다.");
    }

    @Test
    void 다른_로또와_일치하는_번호_개수를_계산한다() {
        Lotto lotto = new Lotto(numbers(1, 2, 3, 4, 5, 6));
        Lotto otherLotto = new Lotto(numbers(1, 2, 3, 7, 8, 9));

        assertThat(lotto.countMatchingNumbers(otherLotto).value()).isEqualTo(3);
    }

    @Test
    void 다른_로또와_일치하는_번호가_없으면_0을_반환한다() {
        Lotto lotto = new Lotto(numbers(1, 2, 3, 4, 5, 6));
        Lotto otherLotto = new Lotto(numbers(7, 8, 9, 10, 11, 12));

        assertThat(lotto.countMatchingNumbers(otherLotto).value()).isZero();
    }

    private List<LottoNumber> numbers(int... values) {
        return java.util.Arrays.stream(values)
                .mapToObj(LottoNumber::new)
                .toList();
    }
}
