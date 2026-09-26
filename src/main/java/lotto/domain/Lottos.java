package lotto.domain;

import java.util.List;

/** 구매한 여러 장의 로또를 하나의 컬렉션으로 관리한다. */
public final class Lottos {

    private final List<Lotto> lottos;

    /**
     * 구매한 로또 목록을 외부에서 수정할 수 없는 상태로 보관한다.
     *
     * @param lottos 구매한 로또 목록
     * @throws IllegalArgumentException 구매한 로또가 없는 경우
     */
    public Lottos(List<Lotto> lottos) {
        validateNotEmpty(lottos);
        this.lottos = List.copyOf(lottos);
    }

    /**
     * 구매한 로또 장수를 반환한다.
     *
     * @return 구매한 로또 장수
     */
    public int size() {
        return lottos.size();
    }

    /**
     * 구매한 로또 목록을 반환한다.
     *
     * @return 외부에서 구조를 수정할 수 없는 로또 목록
     */
    public List<Lotto> lottos() {
        return lottos;
    }

    /**
     * 구매한 각 로또가 당첨 번호와 일치하는 번호 개수를 계산한다.
     *
     * @param winningLotto 지난 주 당첨 번호
     * @return 구매한 로또 순서에 따른 일치 번호 개수 목록
     */
    public List<MatchCount> matchCounts(WinningLotto winningLotto) {
        return lottos.stream().map(winningLotto::countMatchingNumbers).toList();
    }

    /**
     * 구매한 로또가 한 장 이상인지 확인한다.
     *
     * @param lottos 확인할 로또 목록
     * @throws IllegalArgumentException 구매한 로또가 없는 경우
     */
    private void validateNotEmpty(List<Lotto> lottos) {
        if (lottos.isEmpty()) {
            throw new IllegalArgumentException("구매한 로또가 한 장 이상이어야 합니다.");
        }
    }
}
