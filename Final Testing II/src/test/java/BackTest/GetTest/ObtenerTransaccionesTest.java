package BackTest.GetTest;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.testng.Assert;
import utils.AccountUtils;
import utils.Globals;
import utils.LoginUtils;

public class ObtenerTransaccionesTest {

    @Test
    @Tag("All")
    @Tag("GetTest")
    @Tag("BackTest")
    public void Get_Transacciones() {
        String user = Globals.userName;
        String password = Globals.password;
        Response loginResponse = LoginUtils.loginUser(user, password);
        String customerId = loginResponse.path("customer.id");
        Response accountsResponse = AccountUtils.getAccountsForUser(customerId);
        String accountId =  accountsResponse.path("accounts.account[0].id");
        Response resGet = RestAssured.get("https://parabank.parasoft.com/parabank/services/bank/accounts/" + accountId + "/transactions/month/All/type/All");
        System.out.println("Status Code: " + resGet.statusCode());
        System.out.println("Tiempo de Respuesta: " + resGet.getTime() + " milisegundos");
        System.out.println("Body: " + resGet.body().asString());
        Assert.assertEquals(resGet.getStatusCode(), 200);
    }

}
