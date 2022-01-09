package vendingmachine.domain.model.product.factory

import vendingmachine.domain.model.product.Product

private const val PREFIX = "["
private const val SUFFIX = "]"
private const val DELIMITER = ","
private const val NAME = 0
private const val PRICE = 1
private const val QUANTITY = 2
private const val PRODUCT_PROPERTIES_SIZE = 3

object ProductFactory {
    fun create(product: String): Product {
        val properties = product
            .also { require(it.startsWith(PREFIX) && it.endsWith(SUFFIX)) { "[ERROR] 상품 입력의 시작과 끝은 \"[\", \"]\" 로 입력되어야 합니다. " } }
            .drop(PREFIX.length)
            .dropLast(SUFFIX.length)
            .split(DELIMITER)
            .also { require(it.size == PRODUCT_PROPERTIES_SIZE) { "[ERROR] 상품의 속성 전체를 입력해주세요" } }

        try {
            val price = properties[PRICE].toInt()
            val quantity = properties[QUANTITY].toInt()

            return Product(properties[NAME], price, quantity)
        } catch (e: NumberFormatException) {
            throw IllegalArgumentException("[ERROR] 상품 가격 및 수량은 숫자여야 합니다.")
        }
    }

}
