package com.pe.booking.task;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.rest.SerenityRest;
import org.junit.Assert;

import static com.pe.booking.task.CreateToken.contentToken;
import static com.pe.booking.task.CreateUserBooking.contentBookingId;
import static com.pe.booking.webservices.WebServicesEndPoints.BOOKING;

public class UpdateUserBooking {

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
        int bookingId = Serenity.sessionVariableCalled(contentBookingId);
        SerenityRest.given().log().all().baseUri(BOOKING.getUrl() + "/" + bookingId)
                .and().header("Content-Type", "application/json").header("Accept", "application/json")
                .header("Cookie", "token=" + contentToken)
                .and().body(body).when().put();
        SerenityRest.then().log().all();
    }
    public void validateUpdateUser(String firstName, String lastName, int totalPrice, String depositpaid, String checkin, String checkout, String additionalneeds) {
        Assert.assertEquals(firstName, SerenityRest.lastResponse().jsonPath().getString("firstname"));
        Assert.assertEquals(lastName, SerenityRest.lastResponse().jsonPath().getString("lastname"));
        Assert.assertEquals(totalPrice, SerenityRest.lastResponse().jsonPath().getInt("totalprice"));
        Assert.assertEquals(depositpaid, SerenityRest.lastResponse().jsonPath().getString("depositpaid"));
        Assert.assertEquals(checkin, SerenityRest.lastResponse().jsonPath().getString("bookingdates.checkin"));
        Assert.assertEquals(checkout, SerenityRest.lastResponse().jsonPath().getString("bookingdates.checkout"));
        Assert.assertEquals(additionalneeds, SerenityRest.lastResponse().jsonPath().getString("additionalneeds"));

    }
}
