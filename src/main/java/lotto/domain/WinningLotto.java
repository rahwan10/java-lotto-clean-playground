package lotto.domain;

import java.util.List;

public class WinningLotto {

    private final Lotto winningNumbers;
    private final LottoNumber bonusNumber;

    public WinningLotto(List<Integer> winningNumbers, int bonusNumber) {
        Lotto lotto = new Lotto(winningNumbers);
        LottoNumber bonus = new LottoNumber(bonusNumber);
        validateDuplicate(lotto, bonus);
        this.winningNumbers = lotto;
        this.bonusNumber = bonus;
    }

    public Rank match(Lotto lotto) {
        int matchCount = winningNumbers.countMatchingNumbers(lotto);
        boolean bonusMatched = isBonusMatched(lotto);
        return Rank.from(matchCount, bonusMatched);
    }

    private void validateDuplicate(Lotto winningNumbers, LottoNumber bonusNumber) {
        if (winningNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException("보너스 번호는 로또 번호와 중복될 수 없습니다.");
        }
    }

    private boolean isBonusMatched(Lotto lotto) {
        return lotto.contains(bonusNumber);
    }

}
