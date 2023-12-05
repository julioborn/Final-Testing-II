import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AccountsOverviewPage extends HomePage{
    private By goToAccountsButton = By.xpath("//a[normalize-space()='Accounts Overview']");
    private By message = By.xpath("//td[contains(text(),'*Balance includes deposits that may be subject to ')]");

    public AccountsOverviewPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public void clickIrACuentas() throws InterruptedException {
        this.click(goToAccountsButton);
    }

    public String obtenerMensaje() throws InterruptedException {
        System.out.println("Visualización exitosa:\n" + getText(message) + "\n");
        return this.getText(message);
    }

}
