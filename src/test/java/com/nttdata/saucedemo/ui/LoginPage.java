package com.nttdata.saucedemo.ui;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class LoginPage {

    public static final Target USERNAME = Target.the("campo usuario")
            .located(By.id("user-name"));

    public static final Target PASSWORD = Target.the("campo clave")
            .located(By.id("password"));

    public static final Target LOGIN_BUTTON = Target.the("boton login")
            .located(By.id("login-button"));
}