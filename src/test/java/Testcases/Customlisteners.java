package Testcases;

import java.io.IOException;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

public class Customlisteners implements ITestListener {
	//public static WebDriver driver;
	

	public void onFinish(ITestContext arg0) {
		// TODO Auto-generated method stub
		
	}

	public void onStart(ITestContext arg0) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		System.setProperty("org.uncommons.reportng.escape-output","false");
		Reporter.log("Test Case : "+result.getMethod().getMethodName()+"---"+result.getThrowable().getMessage());
		String method = result.getMethod().getMethodName();
		//System.out.println(method);
	    String screencaps=null;
		try {
			screencaps= Baseclass.Screenshot(method);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Reporter.log("<a target=\"_blank\" href=\"C:\\Users\\pankaj\\workspace\\DataDriven\\screenshot\\"+method+"_"+screencaps+".jpg\">Screenshot Captured</a>");
		Reporter.log("<br>");
		Reporter.log("<a target=\"_blank\" href=\"C:\\Users\\pankaj\\workspace\\DataDriven\\screenshot\\"+method+"_"+screencaps+".jpg\"><img src=\"C:\\Users\\pankaj\\workspace\\DataDriven\\screenshot\\"+method+"_"+screencaps+".jpg\" height=400 width=400></a>");
		/*MonitoringMail mail = new MonitoringMail();
	    try {
			mail.sendMail(TestConfig.server, TestConfig.from, TestConfig.to, TestConfig.subject, TestConfig.messageBody, "C:\\Users\\pankaj\\workspace\\DataDriven\\screenshot\\"+method+"_"+screencaps+".jpg", method+"_"+screencaps+".jpg");
		} catch (AddressException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		
	}

	public void onTestSkipped(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}

	public void onTestStart(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}

	public void onTestSuccess(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}

}
