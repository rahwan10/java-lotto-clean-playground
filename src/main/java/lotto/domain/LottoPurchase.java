package lotto.domain;

/** 구매 금액과 그 금액으로 발급된 여러 장의 로또를 함께 관리한다. */
public final class LottoPurchase {

    private final PurchaseAmount purchaseAmount;
    private final Lottos lottos;

    /**
     * 구매 금액과 발급된 로또 목록으로 구매 내역을 생성한다.
     *
     * @param purchaseAmount 로또 구매 금액
     * @param lottos 구매한 여러 장의 로또
     */
    public LottoPurchase(PurchaseAmount purchaseAmount, Lottos lottos) {
        this.purchaseAmount = purchaseAmount;
        this.lottos = lottos;
    }

    /** 구매한 여러 장의 로또를 반환한다. */
    public Lottos lottos() {
        return lottos;
    }

    /**
     * 당첨 번호와 비교해 구매한 로또의 당첨 통계와 수익률을 계산한다.
     *
     * @param winningLotto 지난 주 당첨 번호
     * @return 구매 내역에 대한 당첨 통계
     */
    public LottoStatistics calculateStatistics(WinningLotto winningLotto) {
        return new LottoStatistics(lottos.matchCounts(winningLotto), purchaseAmount);
    }
}
