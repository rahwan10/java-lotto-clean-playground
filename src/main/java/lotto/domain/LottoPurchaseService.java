package lotto.domain;

import java.util.ArrayList;
import java.util.List;

/** 구매 금액에 맞춰 자동 생성 로또 여러 장을 발급한다. */
public class LottoPurchaseService {

    private final LottoGenerator lottoGenerator;

    /**
     * 자동 로또를 발급할 생성기를 전달받는다.
     *
     * @param lottoGenerator 자동 로또 생성기
     */
    public LottoPurchaseService(LottoGenerator lottoGenerator) {
        this.lottoGenerator = lottoGenerator;
    }

    /**
     * 구매 금액에 해당하는 장수만큼 자동 로또를 생성해 반환한다.
     *
     * @param purchaseAmount 로또 구매 금액
     * @return 자동으로 발급된 여러 장의 로또
     */
    public LottoPurchase purchase(PurchaseAmount purchaseAmount) {
        List<Lotto> purchasedLottos = generateLottos(purchaseAmount);
        return new LottoPurchase(purchaseAmount, new Lottos(purchasedLottos));
    }

    /**
     * 구매 장수만큼 생성기를 호출해 로또 목록을 만든다.
     *
     * @param purchaseAmount 로또 구매 금액
     * @return 구매 장수와 동일한 개수의 로또 목록
     */
    private List<Lotto> generateLottos(PurchaseAmount purchaseAmount) {
        List<Lotto> purchasedLottos = new ArrayList<>();
        for (int count = 0; count < purchaseAmount.lottoCount(); count++) {
            purchasedLottos.add(lottoGenerator.generate());
        }
        return purchasedLottos;
    }
}
