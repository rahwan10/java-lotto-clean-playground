package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoGenerator {

    /**
     * 1부터 45까지의 번호 중 중복되지 않는 6개를 무작위로 선택해 로또 한 장을 만든다.
     *
     * @return 오름차순으로 정렬된 로또 한 장
     */
    public Lotto generate() {
        List<LottoNumber> shuffledNumbers = shuffleAllNumbers();
        return new Lotto(shuffledNumbers.subList(0, Lotto.NUMBER_COUNT));
    }

    /**
     * 모든 유효한 로또 번호를 수정 가능한 목록으로 복사한 뒤 순서를 섞는다.
     * 원본 목록을 복사하는 이유는 {@link Collections#shuffle(List)}이 목록의 순서를 직접 변경하기 때문이다.
     *
     * @return 중복 없이 무작위 순서로 섞인 1부터 45까지의 로또 번호 목록
     */
    private List<LottoNumber> shuffleAllNumbers() {
        List<LottoNumber> lottoNumbers = new ArrayList<>(LottoNumber.allNumbers());
        Collections.shuffle(lottoNumbers);
        return lottoNumbers;
    }
}
