package Testcases;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;

import com.google.j2objc.annotations.Property;

public class Sendemail {
	public static Properties OR = new Properties();
	public static FileInputStream fis;


	public static void main(String[] args) throws AddressException, MessagingException, IOException {
		// TODO Auto-generated method stub
	// fis = new FileInputStream("./properties/OR.properties");
	// OR.load(fis);
     MonitoringMail mail = new MonitoringMail();
     mail.sendMail(TestConfig.server, TestConfig.from, TestConfig.to, TestConfig.subject, TestConfig.messageBody, TestConfig.attachmentPath, TestConfig.attachmentName);
	}
	

}
