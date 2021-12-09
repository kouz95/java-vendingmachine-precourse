package vendingmachine.view

import java.util.*

object InputView {
    private val scanner: Scanner = Scanner(System.`in`)

    fun inputVendingMachineCoinAmount() =
        println("자판기가 보유하고 있는 금액을 입력해 주세요.")
            .run { scanner.nextLine() }!!

}