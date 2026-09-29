package lotto.controller;

import lotto.domain.LottoMachine;
import lotto.domain.Lottos;
import lotto.domain.PurchaseAmount;
import lotto.domain.WinningLotto;
import lotto.domain.WinningResult;
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
        OutputView.printLottos(lottos.getLottoNumbers());
        WinningLotto winningLotto = new WinningLotto(InputView.readWinningNumbers());
        WinningResult winningResult = lottos.match(winningLotto);
        OutputView.printWinningResult(winningResult);
        OutputView.printProfitRate(winningResult.calculateProfitRate(purchaseAmount));

    }
}
