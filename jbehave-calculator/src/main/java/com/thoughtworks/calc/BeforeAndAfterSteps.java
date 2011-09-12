package com.thoughtworks.calc;


import org.jbehave.core.annotations.AfterStory;
import org.jbehave.core.annotations.BeforeStory;

public class BeforeAndAfterSteps {
    private FirefoxDriverProvider driverProvider;

    public BeforeAndAfterSteps(FirefoxDriverProvider driver) {
        this.driverProvider = driver;
    }

    @AfterStory
    public void teardown() {
        driverProvider.quit();
    }

    @BeforeStory
    public void beforeStory() {
        driverProvider.initialize();
    }

}
