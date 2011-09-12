package com.thoughtworks.calc;

import com.google.common.base.Function;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.jbehave.web.selenium.WebDriverPage;
import org.jbehave.web.selenium.WebDriverProvider;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.Assert.assertTrue;

public class WebSteps extends WebDriverPage {

    public WebSteps(WebDriverProvider driverProvider) {
        super(driverProvider);
    }

    @Given("I am on Google's home page")
    public void gotoGoogle() {
        get("http://www.google.com/firefox?client=firefox-a&rls=org.mozilla:en-US:official");
    }

    @When("I enter $text in the search field")
    public void enterSearchText(String text) {
        WebElement searchField = findElement(By.id("sf"));
        searchField.sendKeys(text);
    }

    @When("I click search")
    public void clickSearch() {
        WebElement searchBtn = findElement(By.name("btnG"));
        searchBtn.click();
    }

    @Then("I should see page with $expected")
    public void pageContains(String expected) {
        assertTrue(getPageSource().contains(expected));
    }

    protected WebElement waitForElement(final By by) {
        return new WebDriverWait(webDriver(), 5).until(new Function<WebDriver, WebElement>() {
            public WebElement apply(WebDriver webDriver) {
                return findElement(by);
            }
        });
    }
}
