package com.demowebshop.stepDefinitions;

import com.demowebshop.pages.HomePage;
import com.demowebshop.pages.LoginPage;
import com.demowebshop.utils.TestBaseLocal;
import io.cucumber.java.en.Given;

public class HomeSteps {
    HomePage homePage = new HomePage(TestBaseLocal.getDriver());
    LoginPage loginPage = new LoginPage(TestBaseLocal.getDriver());

    @Given("User is on the Demo Web Shop home page")
    public void user_is_on_the_demo_web_shop_home_page() throws InterruptedException {
       Thread.sleep(3000);
    }
}