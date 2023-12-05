import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class googleTest {
    public WebDriver driver;
    public WebDriverWait wait;

    @Test
    public void testGoogle() throws InterruptedException {
        HomePage homePage = new HomePage(driver, wait);
        homePage.setUp();
        homePage.getUrl("https://google.com");
        homePage.obtenerTituloGoogle(); // Ingreso correcto a: ...
        homePage.buscarTexto("Selenium");
        homePage.obtenerBusqueda(); // Resultado de la búsqueda: ...
        homePage.close();
    }
}
