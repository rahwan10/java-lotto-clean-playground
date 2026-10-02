package lotto.domain;

import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class LottoMachine {

    private final LottoNumbersGenerator numbersGenerator;

    public LottoMachine(LottoNumbersGenerator numbersGenerator) {
        this.numbersGenerator = numbersGenerator;
    }

    public Lottos sell(ManualCount manualCount, List<List<Integer>> manualNumbers) {
        validateManualNumbers(manualCount, manualNumbers);
        List<Lotto> manualLottos = issueManualLottos(manualNumbers);
        List<Lotto> autoLottos = issueAutoLottos(manualCount.calculateAutoCount());
        return new Lottos(Stream.concat(manualLottos.stream(), autoLottos.stream()).toList());
    }

    private void validateManualNumbers(ManualCount manualCount, List<List<Integer>> manualNumbers) {
        if (manualNumbers.size() != manualCount.getCount()) {
            throw new IllegalArgumentException("수동 구매 개수와 입력한 번호 줄 수가 일치해야 합니다.");
        }
    }

    private List<Lotto> issueManualLottos(List<List<Integer>> manualNumbers) {
        return manualNumbers.stream()
                .map(Lotto::new)
                .toList();
    }

    private List<Lotto> issueAutoLottos(int autoCount) {
        return IntStream.range(0, autoCount)
                .mapToObj(count -> issueLotto())
                .toList();
    }

    private Lotto issueLotto() {
        return new Lotto(numbersGenerator.generate());
    }
}
