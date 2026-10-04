package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.Test;

class LottosTest {

    @Test
    void 구매한_로또_장수를_반환한다() {
        Lottos lottos = new Lottos(List.of(lotto(), lotto()));

        assertThat(lottos.size()).isEqualTo(2);
    }

    @Test
    void 구매한_로또가_없으면_예외를_발생시킨다() {
        assertThatThrownBy(() -> new Lottos(List.of()))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("구매한 로또가 한 장 이상이어야 합니다.");
    }

    private Lotto lotto() {
        return new Lotto(numbers(1, 2, 3, 4, 5, 6));
    }

    private List<LottoNumber> numbers(int... values) {
        return java.util.Arrays.stream(values)
                .mapToObj(LottoNumber::new)
                .toList();
    }
}
