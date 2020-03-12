package four.all.automation.testing;

import four.all.automation.CartPage;
import four.all.automation.HomePage;
import four.all.automation.PurchaseConfirmationModal;
import four.all.automation.testing.helper.FunctionalTest;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;


public class ChallengeSuite extends FunctionalTest {
    HomePage home;
    CartPage cart;
    PurchaseConfirmationModal confirmation;
    WebDriverWait wait;
    SoftAssert assertion = new SoftAssert();

    @Test
    public void Challenge1(){
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
        assertion.assertEquals("Pedido realizado com Sucesso!",
                confirmation.getText());
        confirmation.closeConfirmation();
    }

    @Test
    public void Challenge2(){
        home = new HomePage(driver);
        home.expandCategories();
        home.selectCategory("Bebidas");
        home.addAllItemsInCategory();
        wait = new WebDriverWait(driver, 10);
        home.expandCategories();
        home.selectCategory("Todos");
        home.addItem(home.rissolesButton);
        cart = home.goToCart();
        for(int i = 0; i < 9; i++)
            cart.addRemoveItem(cart.rissolesIncreaseButton);
        for(int i = 0; i < 5; i ++)
            cart.addRemoveItem(cart.rissoleDecreaseButton);
        assertion.assertEquals("R$ 36,00", cart.getTotalPrice());
        confirmation = cart.confirmPurchase();
        assertion.assertEquals("Pedido realizado com Sucesso!",
                confirmation.getText());
        confirmation.closeConfirmation();
    }

}

