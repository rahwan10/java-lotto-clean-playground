package lotto.controller;

import lotto.domain.*;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;

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
        ManualCount manualCount = new ManualCount(inputView.readManualCount(), purchaseAmount);
        List<List<Integer>> manualNumbers = inputView.readManualNumbers(manualCount.getCount());
        Lottos lottos = lottoMachine.sell(manualCount, manualNumbers);
        outputView.printLottos(manualCount.getCount(), manualCount.calculateAutoCount(), lottos.getLottoNumbers());
        List<Integer> winningNumbers = inputView.readWinningNumbers();
        int bonusNumber = inputView.readBonusNumber();
        WinningLotto winningLotto = new WinningLotto(winningNumbers, bonusNumber);
        WinningResult winningResult = lottos.match(winningLotto);
        outputView.printWinningResult(winningResult);
        outputView.printProfitRate(winningResult.calculateProfitRate(purchaseAmount));
    }
}
