package com.demowebshop.stepDefinitions;

import com.demowebshop.pages.HomePage;
import com.demowebshop.pages.RegisterPage;
import com.demowebshop.utils.TestBaseLocal;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class RegistrationSteps {

    HomePage homePage = new HomePage(TestBaseLocal.getDriver());
    RegisterPage registerPage = new RegisterPage(TestBaseLocal.getDriver());

    @When("User navigates to registration page")
    public void userNavigatesToRegistrationPage() {
        homePage.clickRegister();
    }

    @And("User registers with new credentials")
    public void userRegistersWithNewCredentials() {
        registerPage.registerNewUser();
        TestBaseLocal.setRegisteredEmail(registerPage.getRegisteredEmail());
        TestBaseLocal.setRegisteredPassword(registerPage.getRegisteredPassword());
    }

    @Then("User should see registration success message")
    public void userShouldSeeRegistrationSuccessMessage() {
        String message = registerPage.getSuccessMessage();
        Assert.assertTrue(message.contains("completed"));
    }
}