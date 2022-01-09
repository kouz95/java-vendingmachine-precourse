package vendingmachine;

import vendingmachine.domain.model.coin.Coins;
import vendingmachine.domain.model.coin.factory.RandomCoinsFactory;
import vendingmachine.domain.model.product.Products;
import vendingmachine.domain.model.product.factory.ProductsFactory;
import vendingmachine.domain.model.vendingmachine.VendingMachine;
import vendingmachine.view.InputView;
import vendingmachine.view.OutputView;

public class Application {
    public static void main(String[] args) {
        InputView inputView = InputView.INSTANCE;
        OutputView outputView = OutputView.INSTANCE;

        Coins coins = new RandomCoinsFactory(inputView.coinAmount()).create();
        outputView.coinsOfVendingMachine(coins.getCoins());

        Products products = ProductsFactory.INSTANCE.create(inputView.products());
        VendingMachine vendingMachine = new VendingMachine(coins, products);

        vendingMachine.insertPurchaseAmount(inputView.customerPurchaseAmount());

        while (vendingMachine.isCustomerPurchasable()) {
            outputView.customerPurchaseAmount(vendingMachine.getCustomerPurchaseAmount());
            vendingMachine.purchase(inputView.purchaseProductName());
        }

        outputView.customerPurchaseAmount(vendingMachine.getCustomerPurchaseAmount());
        outputView.change(vendingMachine.extractChange().getCoins());
    }
}
