package com.tabcorp.testCases;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

/**
 * Created by chanielyu on 2017/2/26.
 * MobileTest
 */
@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {
                "pretty",
                "html:build/cucumber",
                "json:build/cucumber.json",
                "junit:build/cucumber.xml"
        },
        features = {"src/test/resources/TABcorp"},
        glue = {"com.tabcorp.steps"}
)
public class MobileTest {
}
