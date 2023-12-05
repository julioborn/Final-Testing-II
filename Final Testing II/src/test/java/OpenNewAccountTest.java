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

public class OpenNewAccountTest {
    public WebDriver driver;
    public WebDriverWait wait;
    static ExtentSparkReporter info = new ExtentSparkReporter("target/Reportes/OpenNewAccountTest.html");
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
        OpenNewAccountPage openNewAccountPage = new OpenNewAccountPage(driver, wait);
        openNewAccountPage.setUp();
        openNewAccountPage.getUrl("https://parabank.parasoft.com/parabank/index.htm");
    }

    @Test
    @Tag("AbrirCuenta")
    @Tag("All")
    @Tag("FrontTest")
    public void testAbrirCuenta() throws InterruptedException {
        ExtentTest test = extent.createTest("Prueba de abrir cuenta correcta");
        test.log(Status.INFO, "Comienza el test");
        LoginPage loginPage = new LoginPage(driver, wait);
        OpenNewAccountPage openNewAccountPage = new OpenNewAccountPage(driver, wait);

        try {
            loginPage.escribirUsuario(Globals.userName);
            loginPage.escribirContrasena(Globals.password);
            loginPage.clickLogin();
            openNewAccountPage.clickServicio();
            openNewAccountPage.seleccionarTipoDeCuenta("SAVINGS");
            Thread.sleep(1500);
            openNewAccountPage.clickFinal();
            test.log(Status.PASS, "Intento de apertura de cuenta con datos correctos");

            Assertions.assertEquals(openNewAccountPage.obtenerMensajeExito(), ("Congratulations, your account is now open."));
            test.log(Status.PASS, "Validación de cuenta correcta");
        } catch (AssertionError error) {
            test.log(Status.FAIL, "Validación de cuenta incorrecta: " + error.getLocalizedMessage());
            throw error;
        }

        // Simular movimientos aleatorios de ratón entre acciones
        Actions actions = new Actions(driver);
        Random random = new Random();
        int xOffset = random.nextInt(500);
        int yOffset = random.nextInt(500);
        actions.moveByOffset(xOffset, yOffset).perform();
    }

    @AfterEach
    public void quit() {
        OpenNewAccountPage openNewAccountPage = new OpenNewAccountPage(driver, wait);
        openNewAccountPage.close();
    }

    @AfterAll
    public static void reporte() {
        extent.flush();
    }

}
