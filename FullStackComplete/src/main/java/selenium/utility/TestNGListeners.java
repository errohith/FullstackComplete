package selenium.utility;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestNGListener;
import org.testng.ITestResult;

public class TestNGListeners implements ITestListener {
	
	@Override
	public void onTestStart(ITestResult result) {

		System.out.println("-----------------------------------------");
		System.out.println("|"+result.getName() + " - Test Started..."+"|");
		System.out.println("-----------------------------------------");
	}
	
	@Override
	public void onTestSuccess(ITestResult result) {

		System.out.println("-----------------------------------------");
		System.out.println("|"+result.getName() + " - Test Success..."+"|");
		System.out.println("-----------------------------------------");
	}
	
	@Override
	public void onTestFailure(ITestResult result) {

		System.out.println("-----------------------------------------");
		System.out.println("|"+result.getName() + " - Test Failed..."+"|");
		System.out.println("-----------------------------------------");
	}
	
	@Override
	public void onTestFailedWithTimeout(ITestResult result) {

		System.out.println("----------------------------------------------------");
		System.out.println("|"+result.getName() + " - Test Failed due to TimeOut..."+"|");
		System.out.println("----------------------------------------------------");
	}
	
	@Override
	public void onTestSkipped(ITestResult result) {
		System.out.println("-----------------------------------------");
		System.out.println("|"+result.getName() + " - Test Skipped..."+"|");
		System.out.println("-----------------------------------------");
	}
	
	@Override
	public void onStart(ITestContext context) {

	}
	
	@Override
	public void onFinish(ITestContext context) {
		
	}
	

}
