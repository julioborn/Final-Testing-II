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

public class TransferFundsTest {
    public WebDriver driver;
    public WebDriverWait wait;
    static ExtentSparkReporter info = new ExtentSparkReporter("target/Reportes/TransferFundsTest.html");
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
        TransferFundsPage transferFundsPage = new TransferFundsPage(driver, wait);
        transferFundsPage.setUp();
        transferFundsPage.getUrl("https://parabank.parasoft.com/parabank/index.htm");
    }

    @Test
    @Tag("TransferirFondos")
    @Tag("All")
    @Tag("FrontTest")
    public void testTranferirFondos() throws InterruptedException {
        ExtentTest test = extent.createTest("Prueba de transferencia de fondos correcta");
        test.log(Status.INFO, "Comienza el test");
        LoginPage loginPage = new LoginPage(driver, wait);
        TransferFundsPage transferFundsPage = new TransferFundsPage(driver, wait);

        try {
            loginPage.escribirUsuario(Globals.userName);
            loginPage.escribirContrasena(Globals.password);
            loginPage.clickLogin();
            transferFundsPage.clickIrATransferencias();
            Thread.sleep(2000);
            transferFundsPage.escribirMonto("20");
            transferFundsPage.seleccionarCuentaDestino();
            transferFundsPage.clickTransferir();
            test.log(Status.PASS, "Intento de transferencia de fondos con datos correctos");

            Assertions.assertEquals(transferFundsPage.obtenerMensaje(), ("Transfer Complete!"));
            test.log(Status.PASS, "Validación transferencia correcta");
        } catch (AssertionError error) {
            test.log(Status.FAIL, "Validación de transferencia incorrecta: " + error.getLocalizedMessage());
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
        AccountsOverviewPage accountsOverviewPage = new AccountsOverviewPage(driver, wait);
        accountsOverviewPage.close();
    }

    @AfterAll
    public static void reporte() {
        extent.flush();
    }

}
