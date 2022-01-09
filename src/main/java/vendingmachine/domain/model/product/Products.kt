package vendingmachine.domain.model.product

data class Products(private val products: List<Product>) {
    fun minimumPriceOfRemains(): Int =
        products.filter { it.isRemain }
            .minOf { it.price }

    fun isPresentAndPriceGreaterThanOrEqual(productName: String, price: Int): Boolean =
        find(productName)
            ?.also { it.isRemain }
            ?.isPriceGreaterThan(price)
            ?: false

    fun find(productName: String): Product? =
        products.find { it.isNameEqual(productName) }

    fun minus(productName: String): Products =
        Products(products
            .map { if (it.isNameEqual(productName)) it.minusQuantity() else it }
            .toList())
}
