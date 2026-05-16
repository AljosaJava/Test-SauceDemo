package Tests;

import Base.BaseTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {


    @BeforeMethod
    public void pageSetup(){
        driver.manage().window().maximize();
        driver.get("https://sauce-demo.myshopify.com/");
    }

    @Test (priority=1)
    public void UserCanLogIn() throws InterruptedException {
        homePage.clickOnLoginButton();
        loginPage.inputEmail("aljosamudri@yahoo.com");
        loginPage.inputPassword("mojasifra");
        Thread.sleep(3000);
        loginPage.clickOnSignInButton();
    }
}
