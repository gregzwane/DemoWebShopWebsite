package com.demowebshop.stepDefinitions;

import com.demowebshop.pages.HomePage;
import com.demowebshop.pages.RegisterPage;
import com.demowebshop.utils.TestBase;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class RegistrationSteps {

    HomePage homePage = new HomePage(TestBase.getDriver());
    RegisterPage registerPage = new RegisterPage(TestBase.getDriver());

    @When("User navigates to registration page")
    public void userNavigatesToRegistrationPage() {
        homePage.clickRegister();
    }

    @And("User registers with new credentials")
    public void userRegistersWithNewCredentials() {
        registerPage.registerNewUser();
        TestBase.setRegisteredEmail(registerPage.getRegisteredEmail());
        TestBase.setRegisteredPassword(registerPage.getRegisteredPassword());
    }

    @Then("User should see registration success message")
    public void userShouldSeeRegistrationSuccessMessage() {
        String message = registerPage.getSuccessMessage();
        Assert.assertTrue(message.contains("completed"));
    }
}