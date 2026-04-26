package com.demowebshop.stepDefinitions;

import com.demowebshop.pages.HomePage;
import com.demowebshop.pages.LoginPage;
import com.demowebshop.utils.TestBase;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class LoginSteps {

    HomePage homePage = new HomePage(TestBase.getDriver());
    LoginPage loginPage = new LoginPage(TestBase.getDriver());

    @And("User logs out")
    public void userLogsOut() {
        homePage.clickLogout();
    }

    @And("User logs in with registered credentials")
    public void userLogsInWithRegisteredCredentials() {
        homePage.clickLogin();
        loginPage.login(TestBase.getRegisteredEmail(), TestBase.getRegisteredPassword());
    }

    @Then("User should be logged in successfully")
    public void userShouldBeLoggedInSuccessfully() {
        String email = homePage.getAccountEmail();
        Assert.assertEquals(email, TestBase.getRegisteredEmail());
    }
}