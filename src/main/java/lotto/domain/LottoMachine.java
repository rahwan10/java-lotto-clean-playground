package lotto.domain;

import java.util.List;
import java.util.stream.IntStream;

public class LottoMachine {
    private final LottoNumbersGenerator numbersGenerator;

    public LottoMachine(LottoNumbersGenerator numbersGenerator) {
        this.numbersGenerator = numbersGenerator;
    }

    public Lottos sell(PurchaseAmount purchaseAmount) {
        List<Lotto> lottos = IntStream.range(0, purchaseAmount.calculateLottoCount())
                .mapToObj(count -> issueLotto())
                .toList();
        return new Lottos(lottos);
    }

    private Lotto issueLotto() {
        return new Lotto(numbersGenerator.generate());
    }
}
