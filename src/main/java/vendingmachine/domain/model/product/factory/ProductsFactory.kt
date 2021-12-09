package vendingmachine.domain.model.product.factory

import vendingmachine.domain.model.product.Products


private const val DELIMITER = ";"

object ProductsFactory {
    fun create(products: String): Products = Products(products.split(DELIMITER)
        .also { require(it.isNotEmpty()) { "[ERROR] 상품을 $DELIMITER 으로 구분해주세요." } }
        .also { it -> require(it.all { it.isNotEmpty() }) { "[ERROR] 잘못된 입력입니다." } }
        .map {
            ProductFactory.create(it)
        })
}
