package lotto;

import java.util.ArrayList;
import java.util.List;

public class Lottos {
    private final List<Lotto> lottos;
    private final LottoNumberGenerator lottoNumberGenerator;

    public Lottos(int purchaseAmount) {
        this.lottoNumberGenerator = new LottoNumberGenerator();
        this.lottos = new ArrayList<>();
        int count = calculateLottoCount(purchaseAmount);
        for (int i = 0; i < count; i++) {
            lottos.add(createLotto());
        }
    }

    private Lotto createLotto() {
        List<Integer> numbers = lottoNumberGenerator.generate();
        return new Lotto(numbers);
    }

    private int calculateLottoCount(int purchaseAmount) {
        return purchaseAmount / 1000;
    }

    public List<Lotto> getLottos() {
        return lottos;
    }
}