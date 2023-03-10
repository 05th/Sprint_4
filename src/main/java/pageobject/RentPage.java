package pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

// Class of Rental Page
public class RentPage {
    private WebDriver driver;
    // Rental Page locators
    private final By dateOfRentalField = By.xpath(".//input[@placeholder='* Когда привезти самокат']");
    private final By timeOfRentalField = By.xpath(".//div[contains(@class, 'react-datepicker__day--selected')]");
    private final By timeOfRentalApplet = By.xpath(".//div[@class='Dropdown-placeholder']");
    private final By timeOfRental = By.xpath(".//*[(@role ='option' and text()='трое суток')]");
    private final By choiceColorOfScooterBlack = By.xpath(".//input[@id='black']");
    private final By commentField = By.xpath(".//input[@placeholder='Комментарий для курьера']");
    private final By orderButton = By.xpath(".//button[(@class='Button_Button__ra12g Button_Middle__1CSJM' and text()='Заказать')]");
    private final By orderButtonPushYes = By.xpath(".//button[text()='Да']");
    private final By successOfOrder = By.xpath("//*[@id=\"root\"]/div/div[2]/div[5]/div[1]");

    // Constructor
    public RentPage(WebDriver driver) {
        this.driver = driver;
    }

    // Methods
    public void inputDateOfRental(String anyDate) {
        driver.findElement(dateOfRentalField).click();
        driver.findElement(dateOfRentalField).sendKeys(anyDate);
        driver.findElement(dateOfRentalField).click();
    }

    public void inputRentalTime() {
        driver.findElement(timeOfRentalField).click();
        driver.findElement(timeOfRentalApplet).click();
        driver.findElement(timeOfRental).click();
    }

    public void choiceSamocatColor() {
        driver.findElement(choiceColorOfScooterBlack).click();
    }

    public void sendComment(String comment) {
        driver.findElement(commentField).sendKeys(comment);
    }

    public void clickOrderButton() {
        driver.findElement(orderButton).click();
    }

    public void clickOrderButtonYes() {
        driver.findElement(orderButtonPushYes).click();
    }

    public boolean checkComplitelyOrder() {
        return driver.findElement(successOfOrder).isDisplayed();
    }

    // Combine Methods && Create one of them
    public void setOrder(String anyDate, String comment) {
        inputDateOfRental(anyDate);
        inputRentalTime();
        choiceSamocatColor();
        sendComment(comment);
        clickOrderButton();
        clickOrderButtonYes();
        checkComplitelyOrder();
    }

}