package four.all.automation;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class HomePage{

    @FindBy(className = "sc-iAyFgw mBXxg")
    private WebElement dropdownButton;

    @FindBy(id = "category-1")
    private WebElement candyCategory;

    @FindAll({
            @FindBy(xpath = "//button[contains(text(), 'Adicionar')]")
    })
    private List<WebElement> allItemsAddButton;

    public void addItem(WebElement item){
        item.click();
    }

    public void addAllItemsInCategory(List<WebElement> availableItemsList){
        for(WebElement availableItem : availableItemsList){
            availableItem.click();
        }
    }

}