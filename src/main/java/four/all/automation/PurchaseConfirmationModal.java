package four.all.automation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PurchaseConfirmationModal extends PageObject {
    public PurchaseConfirmationModal(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//button[@class='close-modal sc-jqCOkK ippulb']")
    WebElement closeButton;

    @FindBy(xpath = "//h2[@class='sc-dNLxif jyncPa']")
    WebElement confirmationBox;

    public String getText(){
        return confirmationBox.getText();
    }

    public HomePage closeConfirmation(){
        closeButton.click();
        return new HomePage(driver);
    }

}
