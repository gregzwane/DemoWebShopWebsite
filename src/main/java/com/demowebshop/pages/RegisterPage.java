package com.demowebshop.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import java.util.Random;

public class RegisterPage extends BasePage {

    @FindBy(id = "gender-male")
    private WebElement genderMale;

    @FindBy(id = "FirstName")
    private WebElement firstName;

    @FindBy(id = "LastName")
    private WebElement lastName;

    @FindBy(id = "Email")
    private WebElement email;

    @FindBy(id = "Password")
    private WebElement password;

    @FindBy(id = "ConfirmPassword")
    private WebElement confirmPassword;

    @FindBy(id = "register-button")
    private WebElement registerButton;

    @FindBy(css = ".result")
    private WebElement successMessage;

    private String generatedEmail;
    private String generatedPassword = "Test@123";

    public RegisterPage(WebDriver driver) {
        super(driver);
    }

    public void registerNewUser() {
        genderMale.click();
        firstName.sendKeys("Test");
        lastName.sendKeys("User");

        Random rand = new Random();
        generatedEmail = "testuser" + rand.nextInt(10000) + "@test.com";
        email.sendKeys(generatedEmail);

        password.sendKeys(generatedPassword);
        confirmPassword.sendKeys(generatedPassword);
        registerButton.click();
    }

    public String getSuccessMessage() {
        return successMessage.getText();
    }

    public String getRegisteredEmail() {
        return generatedEmail;
    }

    public String getRegisteredPassword() {
        return generatedPassword;
    }
}