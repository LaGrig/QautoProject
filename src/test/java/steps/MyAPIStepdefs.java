package steps;


import apiActions.ApiSectionPages;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.io.IOException;

public class MyAPIStepdefs extends ApiSectionPages {

    @Given("Register new user in the system")
    public void registerNewUserInTheSystem() throws IOException {
        auth.registerNewUser();
    }

    @When("Login with new User credentials")
    public void loginWithNewUserCredentials() throws IOException {
        auth.loginNewUser();
    }

    @Then("Logout with logged in user")
    public void logoutWithLoggedInUser() throws IOException {
        auth.logOutNewUser();
    }
}
