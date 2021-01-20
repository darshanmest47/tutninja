package Testrunner;


import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "@target/rerun.txt",
glue = {"stepdefs","Apphooks"},
dryRun = false,
monochrome = true,
plugin = {"pretty","rerun:target/rerun.txt"})
public class Retest {

}
