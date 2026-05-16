package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {

    WebDriver driver;
    WebElement emailField;
    WebElement passwordField;
    WebElement SignInButton;


    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getEmailField() {
        return driver.findElement(By.id("customer_email"));
    }

    public WebElement getPasswordField() {
        return driver.findElement(By.id("customer_password"));
    }

    public WebElement getSignInButton() {
        return driver.findElement(By.cssSelector("input[value='Sign In']"));
    }



    //--akcije

    public void inputEmail(String email){
        getEmailField().clear();
        getEmailField().sendKeys(email);
    }

    public void inputPassword(String password){
        getPasswordField().clear();
        getPasswordField().sendKeys(password);
    }

    public void clickOnSignInButton() {
        getSignInButton().click();
    }

}
