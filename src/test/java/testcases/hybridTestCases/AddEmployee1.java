package testcases.hybridTestCases;

import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class AddEmployee1 {
	@Test
	public void generateReport() {
		ExtentReports report = new ExtentReports(System.getProperty("user.dir") + 
				"/Reports/Selenium3.html");

		ExtentTest logger = report.startTest("Creating employee", 
				"This test will add emp in porfolio");

		logger.log(LogStatus.INFO, "Broswer started");

		logger.log(LogStatus.INFO, "App started");

		logger.log(LogStatus.INFO, "User name entered");

		logger.log(LogStatus.INFO, "Password entered");

		logger.log(LogStatus.PASS, "User created successfully");

		String img = logger.addScreenCapture("C:\\Users\\Administrator.kiran-VAIO\\Pictures\\"
				+ "2016-06-27 001");

		logger.log(LogStatus.PASS, img);
		
		report.endTest(logger);
		
		
		ExtentTest logger1 =report.startTest("Deleting employee",
				"This test will delete emp details from database");
		
		logger1.log(LogStatus.INFO, "User selected");
		
		logger1.log(LogStatus.FAIL, "User deleted");
		
		report.endTest(logger1);
						
		report.flush();

	}

}
