package BackTest.GetTest;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.testng.Assert;

public class ObtenerRegistroTest {

    @Test
    @Tag("All")
    @Tag("GetTest")
    @Tag("BackTest")
    public void Get_Registro () {
        Response resGet = RestAssured.get("https://parabank.parasoft.com/parabank/register.htm");
        System.out.println("Status Code: " + resGet.getStatusCode());
        System.out.println("Tiempo de respuesta: " + resGet.getTime());
        System.out.println("Body: " + resGet.body().asString());
        Assert.assertEquals(resGet.getStatusCode(), 200);
    }

}
