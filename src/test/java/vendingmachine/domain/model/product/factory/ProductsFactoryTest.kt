package vendingmachine.domain.model.product.factory

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource
import vendingmachine.domain.model.product.Product
import vendingmachine.domain.model.product.Products

internal class ProductsFactoryTest {

    @Test
    fun `상품 리스트를 만든다`() {
        Assertions.assertThat(ProductsFactory.create("[콜라,1500,20];[사이다,1000,10]"))
            .usingRecursiveComparison()
            .isEqualTo(Products(listOf(Product("콜라", 1500, 20), Product("사이다", 1000, 10))))
    }

    @ParameterizedTest
    @ValueSource(strings = [";", "이상해", "", "[상품명,이상한 가격,3]"])
    fun `이상한 입력`(products: String) {
        Assertions.assertThatIllegalArgumentException()
            .isThrownBy { ProductsFactory.create(products) }
    }
}