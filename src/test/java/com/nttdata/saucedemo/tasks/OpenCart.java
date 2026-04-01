package com.nttdata.saucedemo.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;

import static com.nttdata.saucedemo.ui.ProductsPage.CART_ICON;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class OpenCart implements Task {

    public static OpenCart view() {
        return instrumented(OpenCart.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Click.on(CART_ICON));
    }
}