package testOrder;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import pageObject.*;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import java.time.Duration;
import java.util.Arrays;

// Class Make Order Page
@RunWith(Parameterized.class)
public class MakeOrderTest {

    private WebDriver driver;
    private final String firstName;
    private final String lastName;
    private final String address;
    private final String metroStation;
    private final String phoneNumber;
    private final String anyDay;
    private final String comment;

    //Constructor
    public MakeOrderTest(String firstName, String lastName, String address, String metroStation, String phoneNumber, String anyDay, String comment){
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.metroStation = metroStation;
        this.phoneNumber = phoneNumber;
        this.anyDay = anyDay;
        this.comment = comment;
    }
    // Parameterized Parameters
    @Parameterized.Parameters
    public static Iterable<Object[]> data(){
        return  Arrays.asList(new Object[][] {
                {"василий", "иванов", "улица Малая Полянка, 13",
                        "Полянка", "89000050505", "12.08.2022", "важный"},
                {"андрей", "петров", "улица Сергея Макеева, 9к2", "Улица 1905 года", "+79005555667", "15.12.2022",
                        "комментарий" }

        });
    }

    // Annotation Before
    @Before
    public void setUp() {
        //driver = new FireFoxDriver();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        MainPage mainPage = new MainPage(driver);
        mainPage.openWebSite();
        mainPage.clickCookieButton();
    }
    // Annotation test for Top Order Button
    @Test
    public void orderSamokatFromTopOrderButton (){
        // Test Data for Order Page
        MainPage mainPage = new MainPage(driver);
        mainPage.clickTopOrderButton();
        OrderPage orderPage = new OrderPage(driver);
        orderPage.setPersonality(firstName, lastName, address, metroStation, phoneNumber);
        // Test Data for Rent Page
        RentPage rentPage = new RentPage(driver);
        rentPage.setOrder(anyDay,comment);
        Assert.assertTrue(rentPage.checkComplitelyOrder());
    }
    // Annotation test for Lower Order Button
    @Test
    public void orderSamokatFromLowerOrderButton(){
        MainPage mainPage = new MainPage(driver);
        mainPage.clickLowerOrderButton();
        // Test Data for Order Page
        OrderPage orderPage = new OrderPage(driver);
        orderPage.setPersonality(firstName, lastName, address, metroStation, phoneNumber);
        // Test Data for Rent Page
        RentPage rentPage = new RentPage(driver);
        rentPage.setOrder(anyDay,comment);
        Assert.assertTrue(rentPage.checkComplitelyOrder());
    }

    // Annotation After
    @After
    public void tearDown() {
        driver.quit();
    }

}