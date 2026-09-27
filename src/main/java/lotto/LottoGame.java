package lotto;

import java.util.List;

public class LottoGame {
    private final InputView inputView;
    private final OutputView outputView;

    public LottoGame() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
    }

    public void start() {
        int purchaseAmount = inputView.readPurchaseAmount();
        Lottos lottos = new Lottos(purchaseAmount);

        outputView.printPurchaseResult(lottos.getLottos().size());
        printAllLottos(lottos);

        List<Integer> winningNumbers = inputView.readWinningNumbers();
        WinningNumbers winning = new WinningNumbers(winningNumbers);
        WinningStatistics statistics = new WinningStatistics(lottos, winning);

        outputView.printWinningStatistics(statistics, purchaseAmount);
    }

    private void printAllLottos(Lottos lottos) {
        for (Lotto lotto : lottos.getLottos()) {
            outputView.printLottoNumbers(lotto.getNumbers());
        }
    }
}