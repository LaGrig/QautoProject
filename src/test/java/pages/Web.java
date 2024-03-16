package pages;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Web {
    public static WebDriver driver;

    public static final String homePageUrl = "https://guest:welcome2qauto@qauto.forstudy.space/";

    public void setup() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        //options.addArguments("--headless");
        driver = new ChromeDriver(options);
    }

    public void closeBrowser() {
        if (driver != null) {
            driver.quit();
        }
    }

    public void goToHomePage(){
        driver.get(homePageUrl);
    }
}
