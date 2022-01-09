package vendingmachine.view

import vendingmachine.domain.model.coin.Coin

object OutputView {
    fun coinsOfVendingMachine(coins: Map<Coin, Int>) =
        println("자판기가 보유한 동전")
            .run { print(coins) }

    fun customerPurchaseAmount(customerPurchaseAmount: Int) =
        println("투입 금액: ${customerPurchaseAmount}원")

    fun change(coins: Map<Coin, Int>) =
        println("잔돈")
            .run { print(coins) }

    private fun print(coins: Map<Coin, Int>) {
        coins.forEach { (t, u) -> println("${t.amount}원 - ${u}개") }
    }
}