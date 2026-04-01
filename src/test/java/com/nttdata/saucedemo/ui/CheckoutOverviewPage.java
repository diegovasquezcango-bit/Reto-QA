package com.nttdata.saucedemo.ui;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class CheckoutOverviewPage {

    public static final Target FINISH_BUTTON = Target.the("boton finalizar compra")
            .located(By.id("finish"));

    public static final Target PRODUCTOS_EN_CHECKOUT = Target.the("productos mostrados en el checkout")
            .locatedBy("//div[@class='inventory_item_name']");
}