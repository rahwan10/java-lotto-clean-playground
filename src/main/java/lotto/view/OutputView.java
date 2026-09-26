package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.Lottos;

public class OutputView {

    private OutputView() {
    }

    public static void printLottos(Lottos lottos) {
        System.out.println();
        System.out.println(lottos.size() + "개를 구매했습니다.");
        lottos.getLottos().forEach(OutputView::printLotto);
    }

    private static void printLotto(Lotto lotto) {
        System.out.println(lotto.getNumbers());
    }

}
