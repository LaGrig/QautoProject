package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.After;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import pages.HomePage;
import pages.UserPage;
import pages.Web;

import java.util.List;

import static pages.Web.driver;

public class MyStepdefs{
    HomePage homePage = new HomePage();
    UserPage userPage = new UserPage();

    @Given("I navigate to the Home page")
    public void iNavigateToTheHomePage() {
        homePage.goToHomePage();
    }

    @Then("Check current URL")
    public void checkCurrentURL() {
        String currURL = homePage.getCurrentWebAddress();
        Assert.assertEquals(currURL, "https://guest:welcome2qauto@qauto.forstudy.space/");
    }

    @Then("Check all page element on page are present")
    public void checkAllPageElementOnPageArePresent() {
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

    @Then("Close browser")
    public void closeBrowser() {
        if (driver != null) {
            driver.quit();
        }
    }
}

