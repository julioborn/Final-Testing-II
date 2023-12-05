package BackTest.PostTest;
import io.restassured.response.Response;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import utils.AccountUtils;
import utils.Globals;
import utils.LoginUtils;

import static io.restassured.RestAssured.*;

public class OpenAccountTest {

    @Test
    @Tag("All")
    @Tag("PostTest")
    @Tag("BackTest")
    public void Post_AbrirCuenta() {
        String userName = Globals.userName;
        String password = Globals.password;
        Response loginResponse = LoginUtils.loginUser(userName, password);
        System.out.println("Status Code " + loginResponse.statusCode());
        String customerId = loginResponse.path("customer.id");
        Response accountsResponse = AccountUtils.getAccountsForUser(customerId);
        String fromAccountId =  accountsResponse.path("accounts.account[0].id");
        int newAccountType = 1;

        given()
                .contentType("application/json")
                .when()
                .post("https://parabank.parasoft.com/parabank/services/bank/createAccount?customerId=" + customerId + "&newAccountType=" + newAccountType + "&fromAccountId=" + fromAccountId)
                .then()
                .statusCode(200)
                .log().status()
                .log().body();
    }

}
