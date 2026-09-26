package lotto.view;

import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.LottoNumber;
import lotto.domain.Lottos;

/** 로또 자동 구매 결과를 콘솔에 출력한다. */
public class OutputView {

    /**
     * 구매한 로또 장수와 각 로또 번호를 콘솔에 출력한다.
     *
     * @param lottos 구매한 여러 장의 로또
     */
    public void printPurchaseResult(Lottos lottos) {
        printBlankLine();
        System.out.println(lottos.size() + "개를 구매했습니다.");
        lottos.lottos().forEach(this::printLotto);
    }

    /**
     * 로또 한 장의 번호를 요구사항에 맞는 목록 형태로 출력한다.
     *
     * @param lotto 출력할 로또 한 장
     */
    private void printLotto(Lotto lotto) {
        List<Integer> lottoValues = lotto.numbers().stream().map(LottoNumber::value).toList();
        System.out.println(lottoValues);
    }

    /** 구매 결과 앞에 출력할 빈 줄을 콘솔에 출력한다. */
    private void printBlankLine() {
        System.out.println();
    }
}
