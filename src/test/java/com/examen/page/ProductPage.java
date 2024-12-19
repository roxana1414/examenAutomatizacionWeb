package com.examen.page;

import org.openqa.selenium.By;

public class ProductPage {

    public static By category = By.xpath("//li[@class=\"category\" ]");
    public static By subCategory = By.xpath("//ul[@class=\"subcategories-list\"]/li");
    public static By firstProduct = By.xpath("//div[@class=\"products row\"]/div[1]");

}
