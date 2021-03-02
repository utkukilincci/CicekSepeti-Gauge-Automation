package methods;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class JsMethods {

    private WebDriver driver;

    public JsMethods(WebDriver driver) {
        this.driver = driver;
    }

    public void clickItem(WebElement element){

        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].click();", element);

    }
}
