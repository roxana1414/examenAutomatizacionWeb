package com.examen.page;

import org.openqa.selenium.By;

public class ShopPage {

    public static By quantityWanted = By.xpath("//span[@class=\"input-group-btn-vertical\"]/button");
    public static By shopAddBtn = By.xpath("//button[@class=\"btn btn-primary add-to-cart\"]");
    public static By textModal = By.xpath("//div[@id=\"blockcart-modal\"]//h4");
    public static By textPrice = By.xpath("//p[@class=\"product-price\"]");
    public static By textQuantity = By.xpath("//span[@class=\"product-quantity\"]/strong");
    public static By textSubTotal = By.xpath("//span[@class=\"subtotal value\"]");
    public static By finishShopBtn = By.xpath("//a[text()=\"Finalizar compra\"]");
}
