import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class OpenNewAccountPage extends HomePage{
    private By openAccountService = By.xpath("//a[normalize-space()='Open New Account']");
    private By typeSelector = By.xpath("//select[@id='type']");
    private By openAccountButton = By.xpath("//input[@value='Open New Account']");
    private By successMessage = By.xpath("//p[normalize-space()='Congratulations, your account is now open.']");


    public OpenNewAccountPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public void clickServicio() throws InterruptedException {
        this.click(openAccountService);
    }

    public void seleccionarTipoDeCuenta(String tipoCuenta) throws InterruptedException {
        Select select = new Select(driver.findElement(typeSelector));
        select.selectByVisibleText(tipoCuenta);
    }

    public void clickFinal() throws InterruptedException {
        this.click(openAccountButton);
    }

    public String obtenerMensajeExito() throws InterruptedException {
        System.out.println("Cuanta abierta exitosamente:\n" + getText(successMessage) + "\n");
        return this.getText(successMessage);
    }

}


