package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.util.List;

public class GaragePage extends Web{
    public final String addCarButton = "body > app-root > app-global-layout > div > div > div > app-panel-layout > div > div > div > div.col-lg-9.main-wrapper > div > app-garage > div > div.panel-page_heading.d-flex.justify-content-between > button";
    public final String addCarFormBrandDropdown = "//*[@id='addCarBrand']";
    public final String addCarFormModelDropdown = "//*[@id='addCarModel']";
    public final String addCarFormMileageInput = "//*[@id='addCarMileage']";
    public final String addCarFormAddButton = "//*[text()='Add']";
    public final String BMWX6onPage = "//*[text()='BMW X6']";
    public final String topCarInTheRowEditButton = "(//span[@class=\"icon icon-edit\"])[1]";
    public final String removeCarButton = "//button [@type='button' and text()='Remove car']";
    public final String removeCarConfirmButton = "//button [@type='button' and text()='Remove']";



    public void addCarButtonClick() throws InterruptedException {
        Thread.sleep(1000);
        driver.findElement(By.cssSelector(addCarButton)).click();
    }

    public void fillInCarAddCarForm() throws InterruptedException {
        Thread.sleep(1000);
        WebElement dropdownBrand = driver.findElement(By.xpath(addCarFormBrandDropdown));
        Select selectBrand = new Select(dropdownBrand);
        selectBrand.selectByValue("1: 2");
        //selectBrand.selectByVisibleText("BMW");

        Thread.sleep(1000);
        WebElement dropdownModel = driver.findElement(By.xpath(addCarFormModelDropdown));
        Select selectModel = new Select(dropdownModel);
        selectModel.selectByValue("8: 9");
        //selectModel.selectByVisibleText("X6");

        WebElement mileageInput = driver.findElement(By.xpath(addCarFormMileageInput));
        mileageInput.sendKeys(String.valueOf(99));

        WebElement addCarFormButton = driver.findElement(By.xpath(addCarFormAddButton));
        addCarFormButton.click();
    }

    public void checkAddedCarIsDisplayedAndRemoveIt(){
        Assert.assertTrue(driver.findElement(By.xpath(BMWX6onPage)).isDisplayed());
        driver.findElement(By.xpath(topCarInTheRowEditButton)).click();
        driver.findElement(By.xpath(removeCarButton)).click();
        driver.findElement(By.xpath(removeCarConfirmButton)).click();

        List<WebElement> settingsLinks = driver.findElements(By.xpath(BMWX6onPage));
        Assert.assertTrue(settingsLinks.isEmpty());
    }
}
