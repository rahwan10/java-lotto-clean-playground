package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoGenerator {

    public Lotto generate() {
        List<LottoNumber> shuffledNumbers = shuffleAllNumbers();
        return new Lotto(shuffledNumbers.subList(0, Lotto.NUMBER_COUNT));
    }

    private List<LottoNumber> shuffleAllNumbers() {
        List<LottoNumber> lottoNumbers = new ArrayList<>(LottoNumber.allNumbers());
        Collections.shuffle(lottoNumbers);
        return lottoNumbers;
    }
}
