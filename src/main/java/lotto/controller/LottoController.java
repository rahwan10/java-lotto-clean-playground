package lotto.controller;

import lotto.domain.LottoMachine;
import lotto.domain.Lottos;
import lotto.domain.PurchaseAmount;
import lotto.domain.WinningLotto;
import lotto.domain.WinningResult;
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
        Lottos lottos = lottoMachine.sell(purchaseAmount);
        outputView.printLottos(lottos.getLottoNumbers());
        List<Integer> winningNumbers = inputView.readWinningNumbers();
        int bonusNumber = inputView.readBonusNumber();
        WinningLotto winningLotto = new WinningLotto(winningNumbers, bonusNumber);
        WinningResult winningResult = lottos.match(winningLotto);
        outputView.printWinningResult(winningResult);
        outputView.printProfitRate(winningResult.calculateProfitRate(purchaseAmount));
    }
}
