package selenium.POM.ThreadLocal.CucumberRunner;

import org.testng.annotations.DataProvider;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import selenium.POM.ThreadLocal.BaseClass.BaseClass;

@CucumberOptions(features = "..\\FullStackAutomationPgm\\src\\main\\java\\selenium\\POM\\ThreadLocal\\FirefoxCucumberFeatures\\S012",
				glue = "selenium\\POM\\ThreadLocal\\CucumberPages",
				tags = "@Functional and not @SIT")
public class RunnerforFirefox extends BaseClass {
	
	@Override
    @DataProvider(parallel = false)
    public Object[][] scenarios() {
        return super.scenarios();
    }
	

}
