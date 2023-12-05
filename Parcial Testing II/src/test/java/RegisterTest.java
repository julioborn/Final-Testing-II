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

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class RegisterTest {
    public WebDriver driver;
    public WebDriverWait wait;
    static ExtentSparkReporter info = new ExtentSparkReporter("target/Reportes/RegisterTest.html");
    static ExtentReports extent;

    @BeforeAll
    public static void crearReporte() {
        extent = ExtentFactory.getInstance();
        extent.attachReporter(info);
    }

    @BeforeEach
    public void setUp() {
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        RegisterPage registerPage = new RegisterPage(driver, wait);
        registerPage.setUp();
        registerPage.getUrl("https://opencart.abstracta.us/index.php?route=common/home");
        registerPage.getUrl("https://opencart.abstracta.us/index.php?route=account/success");
    }

    @Test
    @Tag("Registro")
    @Tag("ALL")
    public void testRegistro() throws InterruptedException {
        ExtentTest test = extent.createTest("Prueba de registro correcta");
        test.log(Status.INFO, "Comienza el test");
        RegisterPage registerPage = new RegisterPage(driver, wait);

        try {
            registerPage.clickRegistrar();
            registerPage.escribirNombre("Julio");
            registerPage.escribirApellido("Born");
            registerPage.escribirCorreo("julioborn123@gmail.com");
            registerPage.escribirTelefono("3483-123123");
            registerPage.escribirContrasena("julio123");
            registerPage.confirmarContrasena("julio123");
            registerPage.suscribirNewsletter();
            registerPage.aceptarPoliticas();
            registerPage.clickIngresar();
            test.log(Status.PASS, "Intento de registro con datos correctos");

            Assertions.assertEquals(registerPage.obtenerMensajeExito(), ("Congratulations! Your new account has been successfully created!"));
            test.log(Status.PASS, "Validación de registro correcta");
        } catch (AssertionError error) {
            test.log(Status.FAIL, "Validación de registro incorrecta: " + error.getLocalizedMessage());
            throw error;
        }
    }

    @AfterEach
    public void quit() {
        RegisterPage registerPage = new RegisterPage(driver, wait);
        registerPage.close();
    }

    @AfterAll
    public static void reporte() {
        extent.flush();
    }

}
