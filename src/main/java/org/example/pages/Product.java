package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Product {
    private WebDriver driver;

    private By addToCartButton = By.className("btn_primary");
    private By cartIcon = By.className("shopping_cart_link");

    public Product(WebDriver driver) {
        this.driver = driver;
    }

    public void addFirstProductToCart() {
        driver.findElement(addToCartButton).click();
    }

    public void clickCartIcon() {
        driver.findElement(cartIcon).click();
    }
}
