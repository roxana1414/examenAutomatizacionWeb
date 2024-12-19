package com.examen.steps;

import com.examen.page.ShopCartPage;
import com.examen.page.ShopPage;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class ShopCartSteps {

    private WebDriver driver;

    //constructor
    public ShopCartSteps(WebDriver driver){
        this.driver = driver;
    }

    public void validarMonto(){
        WebElement quantitySpanElement = driver.findElement(ShopCartPage.quantitySpan);
        WebElement currentPriceElement = driver.findElement(ShopCartPage.currentPrice);
        WebElement subTotalSpanElement = driver.findElement(ShopCartPage.subTotalSpan);

        System.out.println("quantitySpanElement "+ quantitySpanElement.getAttribute("value"));
        System.out.println("currentPriceElement "+ currentPriceElement.getText());
        System.out.println("subTotalSpanElement "+ subTotalSpanElement.getText());

        int quantityInt = Integer.parseInt(quantitySpanElement.getAttribute("value"));
        double currenPriceDouble = Double.parseDouble(currentPriceElement.getText().split(" ")[0].replace(",","."));
        double subTotalDouble = Double.parseDouble(subTotalSpanElement.getText().split(" ")[0].replace(",","."));
        Assertions.assertTrue(subTotalDouble == quantityInt*currenPriceDouble);
    }
}
