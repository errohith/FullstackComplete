package selenium.POM.ThreadLocal.CucumberPages;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.github.bonigarcia.wdm.WebDriverManager;
import selenium.POM.ThreadLocal.BaseClass.CucumberBaseClass;

public class Hooks extends CucumberBaseClass {
	
	@Before
	public void preCondition(Scenario sc) {
		System.out.println(sc.getName()+ " is started.");
	}
	@After
	public void postCondition(Scenario sc) {
		System.out.println(sc.getName()+ " : "+ sc.getStatus());
	}
}
