package vendingmachine.domain.model.coin.factory

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource
import vendingmachine.domain.model.coin.Coin
import vendingmachine.domain.model.coin.Coins

internal class CoinsFactoryTest {

    @Test
    fun `최소 동전 생성기`() {
        Assertions.assertThat(MinimumNumberCoinsFactory("450").create()).isEqualTo(
            Coins(
                mapOf(
                    Pair(Coin.COIN_500, 0),
                    Pair(Coin.COIN_100, 4),
                    Pair(Coin.COIN_50, 1),
                    Pair(Coin.COIN_10, 0)
                )
            )
        )
    }

    @ParameterizedTest
    @ValueSource(strings = ["450", "500", "1250", "30170"])
    fun `랜덤 동전 생성기`(coinValue: String) {
        Assertions.assertThat(RandomCoinsFactory(coinValue).create().totalAmount)
            .isEqualTo(coinValue.toInt())
    }

    @ParameterizedTest
    @ValueSource(strings = ["a", "", "-1", "-500", "9"])
    fun `이상한 입력`(coinValue: String) {
        val coinsFactory = object : AbstractCoinsFactory(coinValue) {
            override fun createCoins(): Coins = Coins()
        }

        Assertions.assertThatThrownBy { coinsFactory.create() }
            .isInstanceOf(IllegalArgumentException::class.java)

    }
}