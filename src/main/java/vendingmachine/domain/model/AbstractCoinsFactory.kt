package vendingmachine.domain.model

abstract class AbstractCoinsFactory(private val coin: String) {
    protected abstract fun createCoins(): Coins

    fun create(): Coins = validate()
        .run { createCoins() }

    private fun validate() {
        try {
            coin.toInt()
        } catch (e: NumberFormatException) {
            throw IllegalArgumentException("[ERROR] 금액은 숫자여야 합니다.")
        }

        require(coin.toInt() % Coin.minimum().amount == 0) { "[ERROR] 금액을 동전으로 변환할 수 없습니다." }
    }
}