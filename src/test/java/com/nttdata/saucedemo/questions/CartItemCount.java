package com.nttdata.saucedemo.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import static com.nttdata.saucedemo.ui.CartPage.CART_ITEMS;

public class CartItemCount implements Question<Integer> {

    public static CartItemCount displayed() {
        return new CartItemCount();
    }

    @Override
    public Integer answeredBy(Actor actor) {
        return CART_ITEMS.resolveAllFor(actor).size();
    }
}