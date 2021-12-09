package vendingmachine.domain.model.product.factory

import vendingmachine.domain.model.product.Product
import kotlin.reflect.full.declaredMemberProperties

private const val DELIMITER = ","
private const val NAME = 0
private const val PRICE = 1
private const val QUANTITY = 2


object ProductFactory {
    fun create(product: String): Product {
        val properties = product.drop(1)
            .dropLast(1)
            .split(DELIMITER)
            .also { require(it.size == Product::class.declaredMemberProperties.size) { "[ERROR] 상품의 속성 전체를 입력해주세요" } }

        try {
            val price = properties[PRICE].toInt()
            val quantity = properties[QUANTITY].toInt()

            return Product(properties[NAME], price, quantity)
        } catch (e: NumberFormatException) {
            throw IllegalArgumentException("[ERROR] 상품 가격 및 수량은 숫자여야 합니다.")
        }
    }

}
