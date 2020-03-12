package four.all.automation.testing;

import four.all.automation.CartPage;
import four.all.automation.HomePage;
import four.all.automation.PurchaseConfirmationModal;
import four.all.automation.testing.helper.FunctionalTest;
import four.all.automation.testing.helper.Screenshoter;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.support.ui.WebDriverWait;


public class ChallengeSuite extends FunctionalTest {
    Screenshoter scrShot;
    HomePage home;
    CartPage cart;
    PurchaseConfirmationModal confirmation;
    WebDriverWait wait;

    @Test
    public void Challenge1(){
        scrShot = new Screenshoter(driver);
        wait = new WebDriverWait(driver, 5);
        home = new HomePage(driver);
        home.expandCategories();
        home.selectCategory("Doces");
        home.addAllItemsInCategory();
        wait = new WebDriverWait(driver, 5);
        cart = home.goToCart();
        for(int i = 0; i < 5; i ++){
            cart.addRemoveItem(cart.brigadeiroIncreaseButton);
        }
        confirmation = cart.confirmPurchase();
        scrShot.writeFile();
        Assertions.assertEquals("Pedido realizado com sucesso!", confirmation.getText());
        confirmation.closeConfirmation();
    }

}

