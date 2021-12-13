package selenium.utility;

import org.apache.poi.util.SystemOutLogger;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyser implements IRetryAnalyzer {

	
	int maxCount=1;
	int counter=0;
	
	@Override
	public boolean retry(ITestResult result) {
		System.out.println(result.getName());
		System.out.println(result.isSuccess()+"Counter is : "+counter+" Max Count is : "+maxCount);
		if((!result.isSuccess()) && counter<maxCount) {
			System.out.println("Retry Invoked true...");
			counter++;
			return true;
		}
		else {
			System.out.println("Retry Invoked false...");	
			return false;
		}
	}

}
