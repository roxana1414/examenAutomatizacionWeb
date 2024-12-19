package com.examen.steps;

import com.examen.page.LoginPage;
import com.examen.page.ShopPage;
import io.cucumber.java.eo.Do;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static com.examen.core.DriverManager.screenShot;


public class ShopSteps {

    private WebDriver driver;

    //constructor
    public ShopSteps(WebDriver driver){
        this.driver = driver;
    }

    public void addQuantity(int cantidad){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
        wait.until(ExpectedConditions.visibilityOfElementLocated(ShopPage.quantityWanted));
        WebElement quantityWantedElement = driver.findElement(ShopPage.quantityWanted);
        for (int i= 0; i <cantidad-1;i++){
            quantityWantedElement.click();
        }
    }

    public void clicAddShopCart(){
        WebElement shopAddBtnElement = driver.findElement(ShopPage.shopAddBtn);
        shopAddBtnElement.click();
    }

    public void validarModelExito(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
        wait.until(ExpectedConditions.visibilityOfElementLocated(ShopPage.textModal));
        WebElement modalElement = driver.findElement(ShopPage.textModal);
        String tituloExito = "producto añadido correctamente";
        Assertions.assertTrue(modalElement.getText().toLowerCase().contains(tituloExito.toLowerCase()));
    }

    public void validarMontoCalculado() {
        WebElement textPriceElement = driver.findElement(ShopPage.textPrice);
        WebElement textQuantityElement = driver.findElement(ShopPage.textQuantity);
        WebElement textSubTotalElement = driver.findElement(ShopPage.textSubTotal);
        double price = Double.parseDouble(textPriceElement.getText().split(" ")[0].replace(',', '.'));
        int quantity = Integer.parseInt(textQuantityElement.getText());
        double subTotal = Double.parseDouble(textSubTotalElement.getText().split(" ")[0].replace(',', '.'));
        Assertions.assertTrue(subTotal == price*quantity);
    }

    public void clicFinishShop() {
        WebElement finishShopBtnElement = driver.findElement(ShopPage.finishShopBtn);
        finishShopBtnElement.click();
    }
}
