package vendingmachine;

import vendingmachine.domain.model.Coins;
import vendingmachine.domain.model.RandomCoinsFactory;
import vendingmachine.view.InputView;
import vendingmachine.view.OutputView;

public class Application {
    public static void main(String[] args) {
        String coinAmount = InputView.INSTANCE.inputVendingMachineCoinAmount();
        Coins coins = new RandomCoinsFactory(coinAmount).create();
        OutputView.INSTANCE.print(coins.getCoins());
    }
}
