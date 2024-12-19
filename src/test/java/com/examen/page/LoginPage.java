package com.examen.page;

import org.openqa.selenium.By;

public class LoginPage {
    public static By initLogin = By.xpath("//div[@class=\"user-info\"]/a");
    public static By userInput = By.id("field-email");
    public static By passInput = By.id("field-password");
    public static By loginButton = By.id("submit-login");
    public static By cartSpan = By.xpath("//span[@class=\"cart-products-count\"]");
    public static By cartShopBtn = By.xpath("//div[@class=\"header\"]/a");
    public static By accountSpan = By.xpath("//a[@class=\"account\"]");

}
