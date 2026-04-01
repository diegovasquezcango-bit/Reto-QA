package com.nttdata.saucedemo.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import java.util.List;
import java.util.stream.Collectors;

import static com.nttdata.saucedemo.ui.CheckoutOverviewPage.PRODUCTOS_EN_CHECKOUT;

public class ProductosEnCheckout implements Question<List<String>> {

    public static ProductosEnCheckout mostrados() {
        return new ProductosEnCheckout();
    }

    @Override
    public List<String> answeredBy(Actor actor) {
        return PRODUCTOS_EN_CHECKOUT.resolveAllFor(actor)
                .stream()
                .map(elemento -> elemento.getText().trim())
                .collect(Collectors.toList());
    }
}