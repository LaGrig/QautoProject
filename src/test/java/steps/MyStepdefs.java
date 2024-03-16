package steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.testng.Assert;
import pages.Pages;

public class MyStepdefs extends Pages {

    @Before
    public void chromeSetup() {
        web.setup();
    }

    @After
    public void chromeDriverQuit(){
        web.closeBrowser();
    }

    @Given("I navigate to the Home page")
    public void iNavigateToTheHomePage() {
        web.goToHomePage();
    }

    @Then("Check current URL")
    public void checkCurrentURL() {
        String currURL = homePage.getCurrentWebAddress();
        Assert.assertEquals(currURL, "https://guest:welcome2qauto@qauto.forstudy.space/");
    }

    @Then("Check all page element on page are present")
    public void checkAllPageElementOnPageArePresent() throws InterruptedException {
        homePage.elementsOnPageChecker();
    }

    @When("Click on Guest Login button")
    public void clickOnGuestLoginButton() {
        homePage.guestLoginButtonClick();
    }

    @When("Check if I logged in as Guest")
    public void checkIfILoggedInAsGuest() {
        userPage.loginAsGuestAndCheckPresentTabs();
    }

}

