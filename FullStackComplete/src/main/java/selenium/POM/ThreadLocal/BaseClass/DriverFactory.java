package selenium.POM.ThreadLocal.BaseClass;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.testng.AbstractTestNGCucumberTests;

public class DriverFactory extends AbstractTestNGCucumberTests {

	private static DriverFactory instance=null;
	
	/*
	 * private DriverFactory() {
	 * 
	 * }
	 */

	/*
	 * public static DriverFactory getinstance() { if(instance==null) { instance=new
	 * DriverFactory(); return instance; } else { return instance; } }
	 */
	
	
	public static ThreadLocal<WebDriver> dr = new ThreadLocal<WebDriver>();
	public static ThreadLocal<WebDriverWait> wt= new ThreadLocal<WebDriverWait>();
	public static ThreadLocal<JavascriptExecutor> jse=new ThreadLocal<JavascriptExecutor>();
	
	public void setDriver(WebDriver driver) {
		dr.set(driver);
	}
	public void setWait(WebDriverWait wait) {
		wt.set(wait);
	}
	public void setJSExecutor(JavascriptExecutor js) {
		jse.set(js);
	}
	
	public WebDriver getDriver() {
		return dr.get();
	}
	public WebDriverWait getWait() {
		return wt.get();
	}
	public JavascriptExecutor getJSExecutor() {
		return jse.get();
	}
	public void closeThread() {
		dr.remove();
		wt.remove();
		jse.remove();
	}
	

}
