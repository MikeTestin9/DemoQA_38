package manager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.slf4j.*;
import org.testng.annotations.AfterSuite;

import java.util.concurrent.TimeUnit;

public interface AppManager {
    Logger logger = LoggerFactory.getLogger(AppManager.class);     // org.slf4j

    WebDriver WEB_DRIVER = new ChromeDriver();




    default void init(){
        logger.info("Opening the URL...");
        WEB_DRIVER.navigate().to("https://demoqa.com/");
        logger.info("URL opened successfully.");
        WEB_DRIVER.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);


    }

    @AfterSuite
    default void tearDown(){
//        WEB_DRIVER.quit();
    }

}
