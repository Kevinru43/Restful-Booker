package com.pe.booking.stepsdefinitions;

import com.pe.booking.task.*;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.Steps;

import java.util.HashMap;

public class UserBookingStepsDefinitions {

    @Steps
    CreateToken createToken;

    @Steps
    CreateUserBooking createUserBooking;

    @Steps
    UpdateUserBooking updateUserBooking;

    @Steps
    DeleteUserBooking deleteUserBooking;

    @Steps
    GetHealthPing getHealthPing;

    @When("^que el consulta el servicio ingresando el user (.*) y password (.*)$")
    public void queElConsultaElServicioIngresandoelUserYPassword(String user, String pass) {
        createToken.in(user, pass);
    }

    @Then("^el recibe el token con estado 200$")
    public void elRecibeElTokenConEstado200() {
        createToken.validate();
    }

    @Then("^el obtiene un mensaje de error (.*)$")
    public void elObtieneUnMensajeDeError(String message) {
        createToken.message(message);
    }

    @When("^el crea el usuario ingresando sus datos: (.*), (.*), (.*), (.*), (.*), (.*) y (.*)$")
    public void elCreaElUsuarioIngresandoSusDatos(String firstName, String lastName, int totalPrice, String depositpaid, String checkin, String checkout, String additionalneeds) {
        createUserBooking.in(firstName, lastName, totalPrice, depositpaid, checkin, checkout, additionalneeds);
    }

    @Then("^el valida que se proceso correctamente$")
    public void elValidaQueSeProcesoCorrectamente() {
        createUserBooking.validate();
    }

    @And("^el valida sus datos: (.*), (.*), (.*), (.*), (.*), (.*) y (.*)$")
    public void elValidaSusDatos(String firstName, String lastName, int totalPrice, String depositpaid, String checkin, String checkout, String additionalneeds) {
        createUserBooking.validateUser(firstName, lastName, totalPrice, depositpaid, checkin, checkout, additionalneeds);
    }

    @When("^el actualiza sus datos ingresando: (.*), (.*), (.*), (.*), (.*), (.*) y (.*)$")
    public void elActualizaSusDatosIngresando(String firstName, String lastName, int totalPrice, String depositpaid, String checkin, String checkout, String additionalneeds) {
        updateUserBooking.in(firstName, lastName, totalPrice, depositpaid, checkin, checkout, additionalneeds);
    }

    @And("^el valida sus datos actualizados: (.*), (.*), (.*), (.*), (.*), (.*) y (.*)$")
    public void elValidaSusDatosActualizados(String firstName, String lastName, int totalPrice, String depositpaid, String checkin, String checkout, String additionalneeds) {
        updateUserBooking.validateUpdateUser(firstName, lastName, totalPrice, depositpaid, checkin, checkout, additionalneeds);
    }
   // @Given("^el usuario consulta el servicio de actualizacion de usuario booking$")
    //public void elUsuarioConsultaElServicioDeActualizacionDeUsuarioBooking() {
    //}

    //@Given("^el usuario consulta el servicio de eliminación de usuario booking$")
    //public void elUsuarioConsultaElServicioDeEliminacionDeUsuarioBooking() {
    //}

    @When("^el ejecuta el proceso de eliminación$")
    public void elEjecutaElProcesoDeEliminación() {
        deleteUserBooking.in();
    }

    @Then("^el valida que se elimino de manera exitosa$")
    public void elValidaQueSeEliminoDeManeraExitosa() {
        deleteUserBooking.validated();
    }

    @Given("^que el usuario consulta el servicio de ping$")
    public void queElUsuarioConsultaElServicioDePing() {

    }

    @When("^el ejecuta la consulta$")
    public void elEjecutaLaConsulta() {
        getHealthPing.in();
    }

    @Then("^el valida que se creo correctamente el ping$")
    public void elValidaQueSeCreoCorrectamenteElPing() {
        getHealthPing.validate();
    }
}
