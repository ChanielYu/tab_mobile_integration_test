package com.tabcorp.testCases;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

/**
 * Created by chanielyu on 1/3/17.
 * TabTest
 */
@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {
                "pretty",
                "html:build/cucumber",
                "json:build/cucumber.json",
                "junit:build/cucumber.xml"
        },
        features = {
                "src/test/resources/features/tab/Login.feature"
                //,"src/test/resources/features/CleanUp.feature"
                ,"src/test/resources/features/tab/LeftHomeMenu.feature"
        },
        tags={"@android"},
        glue = {"com.tabcorp.steps"}
)
public class TabTest {
}
