import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends BasePage {
    private final By searchBox = By.name("q");
    private final By title = By.xpath("//img[@alt='Google']");

    public HomePage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public void buscarTexto(String texto) throws InterruptedException {
        this.sendText(texto, searchBox);
        this.sendKey(Keys.ENTER, searchBox);
    }

    public String obtenerTituloGoogle() {
        System.out.println("Ingreso correcto a: " + driver.getTitle());
        return driver.getTitle();
    }

    public String obtenerBusqueda() throws InterruptedException {
        System.out.println("Resultado de la búsqueda: " + this.getText(searchBox));
        return this.getText(searchBox);
    }

}
