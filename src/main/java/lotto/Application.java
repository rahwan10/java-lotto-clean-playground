package lotto;

import lotto.controller.LottoController;
import lotto.domain.LottoMachine;
import lotto.domain.LottoNumbersGenerator;
import lotto.view.InputView;
import lotto.view.OutputView;

public class Application {
    public static void main(String[] args) {
        LottoMachine lottoMachine = new LottoMachine(new LottoNumbersGenerator());
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        LottoController lottoController = new LottoController(lottoMachine, inputView, outputView);
        lottoController.run();
    }
}
