import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchPage extends BasePage {
    //private final By searchCity = By.id("ciudad");

    private final By searchCity = By.xpath("//*[@id='ciudad']");
    private final By searchButton = By.id("btn-buscador");
    private final By searchResult = By.className("categoria");

    public SearchPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public void seleccionarCiudad(String ciudad) throws InterruptedException {
        Thread.sleep(1000);
        this.sendText(ciudad, searchCity);
        this.sendKey(Keys.ENTER, searchCity);
    }

    public void clickBuscar() throws InterruptedException {
        Thread.sleep(1000);
        this.click(searchButton);
    }

    public String obtenerRecomendacion() throws InterruptedException {
        Thread.sleep(1000);
        System.out.println("Resultado de la búsqueda: " + this.getText(searchResult));
        return this.getText(searchResult);
    }

}
