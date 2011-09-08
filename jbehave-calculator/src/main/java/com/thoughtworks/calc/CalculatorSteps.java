package com.thoughtworks.calc;

import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

import static org.junit.Assert.assertEquals;

public class CalculatorSteps {

    private int result;

    @When("I add $first and $second")
    public void add(int first, int second) {
        result = first + second;
    }

    @Then("Calculator should return $result")
    public void checkResult(int result) {
       assertEquals(this.result, result);
    }
}
