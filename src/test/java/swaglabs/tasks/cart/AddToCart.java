package swaglabs.tasks.cart;

import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.ui.Button;
import net.serenitybdd.screenplay.ui.PageElement;

public class AddToCart {
    public static Performable item(String itemName) {
        return Task.where("{0} clicks on the add to cart button for " + itemName,
                Click.on(
                        Button.withText("ADD TO CART")
                                .inside(PageElement.withCSSClass("inventory_item")
                                        .containingText(itemName))
                )
        );
    }
}
