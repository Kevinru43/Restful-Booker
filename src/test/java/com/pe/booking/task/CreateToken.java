package com.pe.booking.task;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.rest.SerenityRest;
import org.junit.Assert;

import static com.pe.booking.webservices.WebServicesEndPoints.*;

public class CreateToken {
    public static String contentToken;

    public void in(String user, String password) {

        String body = "{\n" +
                "    \"username\" : \"" + user + "\",\n" +
                "    \"password\" : \"" + password + "\"\n" +
                "}";
        SerenityRest.given().log().all().baseUri(AUTH.getUrl())
                .and().header("Content-Type", "application/json")
                .and().body(body).when().post();
        SerenityRest.then().log().all();
        contentToken = SerenityRest.lastResponse().jsonPath().getString("token");
        // Serenity.setSessionVariable(contentToken).to(token);
    }

    public void validate() {
        Assert.assertEquals(200, SerenityRest.lastResponse().statusCode());
    }

    public void message(String message) {
        Assert.assertEquals(message, SerenityRest.lastResponse().jsonPath().get("reason"));
    }
}
