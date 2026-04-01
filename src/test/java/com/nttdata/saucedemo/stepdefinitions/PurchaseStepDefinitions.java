package com.nttdata.saucedemo.stepdefinitions;

import com.nttdata.saucedemo.models.CustomerData;
import com.nttdata.saucedemo.models.ShopData;
import com.nttdata.saucedemo.questions.CartItemCount;
import com.nttdata.saucedemo.questions.ConfirmationMessage;
import com.nttdata.saucedemo.tasks.AddProductsToCart;
import com.nttdata.saucedemo.tasks.Checkout;
import com.nttdata.saucedemo.tasks.FillCheckoutForm;
import com.nttdata.saucedemo.tasks.FinishPurchase;
import com.nttdata.saucedemo.tasks.Login;
import com.nttdata.saucedemo.tasks.OpenCart;
import com.nttdata.saucedemo.tasks.OpenSauceDemo;
import com.nttdata.saucedemo.utils.JsonReader;
import io.cucumber.java.Before;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import com.nttdata.saucedemo.questions.ProductosEnCheckout;
import com.nttdata.saucedemo.models.ShopData;
import java.util.List;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.Matchers.containsStringIgnoringCase;
import static org.hamcrest.Matchers.equalTo;

public class PurchaseStepDefinitions {

    @Before
    public void setTheStage() {
        OnStage.setTheStage(new OnlineCast());
        OnStage.theActorCalled("Diego");
    }

    @Dado("que el usuario ingresa a la aplicación SauceDemo")
    public void queElUsuarioIngresaALaAplicacionSauceDemo() {
        OnStage.theActorInTheSpotlight().attemptsTo(
                OpenSauceDemo.page()
        );
    }

    @Cuando("carga los datos de compra desde el archivo {string}")
    public void cargaLosDatosDeCompraDesdeElArchivo(String fileName) {
        ShopData shopData = JsonReader.readShopData(fileName).get(0);

        OnStage.theActorInTheSpotlight().remember("shopData", shopData);
    }

    @Cuando("inicia sesión con los datos cargados")
    public void iniciaSesionConLosDatosCargados() {
        ShopData shopData = OnStage.theActorInTheSpotlight().recall("shopData");

        OnStage.theActorInTheSpotlight().attemptsTo(
                Login.withCredentials(shopData.getUsuario(), shopData.getClave())
        );
    }

    @Cuando("agrega los productos cargados al carrito")
    public void agregaLosProductosCargadosAlCarrito() {
        ShopData shopData = OnStage.theActorInTheSpotlight().recall("shopData");

        OnStage.theActorInTheSpotlight().attemptsTo(
                AddProductsToCart.called(shopData.getProductos())
        );
    }

    @Cuando("visualiza el carrito de compras")
    public void visualizaElCarritoDeCompras() {
        OnStage.theActorInTheSpotlight().attemptsTo(
                OpenCart.view()
        );
    }

    @Entonces("debería visualizar {int} productos en el carrito")
    public void deberiaVisualizarProductosEnElCarrito(int cantidadEsperada) {
        OnStage.theActorInTheSpotlight().should(
                seeThat(CartItemCount.displayed(), equalTo(cantidadEsperada))
        );
    }

    @Cuando("completa el formulario de compra con los datos cargados")
    public void completaElFormularioDeCompraConLosDatosCargados() {
        ShopData shopData = OnStage.theActorInTheSpotlight().recall("shopData");

        OnStage.theActorInTheSpotlight().attemptsTo(
                Checkout.process(),
                FillCheckoutForm.withData(
                        new CustomerData(
                                shopData.getNombre(),
                                shopData.getApellido(),
                                shopData.getCodigoPostal()
                        )
                )
        );
    }

    @Entonces("debería visualizar en el checkout los productos agregados")
    public void deberiaVisualizarEnElCheckoutLosProductosAgregados() {
        ShopData shopData = OnStage.theActorInTheSpotlight().recall("shopData");
        List<String> productosEsperados = shopData.getProductos();
        List<String> productosActuales = ProductosEnCheckout.mostrados()
                .answeredBy(OnStage.theActorInTheSpotlight());

        OnStage.theActorInTheSpotlight().should(
                seeThat(ProductosEnCheckout.mostrados(), equalTo(productosEsperados))
        );
    }

    @Cuando("finaliza la compra")
    public void finalizaLaCompra() {
        OnStage.theActorInTheSpotlight().attemptsTo(
                FinishPurchase.now()
        );
    }

    @Entonces("debería visualizar el mensaje de confirmación {string}")
    public void deberiaVisualizarElMensajeDeConfirmacion(String mensajeEsperado) {
        OnStage.theActorInTheSpotlight().should(
                seeThat(
                        ConfirmationMessage.displayed(),
                        containsStringIgnoringCase(mensajeEsperado)
                )
        );
    }
}