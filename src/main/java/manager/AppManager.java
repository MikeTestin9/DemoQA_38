package manager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;

import java.util.concurrent.TimeUnit;

public interface AppManager {

    WebDriver WEB_DRIVER = new ChromeDriver();

    default void init(){
        WEB_DRIVER.navigate().to("https://demoqa.com/");
        WEB_DRIVER.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }

    @AfterSuite
    default void tearDown(){
//        wd.quit();
    }

}
