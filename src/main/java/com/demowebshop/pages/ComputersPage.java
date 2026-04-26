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

    @FindBy(linkText = "Desktops")
    private WebElement buildComputerLink;

    @FindBy(xpath = "//div[@class='page-body']//div[2]//div[1]//div[2]//div[3]//div[2]//input[1]")
    private WebElement addToCartButton;

    @FindBy(xpath ="//input[@id='product_attribute_16_3_6_19']")
    private WebElement hddButton;

    @FindBy(id = "add-to-cart-button-16")
    private WebElement addToCartDetailsButton;

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

    public void addToCart() throws InterruptedException {
        addToCartButton.click();
        Thread.sleep(3000);
        hddButton.click();
        addToCartDetailsButton.click();
    }

    public void goToShoppingCart() {
        shoppingCartLink.click();
    }

    public String getProductName() {
        return productName.getText();
    }
}