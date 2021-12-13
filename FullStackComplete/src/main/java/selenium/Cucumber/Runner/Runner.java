package selenium.Cucumber.Runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "..\\FullStackAutomationPgm\\src\\main\\java\\selenium\\Cucumber\\features",
				glue = "selenium\\Cucumber\\stepDefinition")
public class Runner extends AbstractTestNGCucumberTests {

}
