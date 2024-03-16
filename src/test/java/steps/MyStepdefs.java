import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class MyStepdefs {
    WebDriver driver = new ChromeDriver();
    String homeURL = "https://guest:welcome2qauto@qauto.forstudy.space/";
    @Given("I navigate to the Home page")
    public void iNavigateToTheHomePage() {
        driver.get(homeURL);

    }

    @Then("Check all element on page are presents")
    public void checkAllElementOnPageArePresents() {
        String curURL = driver.getCurrentUrl();
        Assert.assertEquals(curURL, "https://guest:welcome2qauto@qauto.forstudy.space/");
    }
}
