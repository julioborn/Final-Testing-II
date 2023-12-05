import Reportes.ExtentFactory;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import io.restassured.response.Response;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import utils.AccountUtils;
import utils.Globals;
import utils.LoginUtils;

import java.time.Duration;
import java.util.Random;

public class AccountActivityTest {
    public WebDriver driver;
    public WebDriverWait wait;
    static ExtentSparkReporter info = new ExtentSparkReporter("target/Reportes/AccountActivityTest.html");
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
        AccountActivityPage accountActivityPage = new AccountActivityPage(driver, wait);
        accountActivityPage.setUp();
        accountActivityPage.getUrl("https://parabank.parasoft.com/parabank/index.htm");
    }

    @Test
    @Tag("ActividadCuenta")
    @Tag("All")
    @Tag("FrontTest")
    public void testActividadCuenta() throws InterruptedException {
        ExtentTest test = extent.createTest("Prueba de actividad de cuenta correcta");
        test.log(Status.INFO, "Comienza el test");
        LoginPage loginPage = new LoginPage(driver, wait);
        AccountActivityPage accountActivityPage = new AccountActivityPage(driver, wait);

        try {
            String user = Globals.userName;
            String password = Globals.password;
            loginPage.escribirUsuario(user);
            loginPage.escribirContrasena(password);
            loginPage.clickLogin();
            Response loginResponse = LoginUtils.loginUser(user, password);
            String customerId = loginResponse.path("customer.id");
            Response accountsResponse = AccountUtils.getAccountsForUser(customerId);
            String accountId =  accountsResponse.path("accounts.account[0].id");
            accountActivityPage.clickIrACuentas();
            Assert.assertEquals(accountActivityPage.obtenerTextoBalance(), "*Balance includes deposits that may be subject to holds");
            accountActivityPage.setAccountNumber(accountId);
            accountActivityPage.clickCuenta();
            Assert.assertEquals(accountActivityPage.obtenerTextoDetalle(), "Account Details");
            accountActivityPage.seleccionarPeriodo();
            accountActivityPage.seleccionarTipo();
            accountActivityPage.clickIr();
            test.log(Status.PASS, "Ver actividad de cuenta con datos correctos");

            test.log(Status.PASS, "Validación de actividad de cuenta correcta");
        } catch (AssertionError error) {
            test.log(Status.FAIL, "Validación de actividad de cuenta incorrecta: " + error.getLocalizedMessage());
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
        AccountActivityPage accountActivityPage = new AccountActivityPage(driver, wait);
        accountActivityPage.close();
    }

    @AfterAll
    public static void reporte() {
        extent.flush();
    }
}
