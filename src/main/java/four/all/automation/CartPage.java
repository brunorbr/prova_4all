package four.all.automation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CartPage extends PageObject {
    public CartPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "add-product-4-qtd")
    public WebElement brigadeiroIncreaseButton;

    @FindBy(id = "add-product-3-qtd")
    public WebElement rissolesIncreaseButton;

    @FindBy(id = "remove-product-3-qtd")
    public WebElement rissoleDecreaseButton;

    @FindBy(id = "finish-checkout-button")
    public WebElement confirmPurchaseButton;

    @FindBy(id = "price-total-checkout")
    public WebElement totalPrice;

    public void addRemoveItem(WebElement ammountButtons){
        ammountButtons.click();
    }

    public PurchaseConfirmationModal confirmPurchase(){
        confirmPurchaseButton.click();
        return new PurchaseConfirmationModal(driver);
    }

    public String getTotalPrice(){
        return totalPrice.getText();
    }

}
