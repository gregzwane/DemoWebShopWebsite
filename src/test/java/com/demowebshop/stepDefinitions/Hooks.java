package com.demowebshop.stepDefinitions;

import com.demowebshop.utils.TestBase;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks {

    @Before
    public void setUp() {
        TestBase.initializeDriver();
    }

    @After
    public void tearDown() {
        TestBase.quitDriver();
    }
}