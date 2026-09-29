package lotto.domain;

import java.util.List;

public class WinningLotto {

    private final Lotto winningNumbers;

    public WinningLotto(List<Integer> winningNumbers) {
        this.winningNumbers = new Lotto(winningNumbers);
    }

    public Rank match(Lotto lotto) {
        int matchCount = winningNumbers.countMatchingNumbers(lotto);
        return Rank.from(matchCount);
    }

}
