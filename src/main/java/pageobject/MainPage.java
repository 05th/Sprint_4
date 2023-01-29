package pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

// Class of Main Page
public class MainPage {
    private WebDriver driver;
    // Maine Page Locators
    private final String url = "https://qa-scooter.praktikum-services.ru/";
    public static By topOrderButton = By.xpath(".//button[@class='Button_Button__ra12g']");
    public static By lowerOrderButton = By.xpath(".//button[contains(@class, 'Button_Middle__1CSJM')]");
    private final By headerOfQuestions = By.xpath(".//div[text()='Вопросы о важном']");
    private final By cookieButton = By.id("rcc-confirm-button");

    // Constructor
    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    // Methods
    public void openWebSite() {
        driver.get(url);
    }

    public void clickTopOrderButton() {
        driver.findElement(topOrderButton).click();
    }

    public void clickLowerOrderButton() {
        driver.findElement(lowerOrderButton).click();
    }

    public void scrollPageDown() {
        WebElement element = driver.findElement(headerOfQuestions);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
    }

    public void clickCookieButton() {
        driver.findElement(cookieButton).click();
    }

    public void clickByQuestion(By question) {
        driver.findElement(question).click();
    }

    public String getTextOfAnswer(By answer) {
        return driver.findElement(answer).getText();
    }

}