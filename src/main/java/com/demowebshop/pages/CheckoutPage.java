package com.demowebshop.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class CheckoutPage extends BasePage {

    @FindBy(id = "BillingNewAddress_FirstName")
    private WebElement firstName;

    @FindBy(id = "BillingNewAddress_LastName")
    private WebElement lastName;

    @FindBy(id = "BillingNewAddress_Email")
    private WebElement email;

    @FindBy(id = "BillingNewAddress_CountryId")
    private WebElement country;

    @FindBy(id = "BillingNewAddress_City")
    private WebElement city;

    @FindBy(id = "BillingNewAddress_Address1")
    private WebElement address;

    @FindBy(id = "BillingNewAddress_ZipPostalCode")
    private WebElement zipCode;

    @FindBy(id = "BillingNewAddress_PhoneNumber")
    private WebElement phoneNumber;

    @FindBy(css = "input[value='Continue']")
    private WebElement continueButton;

    @FindBy(xpath = "//input[@onclick='Shipping.save()']")
    private WebElement shippingContinue;

    @FindBy(xpath = "//input[@id='PickUpInStore']")
    private WebElement inStorePickup;

    @FindBy(css = "input[value='Continue']:nth-of-type(3)")
    private WebElement paymentContinue;

    @FindBy(css = "input[value='Confirm']")
    private WebElement confirmButton;

    @FindBy(css = ".title")
    private WebElement confirmationMessage;

    public CheckoutPage(WebDriver driver) {
        super(driver);
    }

    public void fillBillingAddress() {
        firstName.sendKeys("Test");
        lastName.sendKeys("User");
       // email.sendKeys("test@test.com");

        Select countrySelect = new Select(country);
        countrySelect.selectByVisibleText("United States");

        city.sendKeys("New York");
        address.sendKeys("123 Test Street");
        zipCode.sendKeys("10001");
        phoneNumber.sendKeys("1234567890");
        continueButton.click();
    }

    public void continueShipping() {
       // wait.until(d -> shippingContinue.isDisplayed());

        inStorePickup.click();
        shippingContinue.click();
    }

    public void continuePayment() throws InterruptedException{
        Thread.sleep(3000);
        paymentContinue.click();
    }

    public void confirmOrder() {
        confirmButton.click();
    }

    public String getConfirmationMessage() {
        wait.until(d -> confirmationMessage.isDisplayed());
        return confirmationMessage.getText();
    }
}