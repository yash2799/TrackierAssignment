package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Checkout {
    private WebDriver driver;

    private By firstNameInput = By.id("first-name");
    private By lastNameInput = By.id("last-name");
    private By zipCodeInput = By.id("postal-code");
    private By continueButton = By.cssSelector(".btn_primary.cart_button");

    public Checkout(WebDriver driver) {
        this.driver = driver;
    }

    public void enterFirstName(String firstName) {
        driver.findElement(firstNameInput).sendKeys(firstName);
    }

    public void enterLastName(String lastName) {
        driver.findElement(lastNameInput).sendKeys(lastName);
    }

    public void enterZipCode(String zipCode) {
        driver.findElement(zipCodeInput).sendKeys(zipCode);
    }

    public void clickContinue() {
        driver.findElement(continueButton).click();
    }
}
