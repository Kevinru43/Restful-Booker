package com.pe.booking.task;

import net.serenitybdd.rest.SerenityRest;
import org.junit.Assert;

import static com.pe.booking.webservices.WebServicesEndPoints.BOOKING;
import static com.pe.booking.webservices.WebServicesEndPoints.PING;

public class GetHealthPing {

    public void in () {
        SerenityRest.given().log().all().baseUri(PING.getUrl())
                .and().when().get();
        SerenityRest.then().log().all();

    }

    public void validate() {
        Assert.assertEquals(201, SerenityRest.lastResponse().statusCode());
    }

}
