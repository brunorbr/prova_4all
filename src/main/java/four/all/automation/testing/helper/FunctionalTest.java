package four.all.automation.testing.helper;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;


public class FunctionalTest {

    public WebDriver driver;

    @BeforeEach
    public void setTimeouts(){
        WebDriverManager.chromedriver().setup();
        this.driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://shopcart-challenge.4all.com/");
    }

    @AfterEach
    public void tearDown(){
        driver.manage().deleteAllCookies();
        driver.close();
    }
}
