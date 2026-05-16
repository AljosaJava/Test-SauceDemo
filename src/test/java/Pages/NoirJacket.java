package Pages;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;


public class NoirJacket {

    WebDriver driver;
    WebElement size;
    WebElement color;
    WebElement addButton;
    WebElement checkOutButton;
    WebElement quantityField;
    WebElement checkOutButtonInCart;

    public NoirJacket(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getSize() {
        return driver.findElement(By.id("product-select-option-0"));
    }

    public void selectSize(String value) {
        Select dropdown = new Select(getSize());
        dropdown.selectByValue(value);
    }

    public WebElement getColor() {
        return driver.findElement(By.id("product-select-option-1"));
    }

    public void selectColor(String value) {
        Select dropdown = new Select(getColor());
        dropdown.selectByValue(value);
    }

    public WebElement getAddButton() {
        return driver.findElement(By.id("add"));
    }

    public WebElement getCheckOutButton() {
        return driver.findElement(By.className("checkout"));
    }

    public WebElement getCheckOutButtonInCart() {
      return driver.findElement(By.id("checkout"));
    }

    public WebElement getQuantityField() {
        return driver.findElement(By.xpath("/html/body/div[3]/div[2]/div/section/form/div[1]/div[2]/div[3]/input"));
        //return driver.findElement(By.id("updates_7805238401"));
        // (By.cssSelector("input[value*='0']"));

    }

    //--
    public void clickAddButton() {
        getAddButton().click();

    }


    public WebElement getCartCount() {
        //return driver.findElement(By.cssSelector(".count.cart-target"));
        return driver.findElement(By.className("count"));
    }

    public String getCartCountText() {
        return getCartCount().getText();
    }


    public void clickOnCheckOutButton() {
        getCheckOutButton().click();
    }

    public void clickOnCheckOutButtonInCart() throws InterruptedException {
        Thread.sleep(2000);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", getCheckOutButtonInCart());
    }


    public void inputQuantity(String quantity) throws InterruptedException {
        Thread.sleep(500);
        getQuantityField().click();
        getQuantityField().clear();
        Thread.sleep(500);
        getQuantityField().sendKeys(quantity);
        Thread.sleep(500);
        getQuantityField().sendKeys(Keys.ENTER);
        Thread.sleep(3000);

    }



    }
