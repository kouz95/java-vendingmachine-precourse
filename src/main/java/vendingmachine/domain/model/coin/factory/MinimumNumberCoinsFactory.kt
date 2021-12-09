package vendingmachine.domain.model.coin.factory

import vendingmachine.domain.model.coin.Coin
import vendingmachine.domain.model.coin.Coins

class MinimumNumberCoinsFactory(private val coin: String) : AbstractCoinsFactory(coin) {
    override fun createCoins(): Coins {
        var remainder = coin.toInt()

        return Coins(
            Coin.descendings()
                .associateWith {
                    val count = remainder / it.amount
                    remainder -= it.amount * count
                    count
                })
    }
}
