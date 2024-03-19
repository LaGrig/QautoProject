package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.util.List;
import java.util.Random;

public class GaragePage extends Web{
    public final String addCarButton = "//*[@class='btn btn-primary' and text()='Add car']";
    public final String addCarFormBrandDropdown = "//*[@id='addCarBrand']";
    public final String addCarFormModelDropdown = "//*[@id='addCarModel']";
    public final String addCarFormMileageInput = "//*[@id='addCarMileage']";
    public final String addCarFormAddButton = "//*[text()='Add']";
    public final String BMWX6onPage = "//*[text()='BMW X6']";
    public final String fordFocusOnPage = "(//*[@class='car_name h2'])[1]";
    public final String mileageOnPage = "body > app-root > app-global-layout > div > div > div > app-panel-layout > div > div > div > div.col-lg-9.main-wrapper > div > app-garage > div > div.panel-page_content > div > ul > li:nth-child(1) > app-car > div > div.car-body > app-update-mileage-form > form > input";
    public final String topCarInTheRowEditButton = "(//span[@class='icon icon-edit'])[1]";
    public final String removeCarButton = "//button [@type='button' and text()='Remove car']";
    public final String removeCarConfirmButton = "//button [@type='button' and text()='Remove']";
    public final String saveCarEditForm = "/html/body/ngb-modal-window/div/div/app-edit-car-modal/div[3]/div/button[2]";


    Random rand = new Random();
    int mileage = rand.nextInt(99999) + 1;
    public void addCarButtonClick() throws InterruptedException {
        Thread.sleep(1000);
        driver.findElement(By.xpath(addCarButton)).click();
    }

    public void fillInCarAddCarForm() throws InterruptedException {
        Thread.sleep(1000);
        WebElement dropdownBrand = driver.findElement(By.xpath(addCarFormBrandDropdown));
        Select selectBrand = new Select(dropdownBrand);
        selectBrand.selectByValue("1: 2");

        Thread.sleep(1000);
        WebElement dropdownModel = driver.findElement(By.xpath(addCarFormModelDropdown));
        Select selectModel = new Select(dropdownModel);
        selectModel.selectByValue("8: 9");

        WebElement mileageInput = driver.findElement(By.xpath(addCarFormMileageInput));
        mileageInput.sendKeys(String.valueOf(mileage));

        WebElement addCarFormButton = driver.findElement(By.xpath(addCarFormAddButton));
        addCarFormButton.click();
    }

    public void checkAddedCarIsDisplayedAndRemoveIt() throws InterruptedException {
        checkBMWX6IsDisplayed();
        removeLastAddedCar();
//         не смог реализовать проверку на отсутсвие ранее добавленного автомобиля
//        List<WebElement> settingsLinks = driver.findElements(By.xpath(BMWX6onPage));
//        Assert.assertTrue(settingsLinks.isEmpty());
    }

    public void checkBMWX6IsDisplayed() throws InterruptedException {
        Thread.sleep(2000);
        Assert.assertTrue(driver.findElement(By.xpath(BMWX6onPage)).isDisplayed());
    }

    public void checkFordFocusIsDisplayed() throws InterruptedException {
        Thread.sleep(2000);
        Assert.assertTrue(driver.findElement(By.xpath(fordFocusOnPage)).isDisplayed());
    }

    public void removeLastAddedCar(){
        driver.findElement(By.xpath(topCarInTheRowEditButton)).click();
        driver.findElement(By.xpath(removeCarButton)).click();
        driver.findElement(By.xpath(removeCarConfirmButton)).click();
    }

    public void updateCarData() throws InterruptedException {
        Thread.sleep(1000);
        driver.findElement(By.xpath(topCarInTheRowEditButton)).click();
        Thread.sleep(1000);
        WebElement dropdownBrand = driver.findElement(By.xpath(addCarFormBrandDropdown));
        Select selectBrand = new Select(dropdownBrand);
        selectBrand.selectByValue("2: 3");

        Thread.sleep(1000);
        WebElement dropdownModel = driver.findElement(By.xpath(addCarFormModelDropdown));
        Select selectModel = new Select(dropdownModel);
        selectModel.selectByValue("6: 12");

        WebElement mileageInput = driver.findElement(By.xpath(addCarFormMileageInput));
        mileageInput.clear();
        mileageInput.sendKeys(String.valueOf(mileage));

        driver.findElement(By.xpath(saveCarEditForm)).click();
    }

    public void checkTopCarData(){

    }
}
