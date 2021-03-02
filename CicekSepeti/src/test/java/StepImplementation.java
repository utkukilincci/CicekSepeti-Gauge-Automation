import com.thoughtworks.gauge.Step;
import methods.Methods;

import static org.assertj.core.api.Assertions.assertThat;

public class StepImplementation {

    Methods methods;

    public StepImplementation() {
        this.methods = new Methods();
    }

    @Step("<key> elementine tikla")
    public void clickToElement(String key) {
        methods.clickElement(key);
    }

    @Step("<key> elementine <text> metnini yaz")
    public void clickToElement(String key, String text) {
        methods.sendKeys(key,text);
    }

    @Step("<key> elementinin ustune gel")
    public void hoverToElement(String key){
        methods.hoverElement(key);
    }

    @Step("<key> elementi var mi")
    public void checkElement(String key){
        methods.findElement(key);
    }

    @Step("<key> elementinin metni ile <text> ayni mi")
    public void assertTexts(String key, String textTwo){
        methods.assertText(key, textTwo);
    }

    @Step("<key> listesindeki <text> tikla")
    public void clickMenuName(String key, String text){
        methods.clickToItemText(key, text);
    }

    @Step("<key> listesindeki <text> uzerine gel")
    public void clickSubMenu(String key, String text){
        methods.hoverToItemText(key, text);
    }

    @Step("<key> listesindeki ilk elemente tikla")
    public void clickSubMenu(String key){
        methods.clickListItem(key);
    }

    @Step("<sec> saniye bekle")
    public void waitSecond(int sec){
        methods.waitSec(sec);
    }
}