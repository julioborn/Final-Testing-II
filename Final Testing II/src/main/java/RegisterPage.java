import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RegisterPage extends HomePage{
    private By goToRegisterButton = By.xpath("//a[normalize-space()='Register']");
    private By firstName = By.xpath("//input[@id='customer.firstName']");
    private By lastName = By.xpath("//input[@id='customer.lastName']");
    private By address = By.xpath("//input[@id='customer.address.street']");
    private By city = By.xpath("//input[@id='customer.address.city']");
    private By state = By.xpath("//input[@id='customer.address.state']");
    private By zipCode = By.xpath("//input[@id='customer.address.zipCode']");
    private By phone = By.xpath("//input[@id='customer.phoneNumber']");
    private By ssn = By.xpath("//input[@id='customer.ssn']");
    private By username = By.xpath("//input[@id='customer.username']");
    private By password = By.xpath("//input[@id='customer.password']");
    private By confirmedPassword = By.xpath("//input[@id='repeatedPassword']");
    private By registerButton = By.xpath("//input[@value='Register']");
    private By successMessage = By.xpath("//p[contains(text(),'Your account was created successfully. You are now')]");


    public RegisterPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public void clickIrRegistrar() throws InterruptedException {
        this.click(goToRegisterButton);
    }
    public void escribirNombre(String nombre) throws InterruptedException {
        sendText(nombre, firstName);
    }
    public void escribirApellido(String apellido) throws InterruptedException {
        sendText(apellido, lastName);
    }
    public void escribirDireccion(String direccion) throws InterruptedException {
        sendText(direccion, address);
    }
    public void escribirCiudad(String ciudad) throws InterruptedException {
        sendText(ciudad, city);
    }
    public void escribirEstado(String estado) throws InterruptedException {
        sendText(estado, state);
    }
    public void escribirCodigoPostal(String codigoPostal) throws InterruptedException {
        sendText(codigoPostal, zipCode);
    }
    public void escribirTelefono(String telefono) throws InterruptedException {
        sendText(telefono, phone);
    }
    public void escribirSeguro(String seguro) throws InterruptedException {
        sendText(seguro, ssn);
    }
    public void escribirUsuario(String usuario) throws InterruptedException {
        sendText(usuario, username);
    }
    public void escribirContrasena(String contrasena) throws InterruptedException {
        sendText(contrasena, password);
    }
    public void confirmarContrasena(String contrasenaConfirmada) throws InterruptedException {
        sendText(contrasenaConfirmada, confirmedPassword);
    }
    public void clickRegistrar() throws InterruptedException {
        this.click(registerButton);
    }

    public String obtenerMensajeExito() throws InterruptedException {
        System.out.println("Registro exitoso:\n" + getText(successMessage) + "\n");
        return this.getText(successMessage);
    }

}
