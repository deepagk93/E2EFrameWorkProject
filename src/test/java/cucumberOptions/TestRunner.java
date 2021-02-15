package cucumberOptions;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
//import io.cucumber.junit.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions; 

//import cucumber.api.CucumberOptions;
//import cucumber.api.junit.Cucumber;


//@RunWith(Cucumber.class)
@CucumberOptions(
		features={"src/test/java/features"},
		glue={"stepdefinitions"})
public class TestRunner extends AbstractTestNGCucumberTests{

}
