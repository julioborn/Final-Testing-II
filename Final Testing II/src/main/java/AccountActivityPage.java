import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AccountActivityPage extends HomePage{
    private By goToAccountsButton = By.xpath("//a[normalize-space()='Accounts Overview']");
    private By balanceText = By.xpath("//td[contains(text(),'*Balance includes deposits that may be subject to ')]");
    private By account;
    private By detailsText = By.xpath("//h1[normalize-space()='Account Details']");
    private By activityPeriod = By.xpath("//select[@id='month']");
    private By type = By.xpath("//select[@id='transactionType']");
    private By goButton = By.xpath("//input[@value='Go']");

    public AccountActivityPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public void setAccountNumber(String accountNumber) {
        this.account = By.xpath("//a[normalize-space()='" + accountNumber + "']");
    }

    public void clickIrACuentas() throws InterruptedException {
        this.click(goToAccountsButton);
    }
    public String obtenerTextoBalance() throws InterruptedException {
        System.out.println(getText(balanceText));
        return this.getText(balanceText);
    }

    public void clickCuenta() throws InterruptedException {
        this.click(account);
    }

    public String obtenerTextoDetalle() throws InterruptedException {
        System.out.println(getText(detailsText));
        return this.getText(detailsText);
    }

    public void seleccionarPeriodo() throws InterruptedException {
        Select select = new Select(driver.findElement(activityPeriod));
        select.selectByIndex(0);
    }

    public void seleccionarTipo() throws InterruptedException {
        Select select = new Select(driver.findElement(type));
        select.selectByIndex(0);
    }

    public void clickIr() throws InterruptedException {
        this.click(goButton);
    }

}
