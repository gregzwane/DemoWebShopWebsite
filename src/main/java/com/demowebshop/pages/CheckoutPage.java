package com.demowebshop.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.WheelInput;
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

    @FindBy(xpath = "//input[@class='button-1 payment-method-next-step-button']")
    private WebElement paymentContinue;
    @FindBy(xpath = "//input[@class='button-1 payment-info-next-step-button']")
    private WebElement paymentInformationContinue;

    @FindBy(css = "input[value='Confirm']")
    private WebElement confirmButton;

    @FindBy(xpath = "//strong[normalize-space()='Your order has been successfully processed!']")
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
        Thread.sleep(2000);
        paymentContinue.click();
        Thread.sleep(2000);
        paymentInformationContinue.click();
        Thread.sleep(2000);
    }

    public void confirmOrder() throws InterruptedException{
        WheelInput.ScrollOrigin scrollOrigin = WheelInput.ScrollOrigin.fromViewport(10, 10);
        new Actions(driver)
                .scrollFromOrigin(scrollOrigin, 0, 250)
                .perform();
        confirmButton.click();
        Thread.sleep(1000);
    }

    public String getConfirmationMessage()throws InterruptedException {
        //wait.until(d -> confirmationMessage.isDisplayed());
        Thread.sleep(2000);
        System.out.println(confirmationMessage.getText());
        return confirmationMessage.getText();

    }
}