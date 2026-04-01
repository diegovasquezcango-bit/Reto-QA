package com.nttdata.saucedemo.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;

import static com.nttdata.saucedemo.ui.CheckoutOverviewPage.FINISH_BUTTON;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class FinishPurchase implements Task {

    public static FinishPurchase now() {
        return instrumented(FinishPurchase.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Click.on(FINISH_BUTTON));
    }
}