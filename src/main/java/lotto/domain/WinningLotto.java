package lotto.domain;

import java.util.List;

public class WinningLotto {

    private final Lotto winningLotto;

    public WinningLotto(List<Integer> winningNumbers) {
        this.winningLotto = new Lotto(winningNumbers);
    }

    public int countMatchingNumbers(Lotto lotto) {
        return winningLotto.countMatchingNumbers(lotto);
    }
}
