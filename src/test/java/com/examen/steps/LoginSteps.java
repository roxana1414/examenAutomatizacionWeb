package com.examen.steps;

import com.examen.page.LoginPage;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class LoginSteps {

    private WebDriver driver;

    //constructor
    public LoginSteps(WebDriver driver){
        this.driver = driver;
    }

    /**
     * Escribir el usuario
     * @param user el usuario
     */
    public void typeUser(String user){
        WebElement userInputElement = driver.findElement(LoginPage.userInput);
        userInputElement.sendKeys(user);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
        wait.until(ExpectedConditions.visibilityOfElementLocated(LoginPage.loginButton));

    }

    /**
     * Escribir el password
     * @param password el password del usuario
     */
    public void typePassword(String password){
        this.driver.findElement(LoginPage.passInput).sendKeys(password);
    }

    /**
     * Hacer click en el botón login
     */
    public void login(){
        this.driver.findElement(LoginPage.loginButton).click();
    }

    public void initLogin() {
        WebElement initLoginElement = driver.findElement(LoginPage.initLogin);
        initLoginElement.click();
    }

    public void validarCantidadEnCarrito(int cantidad){
        WebElement cartSpanElement = driver.findElement(LoginPage.cartSpan);
        int cantidaInt =Integer.parseInt(cartSpanElement.getText().replace("(","").replace(")",""));
        System.out.println("cantidaInt "+cantidaInt);
        Assertions.assertTrue(cantidaInt == cantidad);
    }

    public void clicShopCart() {
        WebElement cartShopBtnElement = driver.findElement(LoginPage.cartShopBtn);
        cartShopBtnElement.click();
    }

    public void validarSpanAccount() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
        wait.until(ExpectedConditions.visibilityOfElementLocated(LoginPage.accountSpan));
    }
}
