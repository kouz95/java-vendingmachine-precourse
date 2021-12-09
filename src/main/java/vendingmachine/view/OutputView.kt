package vendingmachine.view

import vendingmachine.domain.model.coin.Coin

object OutputView {
    fun print(coins: Map<Coin, Int>) = println("자판기가 보유한 동전")
        .run { coins.forEach { (t, u) -> println("${t.amount}원 - ${u}개") } }
}