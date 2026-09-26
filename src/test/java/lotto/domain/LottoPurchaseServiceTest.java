package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;

class LottoPurchaseServiceTest {

    @Test
    void 구매_금액에_해당하는_횟수만큼_자동_로또를_생성한다() {
        CountingLottoGenerator lottoGenerator = new CountingLottoGenerator();
        LottoPurchaseService lottoPurchaseService = new LottoPurchaseService(lottoGenerator);

        LottoPurchase lottoPurchase = lottoPurchaseService.purchase(new PurchaseAmount(14_000));

        assertThat(lottoPurchase.lottos().size()).isEqualTo(14);
        assertThat(lottoGenerator.generateCount()).isEqualTo(14);
    }

    private static class CountingLottoGenerator extends LottoGenerator {

        private int count;

        @Override
        public Lotto generate() {
            count++;
            return new Lotto(numbers(1, 2, 3, 4, 5, 6));
        }

        private int generateCount() {
            return count;
        }

        private List<LottoNumber> numbers(int... values) {
            return java.util.Arrays.stream(values)
                    .mapToObj(LottoNumber::new)
                    .toList();
        }
    }
}
