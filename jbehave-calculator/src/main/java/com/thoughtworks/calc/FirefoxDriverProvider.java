package com.thoughtworks.calc;

import org.jbehave.web.selenium.WebDriverProvider;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FirefoxDriverProvider implements WebDriverProvider {
    private WebDriver driver;

    public WebDriver get() {
       return driver;
    }

    public void initialize() {
        driver = new FirefoxDriver();
    }

    public void quit() {
        driver.quit();
    }

    public boolean saveScreenshotTo(String s) {
        return false;
    }
}
