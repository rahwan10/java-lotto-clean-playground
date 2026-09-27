package lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoNumberGenerator {
    private static final int LOTTO_SIZE = 6;
    private static final int MAX_NUMBER = 45;

    public List<Integer> generate(){
        List<Integer> numbers=createNumberPool();
        Collections.shuffle(numbers);
        return numbers.subList(0, LOTTO_SIZE);
    }

    private List<Integer> createNumberPool(){
        List<Integer> numbers = new ArrayList<>();
        for (int number = 1; number <= MAX_NUMBER; number++) {
            numbers.add(number);
        }
        return numbers;
    }
}
