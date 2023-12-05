import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RegisterPage extends HomePage {
    private By firstName = By.id("input-firstname");
    private By lastName = By.id("input-lastname");
    private By email = By.id("input-email");
    private By telephone = By.id("input-telephone");
    private By password = By.id("input-password");
    private By confirmedPassword = By.id("input-confirm");
    private By newsletter = By.xpath("//label[normalize-space()='No']");
    private By policies = By.xpath("//input[@name='agree']");
    private By continueButton = By.xpath("//input[@value='Continue']");
    private By successMessage = By.xpath("//p[contains(text(),'Congratulations! Your new account has been success')]");

    public RegisterPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }
    public void escribirNombre(String nombre) throws InterruptedException {
        sendText(nombre, firstName);
    }
    public void escribirApellido(String apellido) throws InterruptedException {
        sendText(apellido, lastName);
    }
    public void escribirCorreo(String correo) throws InterruptedException {
        sendText(correo, email);
    }
    public void escribirTelefono(String telefono) throws InterruptedException {
        sendText(telefono, telephone);
    }
    public void escribirContrasena(String contrasena) throws InterruptedException {
        sendText(contrasena, password);
    }
    public void confirmarContrasena(String contrasenaConfirmada) throws InterruptedException {
        sendText(contrasenaConfirmada, confirmedPassword);
    }
    public void suscribirNewsletter() throws InterruptedException {
        this.click(newsletter);
    }
    public void aceptarPoliticas() throws InterruptedException {
        this.click(policies);
    }
    public void clickIngresar() throws InterruptedException {
        this.click(continueButton);
    }

    public void completarRegistro(String nombre,String apellido, String correo, String telefono, String contrasena, String contrasenaConfirmada) throws InterruptedException {
        clickRegistrar();
        sendText(nombre, firstName);
        sendText(apellido, lastName);
        sendText(correo, email);
        sendText(telefono, telephone);
        sendText(contrasena, password);
        sendText(contrasenaConfirmada, confirmedPassword);
        click(continueButton);
    }

    public String obtenerMensajeExito() throws InterruptedException {
        System.out.println("Registro exitoso:\n" + getText(successMessage) + "\n");
        return this.getText(successMessage);
    }

}
