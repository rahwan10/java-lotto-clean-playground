package lotto.controller;

import java.util.List;

import lotto.domain.LottoMachine;
import lotto.domain.Lottos;
import lotto.domain.ManualCount;
import lotto.domain.PurchaseAmount;
import lotto.domain.WinningLotto;
import lotto.domain.WinningResult;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {

    private final LottoMachine lottoMachine;
    private final InputView inputView;
    private final OutputView outputView;

    public LottoController(LottoMachine lottoMachine, InputView inputView, OutputView outputView) {
        this.lottoMachine = lottoMachine;
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        PurchaseAmount purchaseAmount = new PurchaseAmount(inputView.readPurchaseAmount());
        Lottos lottos = purchaseLottos(purchaseAmount);
        showWinningResult(lottos, purchaseAmount);
    }

    private Lottos purchaseLottos(PurchaseAmount purchaseAmount) {
        ManualCount manualCount = new ManualCount(inputView.readManualCount(), purchaseAmount);
        List<List<Integer>> manualNumbers = inputView.readManualNumbers(manualCount.getCount());
        Lottos lottos = lottoMachine.sell(manualCount, manualNumbers);
        outputView.printLottos(
                manualCount.getCount(), manualCount.calculateAutoCount(), lottos.getLottoNumbers());
        return lottos;
    }

    private void showWinningResult(Lottos lottos, PurchaseAmount purchaseAmount) {
        List<Integer> winningNumbers = inputView.readWinningNumbers();
        int bonusNumber = inputView.readBonusNumber();
        WinningLotto winningLotto = new WinningLotto(winningNumbers, bonusNumber);
        WinningResult winningResult = lottos.match(winningLotto);
        outputView.printWinningResult(winningResult);
        outputView.printProfitRate(winningResult.calculateProfitRate(purchaseAmount));
    }
}
