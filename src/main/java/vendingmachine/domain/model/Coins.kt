package vendingmachine.domain.model

data class Coins(private val coins: Map<Coin, Int> = mapOf()) {
    val totalAmount: Int
        get() = coins.map { it.key.amount * it.value }.sum()
}
