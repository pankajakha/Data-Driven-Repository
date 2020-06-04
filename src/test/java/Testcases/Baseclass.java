package Testcases;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import io.github.bonigarcia.wdm.Config;
import io.github.bonigarcia.wdm.WebDriverManager;



public class Baseclass {
	public static WebDriver driver;
	public static Properties OR = new Properties();
	public static Properties Config = new Properties();
	public static FileInputStream fis;
	public static Logger log = Logger.getLogger(Baseclass.class.getSimpleName());
	public static ExcelReader excel = new ExcelReader("./Runner/testdata.xlsx");
    @BeforeSuite
	public static void Initialize() throws IOException{
    	fis = new FileInputStream("./src/test/resources/OR.properties");
    	OR.load(fis);
    	fis = new FileInputStream("./src/test/resources/Config.properties");
    	Config.load(fis);
    	PropertyConfigurator.configure("./Runner/log4j.properties");
    	if(Config.getProperty("browser").equalsIgnoreCase("chrome"))
    	{
    		WebDriverManager.chromedriver().setup();
    		driver = new ChromeDriver();
    		driver.get(Config.getProperty("testsiteurl"));
    		driver.manage().timeouts().implicitlyWait(Integer.parseInt(Config.getProperty("Implicit_wait")), TimeUnit.SECONDS);
    		driver.manage().window().maximize();
    	}
    }
    	public static void click(String locator)
    	{
    		driver.findElement(By.xpath(OR.getProperty(locator))).click();
    		log.info("Clicking on element identified by "+locator);
    	}
    	
    	
    	public static void type(String locator , String value)
    	{
    		driver.findElement(By.xpath(OR.getProperty(locator))).sendKeys(value);
    		log.info("Typing on element identified by "+locator+" and value "+value);
    	}
    	public static boolean IsElementPresent(String locator)
    	{
    		try{
    		driver.findElement(By.xpath(OR.getProperty(locator)));
    		log.info("Element with "+locator+" is present");
    		return true;
    		}catch(Throwable t)
    		{
    			System.out.println(t.getStackTrace());
    			log.info("Element with "+locator+" is not present");
    			return false;
    		}
    	}
    		public static String Screenshot(String methodname)throws IOException
    		{
    		Date d = new Date();
    		String file=d.toString().replaceAll("  ", "__").replaceAll(":", "_").replaceAll(" ", "_");
    		File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
    		FileUtils.copyFile(screenshotFile, new File("C:\\Users\\pankaj\\workspace\\DataDriven\\screenshot\\"+methodname+"_"+file+".jpg"));
    		return  file;
    		
    		
    		}
    		/*@AfterSuite
    		public static void teardown() throws AddressException, MessagingException, InterruptedException
    		{
    			Thread.sleep(2000);
    			MonitoringMail mail = new MonitoringMail();
    		    mail.sendMail(TestConfig.server, TestConfig.from, TestConfig.to, TestConfig.subject, TestConfig.messageBody, TestConfig.attachmentPath, TestConfig.attachmentName);
    		}*/
  
    	}
		
    	
		
	

