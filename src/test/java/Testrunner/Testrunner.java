package Testrunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = ".\\src\\test\\resources\\features",
glue = {"stepdefs","Apphooks"},
dryRun = false,
monochrome = true,
plugin = {"pretty","rerun:target/rerun.txt","html:target/report.html"},
tags = "not @initial"

		)

public class Testrunner {

}
