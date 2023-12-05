import Reportes.ExtentFactory;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.Globals;

import java.time.Duration;
import java.util.Random;

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
        registerPage.getUrl("https://parabank.parasoft.com/parabank/index.htm");
    }

    @Test
    @Tag("Registro")
    @Tag("All")
    @Tag("FrontTest")
    public void testRegistro() throws InterruptedException {
        ExtentTest test = extent.createTest("Prueba de registro correcta");
        test.log(Status.INFO, "Comienza el test");
        RegisterPage registerPage = new RegisterPage(driver, wait);

        try {
            registerPage.clickIrRegistrar();
            registerPage.escribirNombre("Julio");
            registerPage.escribirApellido("Born");
            registerPage.escribirDireccion("Ocean Drive 666");
            registerPage.escribirCiudad("Miami");
            registerPage.escribirEstado("FL");
            registerPage.escribirCodigoPostal("33101");
            registerPage.escribirTelefono("123123123");
            registerPage.escribirSeguro("SNN-Miami");
            registerPage.escribirUsuario(Globals.userName);
            registerPage.escribirContrasena(Globals.password);
            registerPage.confirmarContrasena(Globals.password);
            registerPage.clickRegistrar();
            test.log(Status.PASS, "Intento de registro con datos correctos");

            Assertions.assertEquals(registerPage.obtenerMensajeExito(), ("Your account was created successfully. You are now logged in."));
            test.log(Status.PASS, "Validación de registro correcta");
        } catch (AssertionError error) {
            test.log(Status.FAIL, "Validación de registro incorrecta: " + error.getLocalizedMessage());
            throw error;
        }

        // Simulación de movimientos aleatorios de ratón entre acciones.
        Actions actions = new Actions(driver);
        Random random = new Random();
        int xOffset = random.nextInt(500);
        int yOffset = random.nextInt(500);
        actions.moveByOffset(xOffset, yOffset).perform();
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

