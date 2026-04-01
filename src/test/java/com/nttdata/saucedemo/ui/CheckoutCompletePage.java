package com.nttdata.saucedemo.ui;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class CheckoutCompletePage {

    public static final Target CONFIRMATION_MESSAGE = Target.the("mensaje de confirmacion")
            .located(By.className("complete-header"));
}