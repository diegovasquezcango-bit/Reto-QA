package com.nttdata.saucedemo.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;

import static com.nttdata.saucedemo.ui.CartPage.CHECKOUT_BUTTON;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class Checkout implements Task {

    public static Checkout process() {
        return instrumented(Checkout.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Click.on(CHECKOUT_BUTTON));
    }
}