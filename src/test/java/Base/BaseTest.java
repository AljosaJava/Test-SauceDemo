package Base;

import Pages.HomePage;
import Pages.LoginPage;
import Pages.NoirJacket;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.time.Duration;

public class BaseTest {


    public WebDriver driver;
    public WebDriverWait wait;
    public HomePage homePage;
    public LoginPage loginPage;
    public NoirJacket noirJacket;

    @BeforeClass
    public void setUp(){
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        homePage = new HomePage(driver);
        loginPage = new LoginPage(driver);
        noirJacket = new NoirJacket(driver);
    }

    //@AfterClass
    public void tearDown(){
        driver.quit();
    }

}
