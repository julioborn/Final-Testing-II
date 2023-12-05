import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends HomePage{
    private By username = By.xpath("//input[@name='username']");
    private By password = By.xpath("//input[@name='password']");
    private By loginButton = By.xpath("//input[@value='Log In']");

    public LoginPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public void escribirUsuario(String usuario) throws InterruptedException {
        sendText(usuario, username);
    }

    public void escribirContrasena(String contrasena) throws InterruptedException {
        sendText(contrasena, password);
    }

    public void clickLogin() throws InterruptedException {
        this.click(loginButton);
    }

}
