package vendingmachine.domain.model

abstract class AbstractCoinsFactory(private val coin: String) {
    protected abstract fun createCoins(): Coins

    fun create(): Coins = validate()
        .run { createCoins() }

    private fun validate() {
        try {
            coin.toInt()
        } catch (e: NumberFormatException) {
            throw IllegalArgumentException("낫 숫자")
        }

        require(coin.toInt() % Coin.minimum().amount == 0) { "으악" }
    }
}