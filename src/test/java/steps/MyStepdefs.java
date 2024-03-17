package steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.Pages;
import pages.Web;

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

    @Then("Check if current URL is HomePage URL")
    public void checkCurrentURL() {
        web.checkCurrentUrl(Web.homePageUrl);
    }

    @Then("Check all page element on Home page are present")
    public void checkAllPageElementOnHomePageArePresent() throws InterruptedException {
        homePage.elementsOnPageChecker();
    }

    @When("Click on Guest Login button")
    public void clickOnGuestLoginButton() {
        homePage.guestLoginButtonClick();
    }

    @Then("Check if I logged in as Guest")
    public void checkIfILoggedInAsGuest() {
        userPage.loginAsGuestAndCheckPresentTabs();
    }

    @And("Check if I Signed in as Registered User")
    public void checkIfISignedInAsRegisteredUser() {
        userPage.loginAsUserAndCheckPresentTabs();
    }

    @When("Click on Sign in button")
    public void clickOnSignInButton() {
        homePage.signUpButtonClick();
    }

    @And("Fill in User login credentials")
    public void fillInUserLoginCredentials() {
        homePage.signInFormFilling();
    }

    @Then("Submit Sign in form")
    public void submitSignInForm() {
        homePage.loginButtonClick();
    }

    @Then("User logout and Home Page Url check")
    public void userLogout() {
        userPage.logout();
        homePage.checkCurrentUrl(Web.homePageUrl);
    }

    @When("Click on SingUp button")
    public void clickOnSingUpButton() {
        homePage.signUpButtonClick();

    }

    @And("Fill in New user credentials")
    public void fillInNewUserCredentials() throws Exception {
        homePage.newUserSignUpFormFillingIn();
    }

    @And("Click Register button")
    public void clickRegisterButton() {
        homePage.registerButtonClick();
    }

    @Then("Check if current URL is UserPage-Garage URL")
    public void checkIfCurrentURLIsUserPageGarageURL() {
        homePage.checkCurrentUrl(Web.garagePageUrl);
    }

    @And("Profile User name is present on Profile page")
    public void profileUserNameIsPresentOnProfilePage() throws Exception {
        profilePage.gotoProfilePage();
        homePage.userProfileNameAndLastnameChecker();
    }
}

