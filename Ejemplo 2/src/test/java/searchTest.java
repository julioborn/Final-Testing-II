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

public class searchTest {
    public WebDriver driver;
    public WebDriverWait wait;
    static ExtentSparkReporter info = new ExtentSparkReporter("target/REPORTES/SearchTest.html");
    static ExtentReports extent;

    @BeforeAll
    public static void crearReporte() {
        extent = ExtentFactory.getInstance();
        extent.attachReporter(info);
    }

    @BeforeEach
    public void inicio() {
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofMillis(2000));
        SearchPage searchPage = new SearchPage(driver, wait);
        searchPage.setUp();
        searchPage.getUrl("http://testing.ctd.academy/");
    }

    @Test
    @Tag("Busqueda")
    @Tag("ALL")
    public void testBusquedaUruguay() throws InterruptedException {
        ExtentTest test = extent.createTest("Prueba de búsqueda Punta del Este, existosa");
        test.log(Status.INFO, "Comienza el Test");
        SearchPage searchPage = new SearchPage(driver, wait);

        searchPage.seleccionarCiudad("Punta del Este");
        searchPage.clickBuscar();
        test.log(Status.PASS, "Completar búsqueda de Punta del Este");

        Assertions.assertEquals(searchPage.obtenerRecomendacion(), "CASA DE PLAYA\n" + "Villa Kantounes Studio Ostria");
        test.log(Status.PASS, "Validación de Recomendación Punta del Este, exitosa");
    }

    @Test
    @Tag("Busqueda")
    @Tag("ALL")
    public void testBusquedaGrecia() throws InterruptedException {
        ExtentTest test = extent.createTest("Prueba de búsqueda Paros, existosa");
        test.log(Status.INFO, "Comienza el Test");
        SearchPage searchPage = new SearchPage(driver, wait);

        searchPage.seleccionarCiudad("Paros");
        searchPage.clickBuscar();
        test.log(Status.PASS, "Completar búsqueda de Paros");

        Assertions.assertEquals(searchPage.obtenerRecomendacion(), "CASA DE PLAYA\n" + "La Paloma");
        test.log(Status.PASS, "Validación de Recomendación Paros, exitosa");
    }

    @AfterEach
    public void quit() {
        SearchPage searchPage = new SearchPage(driver, wait);
        searchPage.close();
    }

    @AfterAll
    public static void reporte() {
        extent.flush();
    }

}
