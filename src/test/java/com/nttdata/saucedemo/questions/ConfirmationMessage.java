package com.nttdata.saucedemo.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import static com.nttdata.saucedemo.ui.CheckoutCompletePage.CONFIRMATION_MESSAGE;

public class ConfirmationMessage implements Question<String> {

    public static ConfirmationMessage displayed() {
        return new ConfirmationMessage();
    }

    @Override
    public String answeredBy(Actor actor) {
        return CONFIRMATION_MESSAGE.resolveFor(actor)
                .waitUntilVisible()
                .getText()
                .trim();
    }
}