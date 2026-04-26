package com.demowebshop.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ComputersPage extends BasePage {

    @FindBy(linkText = "Desktops")
    private WebElement desktopsLink;

    @FindBy(linkText = "Notebooks")
    private WebElement notebooksLink;

    @FindBy(linkText = "Accessories")
    private WebElement accessoriesLink;

    @FindBy(linkText = "Build your own computer")
    private WebElement buildComputerLink;

    @FindBy(id = "add-to-cart-button-1")
    private WebElement addToCartButton;

    @FindBy(css = ".ico-cart")
    private WebElement shoppingCartLink;

    @FindBy(css = ".product-name")
    private WebElement productName;

    public ComputersPage(WebDriver driver) {
        super(driver);
    }

    public void selectBuildComputer() {
        buildComputerLink.click();
    }

    public void addToCart() {
        addToCartButton.click();
    }

    public void goToShoppingCart() {
        shoppingCartLink.click();
    }

    public String getProductName() {
        return productName.getText();
    }
}