package com.thoughtworks.calc;

import org.jbehave.web.selenium.WebDriverProvider;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;

import java.io.File;

public class FirefoxDriverProvider implements WebDriverProvider {
    private WebDriver driver;

    public WebDriver get() {
       return driver;
    }

    public void initialize() {
        // Sometimes you want to start firefox with a specific profile.
        // On windows, profiles are typically found in: c:\Documents and Settings\<user>\Application Data\Firefox\Profiles
        //FirefoxProfile profileDir = new FirefoxProfile(new File("C:\\some-dir"));
        //driver = new FirefoxDriver(profileDir);
        driver = new FirefoxDriver();
    }

    public void quit() {
        driver.quit();
    }

    public boolean saveScreenshotTo(String s) {
        return false;
    }
}
