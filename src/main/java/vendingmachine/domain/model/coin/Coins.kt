package vendingmachine.domain.model.coin

data class Coins(val coins: Map<Coin, Int> = mapOf()) {
    val totalAmount: Int
        get() = coins.map { it.key.amount * it.value }.sum()

    fun extract(coinAmount: Int): Coins {
        var remainder = coinAmount
        val result: MutableMap<Coin, Int> = Coin.descendings()
            .associateWith { 0 }
            .toMutableMap()

        Coin.descendings()
            .forEach {
                if (remainder >= it.amount && coins[it]!! > 0) {
                    val coinCount = if (coins[it]!! > remainder / it.amount) remainder / it.amount
                    else coins[it]!!

                    remainder -= coinCount * it.amount
                    result.plusAssign(it to result[it]!! + coinCount)
                }
            }

        return Coins(result)
    }

    fun minus(coins: Coins): Coins {
        return Coins(this.coins
            .map { Pair(it.key, it.value - coins.coins[it.key]!!) }
            .toMap())
    }
}
