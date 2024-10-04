package tests;

import org.example.pages.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;

public class CheckoutTests {
    private WebDriver driver;

    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().setup();
       driver = new ChromeDriver();
        driver.manage().window().maximize();
       driver.get("https://www.saucedemo.com");
        driver.close();
    }

    @Test
    public void testCheckoutProcess() {
        Login loginPage = new Login(driver);
        loginPage.enterUsername("standard_user");
        loginPage.enterPassword("secret_sauce");
        loginPage.clickLogin();

        Product productPage = new Product(driver);
        productPage.addFirstProductToCart();
        productPage.clickCartIcon();

        Cart cartPage = new Cart(driver);
        cartPage.clickCheckout();

        Checkout checkoutPage = new Checkout(driver);
        checkoutPage.enterFirstName("John");
        checkoutPage.enterLastName("Doe");
        checkoutPage.enterZipCode("12345");
        checkoutPage.clickContinue();

        CheckoutOverview overviewPage = new CheckoutOverview(driver);
        Assert.assertTrue(overviewPage.getItemNames().contains("Sauce Labs Backpack"));
        Assert.assertTrue(overviewPage.getItemPrices().contains("$29.99"));

        overviewPage.clickFinish();
        Assert.assertEquals(overviewPage.getCompleteMessage(), "Thank you for your order!");
    }

    @Test
    public void testBackButtonFunctionality() {
        Login loginPage = new Login(driver);
        loginPage.enterUsername("standard_user");
        loginPage.enterPassword("secret_sauce");
        loginPage.clickLogin();

        Product productPage = new Product(driver);
        productPage.addFirstProductToCart();
        productPage.clickCartIcon();

        Cart cartPage = new Cart(driver);
        cartPage.clickCheckout();

        Checkout checkoutPage = new Checkout(driver);
        checkoutPage.enterFirstName("John");
        checkoutPage.enterLastName("Doe");
        checkoutPage.enterZipCode("12345");
        checkoutPage.clickContinue();

        CheckoutOverview overviewPage = new CheckoutOverview(driver);
        overviewPage.clickFinish();
        Assert.assertEquals(overviewPage.getCompleteMessage(), "Thank you for your order!");

        overviewPage.goBack();
        Assert.assertTrue(overviewPage.getItemNames().contains("Sauce Labs Backpack"));

    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
