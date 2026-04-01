package com.nttdata.saucedemo.ui;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class CartPage {

    public static final Target CHECKOUT_BUTTON = Target.the("boton checkout")
            .located(By.id("checkout"));

    public static final Target CART_ITEMS = Target.the("productos del carrito")
            .locatedBy("//div[@class='cart_item']");
}