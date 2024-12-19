package com.examen.page;

import org.openqa.selenium.By;

public class ShopCartPage {
    public static By subTotalSpan = By.xpath("//span[@class=\"product-price\"]/strong");
    public static By quantitySpan = By.xpath("//div[@class=\"input-group bootstrap-touchspin\"]/input");
    public static By currentPrice = By.xpath("//div[@class=\"current-price\"]/span");
}
