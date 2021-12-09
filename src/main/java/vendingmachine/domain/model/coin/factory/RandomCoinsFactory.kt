package vendingmachine.domain.model.coin.factory

import vendingmachine.domain.model.coin.Coin
import vendingmachine.domain.model.coin.Coins

class RandomCoinsFactory(private val coin: String) : AbstractCoinsFactory(coin) {
    override fun createCoins(): Coins {
        var remainders = coin.toInt()
        val result: MutableMap<Coin, Int> = Coin.values()
            .associateWith { 0 }
            .toMutableMap()

        while (remainders != 0) {
            val random = Coin.random()
            when {
                remainders % random.amount == 0 -> {
                    result += (random to result[random]!! + 1)
                    remainders -= random.amount
                }
            }
        }

        return Coins(result)
    }
}
