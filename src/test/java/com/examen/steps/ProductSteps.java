package com.examen.steps;

import com.examen.page.LoginPage;
import com.examen.page.ProductPage;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;


public class ProductSteps {

    private WebDriver driver;

    //constructor
    public ProductSteps(WebDriver driver){
        this.driver = driver;
    }

    public void clickCategory(String categoryName){
        List<WebElement> categoryElements = driver.findElements(ProductPage.category);
        boolean categoryFound = false;
        WebElement categoryFoundElement = null;
        // Itera sobre los elementos encontrados
        for (WebElement categoryElement : categoryElements) {
            if (categoryElement.getText().equalsIgnoreCase(categoryName)) {
                categoryFound = true;
                categoryFoundElement = categoryElement;
            }
        }
        if (!categoryFound){
            throw new AssertionError("Categoría '" + categoryName + "' no encontrada");
        }else {
            categoryFoundElement.click();
        }
    }

    public void clickSubCategory(String subCategory){
        List<WebElement> subCategoryElements = driver.findElements(ProductPage.subCategory);
        // Itera sobre los elementos encontrados
        for (WebElement subCategoryElement : subCategoryElements) {
            if (subCategoryElement.getText().equalsIgnoreCase(subCategory)) {
                subCategoryElement.click();
                break;
            }
        }
    }
    public void selectFirtProduct(){
        WebElement firstProductElement = driver.findElement(ProductPage.firstProduct);
        firstProductElement.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

}
