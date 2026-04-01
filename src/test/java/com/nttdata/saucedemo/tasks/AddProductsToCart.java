package com.nttdata.saucedemo.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;

import java.util.List;

import static com.nttdata.saucedemo.ui.ProductsPage.addToCartButton;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class AddProductsToCart implements Task {

    private final List<String> productNames;

    public AddProductsToCart(List<String> productNames) {
        this.productNames = productNames;
    }

    public static AddProductsToCart called(List<String> productNames) {
        return instrumented(AddProductsToCart.class, productNames);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        for (String productName : productNames) {
            actor.attemptsTo(
                    Click.on(addToCartButton(productName))
            );
        }
    }
}