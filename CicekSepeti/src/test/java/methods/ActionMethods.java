package methods;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class ActionMethods {

    private WebDriver driver;

    public ActionMethods(WebDriver driver) {
        this.driver = driver;
    }

    public void hoverToElement(WebElement webElement){
        getActions().moveToElement(webElement).build().perform();
    }

    public Actions getActions(){
        return new Actions(driver);
    }
}
