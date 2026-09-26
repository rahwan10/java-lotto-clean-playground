package lotto.domain;

import java.util.List;

public class WinningLotto {

    private final Lotto winningLotto;

    public WinningLotto(List<Integer> winningNumbers) {
        this.winningLotto = new Lotto(winningNumbers);
    }

    public Rank match(Lotto lotto) {
        int matchCount = winningLotto.countMatchingNumbers(lotto);
        return Rank.from(matchCount);
    }

}
