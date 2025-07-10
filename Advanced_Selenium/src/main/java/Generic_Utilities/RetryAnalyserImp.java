package Generic_Utilities;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyserImp implements IRetryAnalyzer{
	///this gets triggers only if a test is failed
int count =0;
int retryLimit=3;
	@Override
	public boolean retry(ITestResult result) {
	if(count<retryLimit) {
		count++;
		return true;
	}
		return false;
	}

}
