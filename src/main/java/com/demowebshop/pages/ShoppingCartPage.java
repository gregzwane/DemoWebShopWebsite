package com.demowebshop.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ShoppingCartPage extends BasePage {

    @FindBy(id = "termsofservice")
    private WebElement termsCheckbox;

    @FindBy(id = "checkout")
    private WebElement checkoutButton;

    public ShoppingCartPage(WebDriver driver) {
        super(driver);
    }

    public void acceptTermsAndCheckout() {
        termsCheckbox.click();
        checkoutButton.click();
    }
}