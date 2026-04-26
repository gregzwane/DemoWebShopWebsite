package com.demowebshop.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class ShoppingCartPage extends BasePage {

    @FindBy(id = "termsofservice")
    private WebElement termsCheckbox;

    @FindBy(id = "checkout")
    private WebElement checkoutButton;
    @FindBy(xpath = "//span[normalize-space()='Shopping cart']")
    private WebElement cartListLink;


    public ShoppingCartPage(WebDriver driver) {
        super(driver);
    }

    public void acceptTermsAndCheckout() {
        termsCheckbox.click();
        checkoutButton.click();
    }
    public void shoppingCartList()
    {
        cartListLink.click();

    }
    public void estimateCountry(){
        Select drpCountry = new Select(driver.findElement(By.name("CountryId")));
        drpCountry.selectByVisibleText("United States");

    }
}