package com.demowebshop.stepDefinitions;

import com.demowebshop.pages.*;
import com.demowebshop.utils.TestBase;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class OrderSteps {

    HomePage homePage = new HomePage(TestBase.getDriver());
    ComputersPage computersPage = new ComputersPage(TestBase.getDriver());
    ShoppingCartPage cartPage = new ShoppingCartPage(TestBase.getDriver());
    CheckoutPage checkoutPage = new CheckoutPage(TestBase.getDriver());

    @When("User navigates to Computers category")
    public void userNavigatesToComputersCategory() {
        homePage.clickComputers();
    }

    @And("User selects Building Computers")
    public void userSelectsBuildingComputers() {
        computersPage.selectBuildComputer();
    }

    @And("User adds a computer to cart")
    public void userAddsAComputerToCart()throws InterruptedException {
        Thread.sleep(2000);
        computersPage.addToCart();
    }

    @Then("User should see item added to cart")
    public void userShouldSeeItemAddedToCart() throws InterruptedException {
        Thread.sleep(2000);
        computersPage.goToShoppingCart();
    }

    @And("User proceeds to checkout")
    public void userProceedsToCheckout() throws InterruptedException{
        cartPage.shoppingCartList();
        Thread.sleep(3000);
        cartPage.estimateCountry();
        cartPage.acceptTermsAndCheckout();
    }

    @And("User fills billing and shipping information")
    public void userFillsBillingAndShippingInformation()throws InterruptedException {
        checkoutPage.fillBillingAddress();
        Thread.sleep(2000);
        checkoutPage.continueShipping();
        Thread.sleep(2000);
        checkoutPage.continuePayment();
    }

    @And("User places the order")
    public void userPlacesTheOrder() throws InterruptedException{
        checkoutPage.confirmOrder();
    }

    @Then("User should see order confirmation")
    public void userShouldSeeOrderConfirmation() throws InterruptedException{
        String message = checkoutPage.getConfirmationMessage();
        Assert.assertTrue(message.contains("Your order has been successfully processed"));
    }
}