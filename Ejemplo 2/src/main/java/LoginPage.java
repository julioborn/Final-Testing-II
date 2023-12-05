import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends BasePage{
    private By email = By.id("email");

    private By password = By.id("password");

    private By submitButton = By.xpath("//button[@class='btn btn-primario btn-sm' and @type='submit' and text()='Ingresar']");

    private By mensajeError = By.className("form-feedback");

    public LoginPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public void escribirMail(String mail) throws InterruptedException {
        sendText(mail, email);
    }

    public void escribirContrasena(String clave) throws InterruptedException {
        sendText(clave, password);
    }

    public void clickIngresar() throws InterruptedException {
        this.click(submitButton);
    }

    public void completarLogin(String mail ,String clave) throws InterruptedException {
        clickLogin();
        sendText(mail, email);
        sendText(clave, password);
        click(submitButton);
    }

    public String obtenerMensajeError() throws InterruptedException{
        System.out.println("Error: " + getText(mensajeError));
        return this.getText(mensajeError);
    }
}
