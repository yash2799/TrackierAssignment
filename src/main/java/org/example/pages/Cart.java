package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Cart {
    private WebDriver driver;

    private By checkoutButton = By.className("checkout_button");

    public Cart(WebDriver driver) {
        this.driver = driver;
    }

    public void clickCheckout() {
        driver.findElement(checkoutButton).click();
    }
}
