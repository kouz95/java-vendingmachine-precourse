package vendingmachine.domain.model

interface CoinsFactory {
    fun create(coin: String): Coins
}