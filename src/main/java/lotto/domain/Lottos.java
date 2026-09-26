package lotto.domain;

import java.util.List;

public class Lottos {
    private final List<Lotto> lottos;

    public Lottos(List<Lotto> lottos) {
        this.lottos = List.copyOf(lottos);
    }

    public List<Lotto> getLottos() {
        return this.lottos;
    }

    public int size() {
        return this.lottos.size();
    }

    public WinningResult match(WinningLotto winningLotto) {
        List<Rank> ranks = lottos.stream()
                .map(winningLotto::match)
                .toList();
        return new WinningResult(ranks);
    }
}
