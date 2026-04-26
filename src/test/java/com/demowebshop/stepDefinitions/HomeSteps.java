package com.demowebshop.stepDefinitions;

import com.demowebshop.pages.HomePage;
import com.demowebshop.pages.LoginPage;
import com.demowebshop.utils.TestBase;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;

public class HomeSteps {
    HomePage homePage = new HomePage(TestBase.getDriver());
    LoginPage loginPage = new LoginPage(TestBase.getDriver());

    @Given("User is on the Demo Web Shop home page")
    public void user_is_on_the_demo_web_shop_home_page() throws InterruptedException {
       Thread.sleep(3000);
    }
}