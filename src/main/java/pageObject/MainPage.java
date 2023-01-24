package pageObject;
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

    // Questions && Answers Locators
    public static By question1 = By.id("accordion__heading-0");
    public static By answer1 = By.id("accordion__panel-0");
    public static By question2 = By.id("accordion__heading-1");
    public static By answer2 = By.id("accordion__panel-1");
    public static By question3 = By.id("accordion__heading-2");
    public static By answer3 = By.id("accordion__panel-2");
    public static By question4 = By.id("accordion__heading-3");
    public static By answer4 = By.id("accordion__panel-3");
    public static By question5 = By.id("accordion__heading-4");
    public static By answer5 = By.id("accordion__panel-4");
    public static By question6 = By.id("accordion__heading-5");
    public static By answer6 = By.id("accordion__panel-5");
    public static By question7 = By.id("accordion__heading-6");
    public static By answer7 = By.id("accordion__panel-6");
    public static By question8 = By.id("accordion__heading-7");
    public static By answer8 = By.id("accordion__panel-7");

    // Text of Answers
    public static final String textOfAnswer1 = "Сутки — 400 рублей. Оплата курьеру — наличными или картой.";
    public static final String textOfAnswer2 = "Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим.";
    public static final String textOfAnswer3 = "Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30.";
    public static final String textOfAnswer4 = "Только начиная с завтрашнего дня. Но скоро станем расторопнее.";
    public static final String textOfAnswer5 = "Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010.";
    public static final String textOfAnswer6 = "Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится.";
    public static final String textOfAnswer7 = "Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои.";
    public static final String textOfAnswer8 = "Да, обязательно. Всем самокатов! И Москве, и Московской области.";

    // Constructor
    public MainPage(WebDriver driver){
        this.driver = driver;
    }
    // Methods
    public void openWebSite(){
        driver.get(url);
    }

    public void clickTopOrderButton(){
        driver.findElement(topOrderButton).click();
    }

    public void clickLowerOrderButton(){
        driver.findElement(lowerOrderButton).click();
    }

    public void scrollPageDown(){
        WebElement element = driver.findElement(headerOfQuestions);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element);
    }

    public void clickCookieButton(){
        driver.findElement(cookieButton).click();
    }

    public void clickByQuestion(By question){
        driver.findElement(question).click();
    }

    public String  getTextOfAnswer(By answer){
       return driver.findElement(answer).getText();
    }

}