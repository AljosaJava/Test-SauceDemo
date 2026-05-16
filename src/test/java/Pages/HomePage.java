package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {

    WebDriver driver;
    WebElement loginButton;
    WebElement myAccount;
    WebElement productNoir;


    public WebElement getLoginButton() {
        return driver.findElement(By.id("customer_login_link"));
    }

    public WebElement getMyAccount() {
        return driver.findElement(By.linkText("My Account"));
    }

    public WebElement getProductNoir() {
        //return driver.findElement(By.linkText("Product Noir"));
        return driver.findElement(By.cssSelector("img[alt='Noir jacket']"));
    }

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }



    //--akcije

    public void clickOnLoginButton(){
        getLoginButton().click();
    }

    public void clickOnProductNoir(){
        getProductNoir().click();
    }
}
