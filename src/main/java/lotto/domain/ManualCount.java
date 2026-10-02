package lotto.domain;

public class ManualCount {

    private final int count;
    private final int totalCount;

    public ManualCount(int count, PurchaseAmount purchaseAmount) {
        validateNotNegative(count);
        int totalCount = purchaseAmount.calculateLottoCount();
        validateNotExceed(count, totalCount);
        this.count = count;
        this.totalCount = totalCount;
    }

    public int calculateAutoCount() {
        return this.totalCount - this.count;
    }

    public int getCount() {
        return count;
    }

    private void validateNotNegative(int count) {
        if (count < 0) {
            throw new IllegalArgumentException("수동 로또 개수는 0개이상이어야 합니다.");
        }
    }

    private void validateNotExceed(int count, int totalCount) {
        if (count > totalCount) {
            throw new IllegalArgumentException("수동 로또 개수는 금액최대치보다 작아야합니다");
        }
    }
}
