package com.automation;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.CucumberOptions.SnippetType;

@CucumberOptions(features = "src\\test\\resources\\features\\HRM.feature",snippets = SnippetType.CAMELCASE, tags = "@smoke" ,plugin = "html:ExecutionReports.html")
public class TestRunner extends AbstractTestNGCucumberTests {

}
