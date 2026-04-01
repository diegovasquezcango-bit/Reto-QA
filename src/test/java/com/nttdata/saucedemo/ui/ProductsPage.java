package com.nttdata.saucedemo.ui;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class ProductsPage {
    public static final Target CART_ICON = Target.the("icono del carrito")
            .located(By.className("shopping_cart_link"));

    public static Target addToCartButton(String productName) {
        String productId = switch (productName) {
            case "Sauce Labs Backpack" -> "add-to-cart-sauce-labs-backpack";
            case "Sauce Labs Bike Light" -> "add-to-cart-sauce-labs-bike-light";
            default -> throw new IllegalArgumentException("Producto no mapeado: " + productName);
        };

        return Target.the("boton agregar al carrito para " + productName)
                .located(By.id(productId));
    }
}