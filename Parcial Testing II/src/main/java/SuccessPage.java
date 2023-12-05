import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SuccessPage extends HomePage {
    private By searchInput = By.xpath("//input[@placeholder='Search']");
    private By searchButton = By.xpath("//button[@class='btn btn-default btn-lg']");
    private By addToCartButton = By.xpath("//div[@class='product-layout product-grid col-lg-3 col-md-3 col-sm-6 col-xs-12']//button[1]");
    private By successAlert = By.xpath("//div[@class='alert alert-success alert-dismissible']");

    public SuccessPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public void escribirBusqueda(String busqueda) throws InterruptedException {
        sendText(busqueda, searchInput);
    }

    public void clickBuscar() throws InterruptedException {
        this.click(searchButton);
    }

    public void clickAgregarAlCarrito() throws InterruptedException {
        this.click(addToCartButton);
    }

    public String mensajeDeExito() throws InterruptedException{
        System.out.println("Producto agregado al carrito:\n" + getText(successAlert));
        return this.getText(successAlert);
    }

    public void agregarProducto(String busqueda) throws InterruptedException {
        sendText(busqueda, searchInput);
        click(searchButton);
        click(addToCartButton);
    }

}
