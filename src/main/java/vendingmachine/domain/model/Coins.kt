package vendingmachine.domain.model

import vendingmachine.Coin

data class Coins(private val coins: Map<Coin, Long> = mapOf())
