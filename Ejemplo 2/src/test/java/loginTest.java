import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class loginTest {

    public WebDriver driver;
    public WebDriverWait wait;

    @BeforeEach
    public void setUp() {
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        LoginPage loginPage = new LoginPage(driver, wait);
        loginPage.setUp();
        loginPage.getUrl("http://testing.ctd.academy/");
    }

    @Test
    @Tag("Login")
    @Tag("ALL")
    public void loginTest() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver, wait);

        loginPage.clickLogin();

        loginPage.escribirMail("juliobornes10@gmail.com");
        loginPage.escribirContrasena("123456");

        loginPage.clickIngresar();

        assertTrue(loginPage.obtenerUsuario().equals("Julio Born"));

    }

    @Test
    @Tag("Login")
    @Tag("ALL")
    public void loginTest2() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver, wait);

        loginPage.completarLogin("juliobornes10@gmail.com", "123456");

        assertTrue(loginPage.obtenerUsuario().equals("Julio Born"));

    }

    @AfterEach
    public void quit() {
        LoginPage loginPage = new LoginPage(driver, wait);
        loginPage.close();
    }

}
