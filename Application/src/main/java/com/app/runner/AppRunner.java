package com.app.runner;


import cucumber.api.CucumberOptions;


@CucumberOptions(features = "C:\\Users\\rebammid\\eclipse-workspace\\Application\\src\\main\\java\\com\\app\\feature\\App.feature",
                 glue = {"C:\\Users\\rebammid\\eclipse-workspace\\Application\\src\\main\\java\\com\\app\\step\\AppStep.java"},
                 monochrome = true,
                 format = {"pretty", "html:test-output"},
                 dryRun = true)
public class AppRunner {

}
