package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

public class LottoNumbersGenerator {

    private static final List<Integer> CANDIDATE_NUMBERS = IntStream
            .rangeClosed(LottoNumber.MINIMUM_NUMBER, LottoNumber.MAXIMUM_NUMBER)
            .boxed()
            .toList();

    public List<Integer> generate() {
        List<Integer> shuffledNumbers = new ArrayList<>(CANDIDATE_NUMBERS);
        Collections.shuffle(shuffledNumbers);
        return new ArrayList<>(shuffledNumbers.subList(0, Lotto.LOTTO_NUMBER_COUNT));
    }
}
