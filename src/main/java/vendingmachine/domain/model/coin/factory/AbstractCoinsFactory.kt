package vendingmachine.domain.model.coin.factory

import vendingmachine.domain.model.coin.CoinValidator
import vendingmachine.domain.model.coin.Coins

abstract class AbstractCoinsFactory(private val coin: String) {
    protected abstract fun createCoins(): Coins

    fun create(): Coins = CoinValidator.validate(coin)
        .run { createCoins() }
}