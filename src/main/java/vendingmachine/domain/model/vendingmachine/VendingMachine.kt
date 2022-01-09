package vendingmachine.domain.model.vendingmachine

import vendingmachine.domain.model.coin.CoinValidator
import vendingmachine.domain.model.coin.Coins
import vendingmachine.domain.model.product.Products

class VendingMachine(private var coins: Coins, private var products: Products) {
    var customerPurchaseAmount: Int = 0

    fun insertPurchaseAmount(customerPurchaseAmount: String) =
        CoinValidator.validate(customerPurchaseAmount)
            .let { this.customerPurchaseAmount = customerPurchaseAmount.toInt() }

    fun isCustomerPurchasable(): Boolean =
        customerPurchaseAmount > products.minimumPriceOfRemains()

    fun purchase(purchaseProductName: String) =
        require(
            products.isPresentAndPriceGreaterThanOrEqual(
                purchaseProductName,
                customerPurchaseAmount
            )
        ) { "[ERROR] 구매할 수 없는 상품입니다." }
            .let { customerPurchaseAmount -= products.find(purchaseProductName)!!.price }
            .let { products = products.minus(purchaseProductName) }

    fun extractChange(): Coins {
        return coins.extract(customerPurchaseAmount)
            .also { coins = coins.minus(it) }
            .also { customerPurchaseAmount = 0 }
    }
}