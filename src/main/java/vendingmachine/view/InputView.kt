package vendingmachine.view

import camp.nextstep.edu.missionutils.Console

object InputView {
    fun coinAmount() = println("자판기가 보유하고 있는 금액을 입력해 주세요.")
        .run { Console.readLine() }!!

    fun products() = println("상품명과 가격, 수량을 입력해 주세요.")
        .run { Console.readLine() }!!
}