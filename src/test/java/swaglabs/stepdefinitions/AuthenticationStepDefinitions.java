package swaglabs.stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;

import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.screenplay.questions.Text;
import net.serenitybdd.screenplay.ui.Button;
import swaglabs.Model.SwaglabsUser;
import swaglabs.tasks.authentication.Login;


public class AuthenticationStepDefinitions {

    @Given("{actor} is on the login page")
    public void is_on_the_login_page(Actor actor) {
        actor.attemptsTo(Open.url("https://www.saucedemo.com/"));
    }

    @When("{actor} logs in with valid credentials")
    public void logs_in_with_valid_credentials(Actor actor) {
        actor.attemptsTo(
            Login.asA(SwaglabsUser.STANDARD_USER)
        );
    }

    @Then("{actor} should be presented with the product catalog")
    public void he_should_be_presented_with_the_product_catalog(Actor actor) {
        actor.attemptsTo(
                Ensure.that(Text.of(".title")).isEqualTo("PRODUCTS")
        );
    }

    @When("{actor} logs in with invalid credentials")
    public void colin_logs_in_with_invalid_credentials(Actor actor) {
        actor.attemptsTo(
                Enter.theValue("standard_user").into("#user-name"),
                Enter.theValue("Password_Error").into("#password"),
                Click.on(Button.withText("LOGIN"))
//                Click.on(Button.withNameOrId("login-button"))
        );
    }

    @Then("{actor}  should be presented message error in authentication")
    public void he_should_be_presented_message_error_in_authentication(Actor actor) {
        actor.attemptsTo(
                Ensure.that(Text.of("(//h3[contains(text(),'Epic sadface: Username and password do not match a')])[1]")).isEqualTo("Epic sadface: Username and password do not match any user in this service")
        );
    }
}
