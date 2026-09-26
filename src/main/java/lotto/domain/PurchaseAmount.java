package lotto.domain;

public class PurchaseAmount {
    private final int money;

    private static final int LOTTO_PRICE = 1000;

    public PurchaseAmount(int money) {
        validateAmount(money);
        validateUnit(money);
        this.money = money;
    }

    private void validateAmount(int money) {
        if (money < LOTTO_PRICE) {
            throw new IllegalArgumentException("최소금액은 1000원부터입니다");
        }
    }

    private void validateUnit(int money) {
        if (money % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException("구입금액은 1000원 단위여야 합니다.");
        }
    }

    public int calculateLottoCount() {
        return this.money / LOTTO_PRICE;
    }

    public int getMoney() {
        return money;
    }

}
