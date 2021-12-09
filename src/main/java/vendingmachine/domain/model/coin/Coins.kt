package vendingmachine.domain.model.coin

data class Coins(val coins: Map<Coin, Int> = mapOf()) {
    val totalAmount: Int
        get() = coins.map { it.key.amount * it.value }.sum()
}
