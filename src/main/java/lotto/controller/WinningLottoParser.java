package lotto.controller;

import java.util.List;
import java.util.regex.Pattern;
import lotto.domain.Lotto;
import lotto.domain.LottoNumber;
import lotto.domain.WinningLotto;

/** 쉼표로 구분한 당첨 번호 문자열을 WinningLotto로 변환한다. */
public class WinningLottoParser {

    private static final Pattern COMMA = Pattern.compile(",");

    /**
     * 당첨 번호 문자열을 검증된 당첨 로또 객체로 변환한다.
     *
     * @param inputWinningNumbers 사용자가 입력한 쉼표 구분 당첨 번호 문자열
     * @return 번호 6개로 구성된 당첨 로또
     */
    public WinningLotto parse(String inputWinningNumbers) {
        return new WinningLotto(new Lotto(parseNumbers(inputWinningNumbers)));
    }

    /** 쉼표로 구분한 문자열을 각각의 로또 번호 객체로 변환한다. */
    private List<LottoNumber> parseNumbers(String inputWinningNumbers) {
        return COMMA.splitAsStream(inputWinningNumbers)
                .map(String::trim)
                .map(this::parseLottoNumber)
                .toList();
    }

    /** 숫자 문자열 하나를 로또 번호 객체로 변환한다. */
    private LottoNumber parseLottoNumber(String inputNumber) {
        try {
            return new LottoNumber(Integer.parseInt(inputNumber));
        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException("당첨 번호는 숫자여야 합니다.");
        }
    }
}
