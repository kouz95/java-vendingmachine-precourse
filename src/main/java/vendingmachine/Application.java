package vendingmachine;

import vendingmachine.domain.model.coin.Coins;
import vendingmachine.domain.model.coin.factory.RandomCoinsFactory;
import vendingmachine.domain.model.product.factory.ProductsFactory;
import vendingmachine.view.InputView;
import vendingmachine.view.OutputView;

public class Application {
    public static void main(String[] args) {
        InputView inputView = InputView.INSTANCE;
        OutputView outputView = OutputView.INSTANCE;

        Coins coins = new RandomCoinsFactory(inputView.coinAmount()).create();
        outputView.print(coins.getCoins());

        ProductsFactory.INSTANCE.create(inputView.products());
    }
}
