package com.tabcorp.testCases;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

/**
 * Created by chanielyu on 27/2/17.
 * SunbetsTest
 */
@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {
                "pretty",
                "html:build/cucumber",
                "json:build/cucumber.json",
                "junit:build/cucumber.xml"
        },
        features = {"src/test/resources/features/sunbets"},
        glue = {"com.tabcorp.steps"}
)
public class SunbetsTest {
}
