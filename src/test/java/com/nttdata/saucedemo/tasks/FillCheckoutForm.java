package com.nttdata.saucedemo.tasks;

import com.nttdata.saucedemo.models.CustomerData;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;

import static com.nttdata.saucedemo.ui.CheckoutPage.CONTINUE_BUTTON;
import static com.nttdata.saucedemo.ui.CheckoutPage.FIRST_NAME;
import static com.nttdata.saucedemo.ui.CheckoutPage.LAST_NAME;
import static com.nttdata.saucedemo.ui.CheckoutPage.POSTAL_CODE;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class FillCheckoutForm implements Task {

    private final CustomerData customerData;

    public FillCheckoutForm(CustomerData customerData) {
        this.customerData = customerData;
    }

    public static FillCheckoutForm withData(CustomerData customerData) {
        return instrumented(FillCheckoutForm.class, customerData);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Enter.theValue(customerData.getFirstName()).into(FIRST_NAME),
                Enter.theValue(customerData.getLastName()).into(LAST_NAME),
                Enter.theValue(customerData.getPostalCode()).into(POSTAL_CODE),
                Click.on(CONTINUE_BUTTON)
        );
    }
}