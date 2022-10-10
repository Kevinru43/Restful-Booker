package com.pe.booking.task;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.rest.SerenityRest;
import org.junit.Assert;

import static com.pe.booking.task.CreateToken.contentToken;
import static com.pe.booking.task.CreateUserBooking.contentBookingId;
import static com.pe.booking.webservices.WebServicesEndPoints.BOOKING;

public class DeleteUserBooking {

    public void in() {

        int bookingId = Serenity.sessionVariableCalled(contentBookingId);
        SerenityRest.given().log().all().baseUri(BOOKING.getUrl() + "/" + bookingId)
                .and().header("Content-Type", "application/json").header("Cookie", "token=" + contentToken)
                    .and().when().delete();
        SerenityRest.then().log().all();
    }

    public void validated() {
            Assert.assertEquals(201, SerenityRest.lastResponse().statusCode());

    }
}
