package lotto.controller;

import lotto.domain.*;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    private final LottoMachine lottoMachine;

    public LottoController(LottoMachine lottoMachine) {
        this.lottoMachine = lottoMachine;
    }

    public void run() {
        PurchaseAmount purchaseAmount = new PurchaseAmount(InputView.readPurchaseAmount());
        Lottos lottos = lottoMachine.sell(purchaseAmount);
        OutputView.printLottos(lottos);
        WinningLotto winningLotto = new WinningLotto(InputView.readWinningNumbers());
        WinningResult winningResult = lottos.match(winningLotto);
        OutputView.printWinningResult(winningResult);
        OutputView.printProfitRate(winningResult.calculateProfitRate(purchaseAmount));

    }
}
