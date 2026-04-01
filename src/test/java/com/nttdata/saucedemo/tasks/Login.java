package com.nttdata.saucedemo.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;

import static com.nttdata.saucedemo.ui.LoginPage.LOGIN_BUTTON;
import static com.nttdata.saucedemo.ui.LoginPage.PASSWORD;
import static com.nttdata.saucedemo.ui.LoginPage.USERNAME;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class Login implements Task {

    private final String user;
    private final String password;

    public Login(String user, String password) {
        this.user = user;
        this.password = password;
    }

    public static Login withCredentials(String user, String password) {
        return instrumented(Login.class, user, password);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Enter.theValue(user).into(USERNAME),
                Enter.theValue(password).into(PASSWORD),
                Click.on(LOGIN_BUTTON)
        );
    }
}