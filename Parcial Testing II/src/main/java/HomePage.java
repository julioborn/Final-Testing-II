import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {
    public static WebDriver driver;
    public static WebDriverWait wait;

    protected By myAccountButton = By.xpath("//ul[@class='list-inline']//li[@class='dropdown']");
    protected By registerButton = By.xpath("//a[normalize-space()='Register']");

    public HomePage(WebDriver driver, WebDriverWait wait) {
        HomePage.driver = driver;
        HomePage.wait = wait;
    }

    public void setUp() {
        driver.manage().window().maximize();
    }

    public void getUrl(String url) {
        driver.get(url);
    }

    public void close() {
        driver.quit();
    }

    protected WebElement elementFind(By locator) throws InterruptedException {
        wait.until(ExpectedConditions.presenceOfElementLocated(locator));
        return driver.findElement(locator);
    }

    protected void sendText(String imputText, By locator) throws InterruptedException {
        this.elementFind(locator).clear();
        this.elementFind(locator).sendKeys(imputText);
    }

    protected void click(By locator) throws InterruptedException {
        wait.until(ExpectedConditions.elementToBeClickable(locator));
        this.elementFind(locator).click();
    }

    protected String getText(By locator) throws InterruptedException {
        return this.elementFind(locator).getText();
    }

    public void clickRegistrar() throws InterruptedException {
        this.click(myAccountButton);
        this.click(registerButton);
    }

}

