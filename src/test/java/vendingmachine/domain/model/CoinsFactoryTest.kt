package vendingmachine.domain.model

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test
import vendingmachine.Coin

internal class CoinsFactoryTest {

    @Test
    fun create() {
        Assertions.assertThat(MinimumNumberCoinsFactory.create("450"))
            .isEqualTo(Coins(mapOf(Pair(Coin.COIN_100, 4), Pair(Coin.COIN_50, 1))))
    }
}