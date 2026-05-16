package Tests;

import Base.BaseTest;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CookieLogin extends BaseTest {

//WebDriverWait wait;

    @BeforeMethod
    public void pageSetup(){

        driver.manage().window().maximize();
        driver.get("https://sauce-demo.myshopify.com/");
        Cookie info = new Cookie("_shopify_essential",":AZ3JtdDFAAH_6quuV3g1u1fOxGZLZ6CIbWsR3En5Pys-__Ss1b1e3QA5F46mv-FcIOXKim4yw9ifaTklU3jvwyl-EjxeZjxZI3zQLo1jPikEdCzsTlWohwxzQoL8EQ0CUaoEDGbkVDAbTMBRS8AaQFNQ5_wYinFGq03n71rFe7fBBshJXjLBLErHDfsePEzd63IXXGZ1bEAON1aZ7yJPjZK7URMFh8h-XXMchqWP2rShcRLTcv5Sd7geGHlJMUGZJxwwJMo9gxAA-nIy03MyTlJNtEAF3YVuGIlg0cDrqgTXhHP5cgEbz86I-N6uMvYX3EpWWC7DInUZ594kxNQeqQW6vVTP6Q75gvBzA7mRS9MD4rlQUl8fIn75mOEi4JA3OPou5rqehsxNmgxoyhDBbGg3ufxL8PK7xdhQDHNDAb4sTdc69fT3Qw-ZKeWdIxkNC0IRrisyxEQBpZufdxDRwyhO30b6JSnUxu3QKos48aU-sBnSgln1FqzC4-jR9aHlMZ-YdiPS8DQmFjxP-AloDrHfNMmmin8q8jPvB9bPG5a-U7zednVdUipAAgkLLw:");
        driver.manage().addCookie(info);
        driver.navigate().refresh();
    }

    @Test (priority = 0)
    public void LoggedInWithACookie() throws InterruptedException {
        Assert.assertTrue(homePage.getMyAccount().isDisplayed());
    }

    @Test (priority = 1)
    public void addASpecificItemWithVariablesToCard () throws InterruptedException {
        Thread.sleep(1000);
        homePage.clickOnProductNoir();
        noirJacket.selectSize("L");
        noirJacket.selectColor("Red");
        noirJacket.clickAddButton();
        Thread.sleep(3000);
        Assert.assertNotEquals(noirJacket.getCartCountText(), "(0)");
        //System.out.println("CartCountText: " + noirJacket.getCartCountText());
    }

    @Test (priority = 2)
    public void checkOutProcess() throws InterruptedException {
        Thread.sleep(1000);
        homePage.clickOnProductNoir();
        noirJacket.selectSize("L");
        noirJacket.selectColor("Red");
        noirJacket.clickAddButton();
        Thread.sleep(3000);
        Assert.assertNotEquals(noirJacket.getCartCountText(), "(0)");
        noirJacket.clickOnCheckOutButton();
        Thread.sleep(2000);
        noirJacket.inputQuantity("5");
        System.out.println(noirJacket.getQuantityField().getAttribute("value"));
        Assert.assertNotEquals(noirJacket.getQuantityField().getAttribute("value"), "1");
        noirJacket.clickOnCheckOutButtonInCart();
        Assert.assertTrue(driver.getCurrentUrl().contains("checkouts"));
    }

}
