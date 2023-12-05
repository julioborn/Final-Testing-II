package utils;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class AccountUtils {
    public static Response getAccountsForUser(String customerId) {
        String urlAccountId = "http://parabank.parasoft.com/parabank/services/bank/customers/" + customerId + "/accounts";
        try {
            Response response = RestAssured.get(urlAccountId);
            response.then().statusCode(200);
            return response;
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Error al obtener cuentas del usuario");
        }
    }
}