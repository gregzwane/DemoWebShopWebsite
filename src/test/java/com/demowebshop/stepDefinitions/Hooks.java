package com.demowebshop.stepDefinitions;

import com.demowebshop.utils.TestBaseLocal;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks {

    @Before
    public void setUp() {
        TestBaseLocal.initializeDriver();
    }

    @After
    public void tearDown() {
        TestBaseLocal.quitDriver();
    }
}