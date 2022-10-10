package com.pe.booking.task;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.rest.SerenityRest;
import org.junit.Assert;

import static com.pe.booking.webservices.WebServicesEndPoints.*;

public class CreateUserBooking {
    public static int contentBookingId;

    public void in(String firstName, String lastName, int totalPrice, String depositpaid, String checkin, String checkout, String additionalneeds) {
        String body = "{\n" +
                "    \"firstname\" : \"" + firstName + "\",\n" +
                "    \"lastname\" : \"" + lastName + "\",\n" +
                "    \"totalprice\" : " + totalPrice + ",\n" +
                "    \"depositpaid\" : " + depositpaid + ",\n" +
                "    \"bookingdates\" : {\n" +
                "        \"checkin\" : \"" + checkin + "\",\n" +
                "        \"checkout\" : \"" + checkout + "\"\n" +
                "    },\n" +
                "    \"additionalneeds\" : \"" + additionalneeds + "\"\n" +
                "}";
        SerenityRest.given().log().all().baseUri(BOOKING.getUrl())
                .and().header("Content-Type", "application/json")
                .and().body(body).when().post();
        SerenityRest.then().log().all();
        int bookingId = SerenityRest.lastResponse().jsonPath().getInt("bookingid");
        Serenity.setSessionVariable(contentBookingId).to(bookingId);
    }

    public void validate() {
        Assert.assertEquals(200, SerenityRest.lastResponse().statusCode());
    }

    public void validateUser(String firstName, String lastName, int totalPrice, String depositpaid, String checkin, String checkout, String additionalneeds) {
        Assert.assertEquals(firstName, SerenityRest.lastResponse().jsonPath().getString("booking.firstname"));
        Assert.assertEquals(lastName, SerenityRest.lastResponse().jsonPath().getString("booking.lastname"));
        Assert.assertEquals(totalPrice, SerenityRest.lastResponse().jsonPath().getInt("booking.totalprice"));
        Assert.assertEquals(depositpaid, SerenityRest.lastResponse().jsonPath().getString("booking.depositpaid"));
        Assert.assertEquals(checkin, SerenityRest.lastResponse().jsonPath().getString("booking.bookingdates.checkin"));
        Assert.assertEquals(checkout, SerenityRest.lastResponse().jsonPath().getString("booking.bookingdates.checkout"));
        Assert.assertEquals(additionalneeds, SerenityRest.lastResponse().jsonPath().getString("booking.additionalneeds"));

    }
}
