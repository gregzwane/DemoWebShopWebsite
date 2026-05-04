package com.demowebshop.stepDefinitions;

import com.demowebshop.pages.HomePage;
import com.demowebshop.pages.LoginPage;
import com.demowebshop.utils.TestBaseLocal;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.testng.Assert;

public class LoginSteps {

    HomePage homePage = new HomePage(TestBaseLocal.getDriver());
    LoginPage loginPage = new LoginPage(TestBaseLocal.getDriver());

    @And("User logs out")
    public void userLogsOut() {
        homePage.clickLogout();
    }

    @And("User logs in with registered credentials")
    public void userLogsInWithRegisteredCredentials() {
        homePage.clickLogin();
        loginPage.login(TestBaseLocal.getRegisteredEmail(), TestBaseLocal.getRegisteredPassword());
    }

    @Then("User should be logged in successfully")
    public void userShouldBeLoggedInSuccessfully() {
        String email = homePage.getAccountEmail();
        Assert.assertEquals(email, TestBaseLocal.getRegisteredEmail());
    }
}