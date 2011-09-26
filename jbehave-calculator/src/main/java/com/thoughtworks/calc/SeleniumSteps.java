package com.thoughtworks.calc;

import com.thoughtworks.selenium.DefaultSelenium;
import org.jbehave.core.annotations.Given;

import java.net.MalformedURLException;

public class SeleniumSteps {


    @Given("I am using selenium RC to go to Google's home page")
    public void gotoGoogle() throws MalformedURLException {
        // Need to start the selenium server: java -jar selenium-server.jar
        DefaultSelenium selenium = new DefaultSelenium("localhost", 4444, "firefox", "http://www.google.com/");
        selenium.start();
        selenium.open("/");
    }

}
