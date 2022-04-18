package com.libraryCT.steps_definitions;

import com.libraryCT.testbase.PagesInitializer;
import com.libraryCT.utils.BrowserUtils;
import com.libraryCT.utils.Driver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks {

    @Before
    public void setupDriver(Scenario scenario){
        System.out.println(">> Scenario name: "+scenario.getName());
        PagesInitializer.initializePageObjects();
    }

    @After
    public void tearDown(Scenario scenario){
        if(scenario.isFailed()) {
            byte[] screenshot;
            screenshot = BrowserUtils.takeScreenshot("failed/" + scenario.getName());
            scenario.attach(screenshot, "image/png", scenario.getName());
        }
        Driver.closeDriver();
    }
}
