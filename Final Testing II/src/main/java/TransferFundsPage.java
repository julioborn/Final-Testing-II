import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TransferFundsPage extends HomePage{
    private By goToTransferButton = By.xpath("//a[normalize-space()='Transfer Funds']");
    private By transferFundsText = By.xpath("//h1[normalize-space()='Transfer Funds']");
    private By amount = By.xpath("//input[@id='amount']");
    private By fromAccount = By.xpath("//select[@id='fromAccountId']");
    private By toAccount = By.xpath("//select[@id='toAccountId']");
    private By transferButton = By.xpath("//input[@value='Transfer']");
    private By succesMessage = By.xpath("//h1[normalize-space()='Transfer Complete!']");

    public TransferFundsPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public void clickIrATransferencias() throws InterruptedException {
        this.click(goToTransferButton);
    }

    public void seleccionarCuentaDestino() throws InterruptedException {
        Select select = new Select(driver.findElement(toAccount));
        select.selectByIndex(1);
    }

    public String obtenerTexto() throws InterruptedException {
        return this.getText(transferFundsText);
    }

    public void escribirMonto(String monto) throws InterruptedException {
        sendText(monto, amount);
    }

    public void clickDeCuenta() throws InterruptedException {
        click(fromAccount);
    }

    public void clickTransferir() throws InterruptedException {
        click(transferButton);
    }

    public String obtenerMensaje() throws InterruptedException {
        System.out.println("Transferencia exitosa:\n" + getText(succesMessage) + "\n");
        return this.getText(succesMessage);
    }

}
