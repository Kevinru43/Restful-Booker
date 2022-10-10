package com.pe.booking.webservices;

public enum WebServicesEndPoints {
    AUTH("https://restful-booker.herokuapp.com/auth"),
    BOOKING("https://restful-booker.herokuapp.com/booking"),
    PING("https://restful-booker.herokuapp.com/ping");

    private final String url;

    WebServicesEndPoints(String url) {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }
}
