package methods;

import base.BaseTest;
import helper.ElementHelper;
import helper.StoreHelper;
import model.ElementInfo;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.List;

public class Methods {

    JsMethods jsMethods;
    ActionMethods actionMethods;
    WebDriver driver;
    WebDriverWait wait;

    public Methods() {
        this.driver = BaseTest.driver;
        wait = new WebDriverWait(this.driver, 30);
        this.jsMethods = new JsMethods(this.driver);
        this.actionMethods = new ActionMethods(this.driver);
    }

    public By getBy(String key){
        ElementInfo elementInfo = StoreHelper.INSTANCE.findElementInfoByKey(key);
        return  ElementHelper.getElementInfoToBy(elementInfo);
    }

    public WebElement findElement(String key){

        return wait.until(ExpectedConditions.presenceOfElementLocated(getBy(key)));
    }

    public List<WebElement> findElements(String key){
        return driver.findElements(getBy(key));
    }

    public void clickElement(String key){
       jsMethods.clickItem(findElement(key));
    }

    public void sendKeys(String key, String text){
        findElement(key).sendKeys(text);
    }

    public void hoverElement(String key){
        actionMethods.hoverToElement(findElement(key));
    }

    public void assertText(String text, String textTwo){
        Assert.assertEquals(getText(text),textTwo);
    }

    public String getText(String key){
        return findElement(key).getText();
    }

    public void clickToItemText(String key, String menuName){
        getListElement(key,menuName).click();
    }

    public void hoverToItemText(String key, String menuName){
        actionMethods.hoverToElement(getListElement(key,menuName));
    }

    public void clickListItem(String key){
        List<WebElement> elements = findElements(key);
        elements.get(0).click();
    }

    public WebElement getListElement(String key, String name){

        List<WebElement> elements = findElements(key);

        for(WebElement item : elements){

            if (item.getText().contains(name)){
                return item;
            }
        }

        return null;
    }

    public void waitSec(int sec){
        try {
            Thread.sleep(sec * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}