package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class CheckoutOverview {
    private WebDriver driver;
    private WebDriverWait wait;

    private By itemName = By.className("inventory_item_name");
    private By itemPrice = By.className("inventory_item_price");
    private By finishButton = By.className("btn_action.cart_button");
    private By completeMessage = By.className("complete-header");

    public CheckoutOverview(WebDriver driver) {
        this.driver = driver;
    }

    public List<String> getItemNames() {
        return driver.findElements(itemName).stream().map(e -> e.getText()).collect(Collectors.toList());
    }

    public List<String> getItemPrices() {
        return driver.findElements(itemPrice).stream().map(e -> e.getText()).collect(Collectors.toList());
    }

    public void clickFinish() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("btn_action cart_button")));
        wait.until(ExpectedConditions.elementToBeClickable(By.className("btn_action cart_button"))).click();
    }


    public String getCompleteMessage() {
        return driver.findElement(completeMessage).getText();
    }

    public void goBack() {
        driver.navigate().back();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("inventory_item_name"))); // Wait for the item names to appear
    }
}


