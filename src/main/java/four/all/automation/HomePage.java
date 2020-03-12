package four.all.automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class HomePage extends PageObject {

    @FindBy(id = "open-categories-btn")
    WebElement dropdownButton;

    @FindAll({
            @FindBy(xpath = "//button[contains(text(), 'Adicionar')]")
    })
    List<WebElement> allItemsAddButton;

    @FindBy(id = "cart-btn")
    WebElement cartButton;

    public HomePage(WebDriver driver){
        super(driver);
    }

    public CartPage goToCart(){
        cartButton.click();
        return new CartPage(driver);
    }

    public void addItem(WebElement item){
        item.click();
    }

    public void addAllItemsInCategory(){
        for(WebElement availableItem : allItemsAddButton){
            availableItem.click();
        }
    }

    public void expandCategories(){
        dropdownButton.click();
    }

    public void selectCategory(String categoryName){
        WebElement category = driver.findElement(By.xpath("//li[contains(text(), '"+ categoryName +"')]"));
        category.click();
    }
}