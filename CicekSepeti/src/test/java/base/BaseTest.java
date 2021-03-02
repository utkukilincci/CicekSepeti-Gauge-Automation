package base;

import com.thoughtworks.gauge.AfterScenario;
import com.thoughtworks.gauge.AfterSuite;
import com.thoughtworks.gauge.BeforeScenario;
import com.thoughtworks.gauge.BeforeSuite;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import utils.ReadProperties;
import java.util.ResourceBundle;

public class BaseTest {

    public static WebDriver driver;
    private static ResourceBundle configProp = ReadProperties.getProperties("prop");
    private final Logger logger = LoggerFactory.getLogger(getClass());

    @BeforeScenario
    public void beforePlan(){
        logger.info("======================================");
        logger.info("    Test Baslatildi    ");
        logger.info("======================================");
    }

    @BeforeSuite
    public void setup(){

        String browserName = configProp.getString("SelectedBrowser");
        if (browserName.equals("CHROME")){
            driver = BrowserExec.getChromeDriver(browserName);
        }else {
            driver = BrowserExec.getFirefox();
        }
        driver.manage().window().maximize();
        driver.get(configProp.getString("URL"));
    }

    /*@AfterSuite
    public void tearDown(){
        driver.quit();
    }*/

}