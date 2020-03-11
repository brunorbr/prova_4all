package four.all.automation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import sun.jvm.hotspot.debugger.Page;

import java.util.List;

public class HomePage extends PageObject {
    private WebElement category;

    @FindBy(xpath = "open-categories-btn")
    private WebElement dropdownButton;

    @FindAll({
            @FindBy(xpath = "//button[contains(text(), 'Adicionar')]")
    })
    private List<WebElement> allItemsAddButton;

    @FindBy(id = "cart-btn")
    private WebElement cartButton;

    public HomePage(WebDriver driver){
        super(driver);
    }

    public void addItem(WebElement item){
        item.click();
    }

    public void addAllItemsInCategory(List<WebElement> availableItemsList){
        for(WebElement availableItem : availableItemsList){
            availableItem.click();
        }
    }

    public void selectCategory(String category){

    }

}