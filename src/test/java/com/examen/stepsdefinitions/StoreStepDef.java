package com.examen.stepsdefinitions;

import com.examen.steps.LoginSteps;
import com.examen.steps.ProductSteps;
import com.examen.steps.ShopCartSteps;
import com.examen.steps.ShopSteps;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;

import java.time.Duration;

import static com.examen.core.DriverManager.getDriver;
import static com.examen.core.DriverManager.screenShot;

public class StoreStepDef {
    private WebDriver driver;
    LoginSteps loginSteps;
    ProductSteps productSteps;
    ShopSteps shopSteps;
    ShopCartSteps shopCartSteps;
    int cantidad = 0;
    @Given("estoy en la página de la tienda")
    public void estoyEnLaPaginaDeLaTienda() {
        driver = getDriver();
        driver.get("https://qalab.bensg.com/store");
    }

    @And("me logueo con mi usuario {string} y clave {string}")
    public void meLogueoConMiUsuarioYClave(String user, String password) {
        loginSteps = new LoginSteps(driver);
        loginSteps.initLogin();
        loginSteps.typeUser(user);
        loginSteps.typePassword(password);
        loginSteps.login();
        loginSteps.validarSpanAccount();
        screenShot();
    }

    @When("navego a la categoria {string} y subcategoria {string}")
    public void navegoALaCategoriaYSubcategoria(String categoria, String subcategoria) {
        productSteps = new ProductSteps(driver);
        productSteps.clickCategory(categoria);
        productSteps.clickSubCategory(subcategoria);
    }

    @And("agrego {} unidades del primer producto al carrito")
    public void agregoUnidadesDelPrimerProductoAlCarrito(int cantidad) {
        productSteps.selectFirtProduct();
        shopSteps = new ShopSteps(driver);
        shopSteps.addQuantity(cantidad);
        this.cantidad = cantidad;
        screenShot();
    }

    @Then("valido en el popup la confirmación del producto agregado")
    public void validoEnElPopupLaConfirmacionDelProductoAgregado() {
        shopSteps.clicAddShopCart();
        shopSteps.validarModelExito();
    }

    @And("valido en el popup que el monto total sea calculado correctamente")
    public void validoEnElPopupQueElMontoTotalSeaCalculadoCorrectamente() {
        shopSteps.validarMontoCalculado();
    }

    @When("finalizo la compra")
    public void finalizoLaCompra() {
        shopSteps.clicFinishShop();
    }

    @Then("valido el titulo de la pagina del carrito")
    public void validoElTituloDeLaPaginaDelCarrito() {
        loginSteps.validarCantidadEnCarrito(cantidad);
    }

    @And("vuelvo a validar el calculo de precios en el carrito")
    public void vuelvoAValidarElCalculoDePreciosEnElCarrito() {
        loginSteps.clicShopCart();
        shopCartSteps = new ShopCartSteps(driver);
        shopCartSteps.validarMonto();
    }
}
