package com.thoughtworks.calc;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpMethod;
import org.apache.commons.httpclient.methods.GetMethod;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

import java.io.IOException;
import java.net.URLEncoder;

import static org.junit.Assert.assertTrue;

public class GoogleSteps {

    private String lastResponse;

    @When("I search for $text")
    public void executeSearch(String text) throws IOException {
        HttpClient client = new HttpClient();
        HttpMethod method = new GetMethod("http://ajax.googleapis.com/ajax/services/search/web?v=1.0&q="+ URLEncoder.encode(text));
        try {
            client.executeMethod(method);
            lastResponse = method.getResponseBodyAsString();
        } finally {
            method.releaseConnection();
        }
    }

    @Then("I should get back json containing $text")
    public void assertResultContains(String text) {
        assertTrue(lastResponse.contains(text));
    }

}
