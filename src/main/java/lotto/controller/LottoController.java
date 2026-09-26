package lotto.controller;

import lotto.domain.LottoPurchaseService;
import lotto.domain.LottoPurchase;
import lotto.domain.LottoStatistics;
import lotto.domain.PurchaseAmount;
import lotto.domain.WinningLotto;
import lotto.view.InputView;
import lotto.view.OutputView;

/** 로또 구매, 당첨 번호 입력, 통계 출력의 순서를 조정한다. */
public class LottoController {

    private final InputView inputView;
    private final OutputView outputView;
    private final PurchaseAmountParser purchaseAmountParser;
    private final WinningLottoParser winningLottoParser;
    private final LottoPurchaseService lottoPurchaseService;

    /**
     * 로또 구매와 당첨 통계 흐름에 필요한 객체를 전달받는다.
     *
     * @param inputView 콘솔 입력을 담당하는 객체
     * @param outputView 콘솔 출력을 담당하는 객체
     * @param purchaseAmountParser 구매 금액 문자열 변환 객체
     * @param winningLottoParser 당첨 번호 문자열 변환 객체
     * @param lottoPurchaseService 자동 로또 발급 객체
     */
    public LottoController(InputView inputView, OutputView outputView,
                           PurchaseAmountParser purchaseAmountParser, WinningLottoParser winningLottoParser,
                           LottoPurchaseService lottoPurchaseService) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.purchaseAmountParser = purchaseAmountParser;
        this.winningLottoParser = winningLottoParser;
        this.lottoPurchaseService = lottoPurchaseService;
    }

    /** 구매 금액 입력부터 당첨 통계 출력까지의 전체 흐름을 실행한다. */
    public void run() {
        PurchaseAmount purchaseAmount = readPurchaseAmount();
        LottoPurchase lottoPurchase = lottoPurchaseService.purchase(purchaseAmount);
        outputView.printPurchaseResult(lottoPurchase);
        WinningLotto winningLotto = readWinningLotto();
        LottoStatistics lottoStatistics = lottoPurchase.calculateStatistics(winningLotto);
        outputView.printLottoStatistics(lottoStatistics);
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

    /**
     * 당첨 번호를 입력받아 검증된 당첨 로또 객체로 변환한다.
     *
     * @return 검증된 당첨 로또 객체
     */
    private WinningLotto readWinningLotto() {
        String inputWinningNumbers = inputView.readWinningNumbers();
        return winningLottoParser.parse(inputWinningNumbers);
    }
}
