import Reportes.ExtentFactory;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class AddToCartTest {
    public WebDriver driver;
    public WebDriverWait wait;
    static ExtentSparkReporter info = new ExtentSparkReporter("target/Reportes/AddToCartTest.html");
    static ExtentReports extent;

    @BeforeAll
    public static void crearReporte() {
        extent = ExtentFactory.getInstance();
        extent.attachReporter(info);
    }

    @BeforeEach
    public void setUp() {
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        SuccessPage successPage  = new SuccessPage(driver, wait);
        successPage.setUp();
        successPage.getUrl("https://opencart.abstracta.us/index.php?route=common/home");
    }

    @Test
    @Tag("AgregarAlCarrito")
    @Tag("ALL")
    public void testAddToCart() throws InterruptedException {
        ExtentTest test = extent.createTest("Prueba de agregar producto al carrito correcta");
        test.log(Status.INFO, "Comienza el test");
        SuccessPage successPage = new SuccessPage(driver, wait);

        try {
            successPage.escribirBusqueda("Iphone");
            successPage.clickBuscar();
            successPage.clickAgregarAlCarrito();
            test.log(Status.PASS, "Producto agregado al carrito");

            Assertions.assertEquals(successPage.mensajeDeExito(), ("Success: You have added iPhone to your shopping cart!\n×"));
            test.log(Status.PASS, "Validación de mensaje de éxito correcta");
        } catch (AssertionError error) {
            test.log(Status.FAIL, "Validación de mensaje de éxito incorrecta: " + error.getLocalizedMessage());
        }

    }

    @AfterEach
    public void quit() {
        SuccessPage successPage = new SuccessPage(driver, wait);
        successPage.close();
    }

    @AfterAll
    public static void reporte() {
        extent.flush();
    }

}
