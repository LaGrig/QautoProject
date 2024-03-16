package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import java.util.List;

public class UserPage extends Web{

    //Locators
    //Page objects locators
    public static final String loggedInAsGuestNotifier = "//* [@class='header_bar' and text()='Logged in as guest, any changes will be lost!']";
    private final String sidebarGarageLink = "//a[@class='btn btn-white btn-sidebar sidebar_btn -active' and @href='/panel/garage']";
    private final String headerGarageLink = "//a[@class='btn header-link -active' and @href='/panel/garage']";
    private final String sidebarExpensesLink = "//a[@class='btn btn-white btn-sidebar sidebar_btn' and @href='/panel/expenses']";
    private final String headerExpensesLink = "//a[@class='btn header-link' and @href='/panel/expenses']";
    private final String sidebarInstructionsLink = "//a[@class='btn btn-white btn-sidebar sidebar_btn' and @href='/panel/instructions']";
    private final String headerInstructionsLink = "//a[@class='btn header-link' and @href='/panel/instructions']";
    private final String sidebarProfileLink = "//a [@class='btn btn-white btn-sidebar sidebar_btn -profile' and @href='/panel/profile']";
    private final String headerProfileLink = "//button [@id='userNavDropdown']";  // and contains(text(),' My profile ')]";
    private final String sidebarSettingsLink = "//a [@class='btn btn-white btn-sidebar sidebar_btn' and @href='/panel/settings']";
    private final String logOutButton = "//a[@class='btn btn-link text-danger btn-sidebar sidebar_btn' and text()=' Log out ']";
    private final String logOutDropdownButton = "//button [@class='dropdown-item btn btn-link user-nav_link' and text()='Logout']";
    private final String loginMessage = "//*[contains(text(),'You have been successfully logged in')]";
    private final String registerMessage = "//*[contains(text(),'Registration complete')]";

    // Getters

    public String getUserEmail() { return userEmail; }
    public String getUserPassword() { return userPassword; }
    public String getRegisterMessage() { return registerMessage; }
    public String getLoginMessage() { return loginMessage;  }
    public String getLoggedInAsGuestNotifier() { return loggedInAsGuestNotifier; }
    public String getSidebarGarageLink() { return sidebarGarageLink;}
    public String getHeaderGarageLink() {return headerGarageLink;}
    public String getSidebarExpensesLink() { return sidebarExpensesLink; }
    public String getHeaderExpensesLink() {return headerExpensesLink;}
    public String getSidebarInstructionsLink() { return sidebarInstructionsLink;}
    public String getHeaderInstructionsLink() {return headerInstructionsLink;}
    public String getSidebarProfileLink() { return sidebarProfileLink; }
    public String getHeaderProfileLink() {return headerProfileLink;}
    public String getLogOutButton() {return logOutButton;}
    public String getLogOutDropdownButton() { return logOutDropdownButton;}
    public String getSidebarSettingsLink() { return sidebarSettingsLink;}


    // User predefined credentials
    private final String userEmail = "greg@gmail.com";
    private final String userPassword = "Qwerty123";


    public void loginAsGuestAndCheckPresentTabs(){
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(loggedInAsGuestNotifier)));
        Assert.assertTrue(driver.findElement(By.xpath(getHeaderGarageLink())).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath(getSidebarGarageLink())).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath(getSidebarExpensesLink())).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath(getHeaderExpensesLink())).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath(getSidebarInstructionsLink())).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath(getHeaderInstructionsLink())).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath(getLogOutButton())).isDisplayed());

        List<WebElement> settingsLinks = driver.findElements(By.xpath(getSidebarSettingsLink()));
        Assert.assertTrue(settingsLinks.isEmpty());

        List<WebElement> profileLinks = driver.findElements(By.xpath(getSidebarProfileLink()));
        Assert.assertTrue(profileLinks.isEmpty());
    }
}
