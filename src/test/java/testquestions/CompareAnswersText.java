package testquestions;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pageobject.MainPage;
import testdata.TestDataQA;
import java.time.Duration;
import java.util.Arrays;

// Class of Test answers && questions
@RunWith(Parameterized.class)
public class CompareAnswersText {
    private WebDriver driver;
    private static By question;
    private static By answer;
    private static String textOfAnswer;

    // Constructor
    public CompareAnswersText(By question, By answer, String textOfAnswer) {
        this.question = question;
        this.answer = answer;
        this.textOfAnswer = textOfAnswer;
    }
    // // Parameterized Parameters
    @Parameterized.Parameters

    public static Iterable<Object[]> data(){
        return  Arrays.asList(new Object[][] {
                {TestDataQA.question1, TestDataQA.answer1, TestDataQA.textOfAnswer1},
                {TestDataQA.question2, TestDataQA.answer2, TestDataQA.textOfAnswer2},
                {TestDataQA.question3, TestDataQA.answer3, TestDataQA.textOfAnswer3},
                {TestDataQA.question4, TestDataQA.answer4, TestDataQA.textOfAnswer4},
                {TestDataQA.question5, TestDataQA.answer5, TestDataQA.textOfAnswer5},
                {TestDataQA.question6, TestDataQA.answer6, TestDataQA.textOfAnswer6},
                {TestDataQA.question7, TestDataQA.answer7, TestDataQA.textOfAnswer7},
                {TestDataQA.question8, TestDataQA.answer8, TestDataQA.textOfAnswer8}
        });
    }

    // Annotation Before
    @Before
    public void setUp() {
        //driver = new FireFoxDriver();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        MainPage mainPage = new MainPage(driver);
        mainPage.openWebSite();
        mainPage.scrollPageDown();
        mainPage.clickCookieButton();
    }

    // Annotation Test
    @Test
    public void compareTextAnswers() {
        MainPage mainPage = new MainPage(driver);
        mainPage.clickByQuestion(question);
        mainPage.getTextOfAnswer(answer);
        Assert.assertEquals(mainPage.getTextOfAnswer(answer), textOfAnswer);
    }

    // Annotation After
    @After
    public void tearDown() {
        driver.quit();
    }
}