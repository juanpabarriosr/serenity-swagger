package swaglabs.stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;
import swaglabs.tasks.cart.AddToCart;
import swaglabs.tasks.navigation.Navigate;

import java.util.List;


public class CatalogStepDefinitions {

    @And("{actor} is browsing the catalog")
    public void heIsBrowsingTheCatalog(Actor actor) {
        actor.attemptsTo(
                Navigate.toTheCatalogPage()
        );
    }

    @When("{actor} adds the folowing items to the cart:")
    public void addsTheFolowingItemsToTheCart(Actor actor, List<String> items) {
        items.forEach(
                itemName -> actor.attemptsTo(AddToCart.item(itemName))
        );
    }
}
