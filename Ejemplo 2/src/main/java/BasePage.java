import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
    public static WebDriver driver;
    public static WebDriverWait wait;

    protected By logoImg = By.className("logo-img");
    protected By loginButton = By.xpath("//a[text()='Iniciar sesión']");
    protected By registerButton = By.xpath("//a[text()='Crear cuenta']");
    protected By nombreUsuario = By.className("txt-nombre");

    public BasePage(WebDriver driver, WebDriverWait wait) {
        BasePage.driver = driver;
        BasePage.wait = wait;
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

    protected void sendKey(CharSequence key, By locator) throws InterruptedException {
        this.elementFind(locator).sendKeys(key);
    }

    protected void click(By locator) throws InterruptedException {
        wait.until(ExpectedConditions.elementToBeClickable(locator));
        this.elementFind(locator).click();
    }

    protected String getText(By locator) throws InterruptedException {
        return this.elementFind(locator).getText();
    }

    public void clickRegistrar() throws InterruptedException {
        this.click(registerButton);
    }

    public void clickLogin() throws InterruptedException {
        this.click(loginButton);
    }

    public String obtenerUsuario() throws InterruptedException {
        System.out.println("Nombre de usuario: " + this.getText(nombreUsuario));
        return this.getText(nombreUsuario);
    }

    public void clickLogo() throws InterruptedException {
        this.click(logoImg);
    }

}
