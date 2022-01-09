package vendingmachine.domain.model.product

class Product(private val name: String = "", val price: Int = 0, var quantity: Int = 0) {
    val isRemain: Boolean
        get() = quantity >= 0

    fun isNameEqual(name: String): Boolean =
        this.name == name

    fun isPriceGreaterThan(price: Int): Boolean =
        price >= this.price

    fun minusQuantity() =
        quantity--
            .let { this }
}
