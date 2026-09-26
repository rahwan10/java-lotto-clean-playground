package lotto.domain;

/** 지난 주 당첨 번호를 표현하고, 구매 로또와의 일치 개수를 계산한다. */
public final class WinningLotto {

    private final Lotto lotto;

    /**
     * 당첨 번호 6개로 구성된 로또를 전달받는다.
     *
     * @param lotto 지난 주 당첨 번호를 가진 로또
     */
    public WinningLotto(Lotto lotto) {
        this.lotto = lotto;
    }

    /**
     * 구매한 로또와 당첨 번호의 일치 개수를 계산한다.
     *
     * @param purchasedLotto 비교할 구매 로또
     * @return 당첨 번호와 일치한 번호 개수
     */
    public MatchCount countMatchingNumbers(Lotto purchasedLotto) {
        return purchasedLotto.countMatchingNumbers(lotto);
    }
}
