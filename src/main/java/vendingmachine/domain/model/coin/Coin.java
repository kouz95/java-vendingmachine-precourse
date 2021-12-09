package vendingmachine.domain.model.coin;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

public enum Coin {
    COIN_500(500),
    COIN_100(100),
    COIN_50(50),
    COIN_10(10);

    private final int amount;

    Coin(final int amount) {
        this.amount = amount;
    }

    public static List<Coin> descendings() {
        return Arrays.stream(Coin.values())
                .sorted(Comparator.comparingInt(it -> -it.amount))
                .collect(Collectors.toList());
    }

    public static Coin random() {
        return Coin.values()[Randoms.pickNumberInRange(1, Coin.values().length) - 1];
    }

    public static Coin minimum() {
        return Arrays.stream(Coin.values())
                .reduce((coin, coin2) -> {
                    if (coin.amount - coin2.amount < 0) {
                        return coin;
                    }
                    return coin2;
                })
                .orElseThrow(NoSuchElementException::new);

    }

    public int getAmount() {
        return amount;
    }
}
