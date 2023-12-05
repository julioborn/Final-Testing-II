package BackTest.PostTest;

import io.restassured.response.Response;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import utils.AccountUtils;
import utils.Globals;
import utils.LoginUtils;

import static io.restassured.RestAssured.given;

public class TransferTest {

    @Test
    @Tag("All")
    @Tag("PostTest")
    @Tag("BackTest")
    public void Post_RealizarTransferencia() {
        String user = Globals.userName;
        String password = Globals.password;
        Response loginResponse = LoginUtils.loginUser(user, password);
        String customerId = loginResponse.path("customer.id");
        Response accountsResponse = AccountUtils.getAccountsForUser(customerId);
        String fromAccountId =  accountsResponse.path("accounts.account[0].id");
        String toAccountId =  accountsResponse.path("accounts.account[1].id");
        int amount = 50;

        given()
                .contentType("application/json")
                .when()
                .post("https://parabank.parasoft.com/parabank/services/bank/transfer?fromAccountId=" + fromAccountId + "&toAccountId=" + toAccountId + "&amount=" + amount)
                .then()
                .statusCode(200)
                .log().status()
                .log().body();
    }

}
