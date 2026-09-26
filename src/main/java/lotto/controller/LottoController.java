package lotto.controller;

import lotto.domain.LottoPurchaseService;
import lotto.domain.Lottos;
import lotto.domain.PurchaseAmount;
import lotto.view.InputView;
import lotto.view.OutputView;

/** 로또 자동 구매의 입력, 발급, 출력 순서를 조정한다. */
public class LottoController {

    private final InputView inputView;
    private final OutputView outputView;
    private final PurchaseAmountParser purchaseAmountParser;
    private final LottoPurchaseService lottoPurchaseService;

    /**
     * 로또 자동 구매 흐름에 필요한 객체를 전달받는다.
     *
     * @param inputView 콘솔 입력을 담당하는 객체
     * @param outputView 콘솔 출력을 담당하는 객체
     * @param purchaseAmountParser 구매 금액 문자열 변환 객체
     * @param lottoPurchaseService 자동 로또 발급 객체
     */
    public LottoController(InputView inputView, OutputView outputView,
                           PurchaseAmountParser purchaseAmountParser, LottoPurchaseService lottoPurchaseService) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.purchaseAmountParser = purchaseAmountParser;
        this.lottoPurchaseService = lottoPurchaseService;
    }

    /** 구매 금액 입력부터 자동 로또 발급 결과 출력까지의 흐름을 실행한다. */
    public void run() {
        PurchaseAmount purchaseAmount = readPurchaseAmount();
        Lottos purchasedLottos = lottoPurchaseService.purchase(purchaseAmount);
        outputView.printPurchaseResult(purchasedLottos);
    }

    /**
     * 구매 금액을 입력받아 검증된 구매 금액 객체로 변환한다.
     *
     * @return 검증된 구매 금액 객체
     */
    private PurchaseAmount readPurchaseAmount() {
        String inputAmount = inputView.readPurchaseAmount();
        return purchaseAmountParser.parse(inputAmount);
    }
}
