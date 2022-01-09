package vendingmachine.domain.model.coin

object CoinValidator {
    fun validate(coin: String) {
        try {
            coin.toInt()
        } catch (e: NumberFormatException) {
            throw IllegalArgumentException("[ERROR] 금액은 숫자여야 합니다.")
        }

        require(0 == coin.toInt().rem(Coin.minimum().amount)) { "[ERROR] 금액을 동전으로 변환할 수 없습니다." }
        require(Coin.minimum().amount <= coin.toInt()) { "[ERROR] 금액은 최소 ${Coin.minimum().amount} 이상이어야 합니다." }
    }
}
