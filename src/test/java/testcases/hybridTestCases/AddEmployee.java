package testcases.hybridTestCases;

import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class AddEmployee {
	@Test
	public void generateReport() {
		ExtentReports report = new ExtentReports(System.getProperty("user.dir") + 
				"/Reports/Selenium.html");

		ExtentTest logger = report.startTest("Creating employee", 
				"This test will add emp in porfolio");

		logger.log(LogStatus.INFO, "Broswer started");

		logger.log(LogStatus.INFO, "App started");

		logger.log(LogStatus.INFO, "User name entered");

		logger.log(LogStatus.INFO, "Password entered");

		logger.log(LogStatus.PASS, "User created successfully");

		report.endTest(logger);
		
		report.flush();

	}

}
