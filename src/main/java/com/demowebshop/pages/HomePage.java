package com.demowebshop.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

    @FindBy(linkText = "Register")
    private WebElement registerLink;

    @FindBy(linkText = "Log in")
    private WebElement loginLink;

    @FindBy(linkText = "Log out")
    private WebElement logoutLink;

    @FindBy(linkText = "Computers")
    private WebElement computersLink;

    @FindBy(css = ".account")
    private WebElement accountEmail;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void clickRegister() {
        registerLink.click();
    }

    public void clickLogin() {
        loginLink.click();
    }

    public void clickLogout() {
        logoutLink.click();
    }

    public void clickComputers() {
        computersLink.click();
    }

    public String getAccountEmail() {
        return accountEmail.getText();
    }
}