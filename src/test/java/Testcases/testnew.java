package Testcases;

import org.openqa.selenium.Alert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class testnew extends Baseclass{
	
public static SoftAssert softassert = new SoftAssert();
	
	@Test (priority=1,dataProvider="getdata")
	public  static void AddnewCustomer(String Firstname , String Lastname , String postcode)
	{
		click("Bank_manager_login_button_xpath");
		click("Add_customer_button_xpath");
		type("First_name_field_Xpath",Firstname);
		type("Last_name_field_Xpath",Lastname);
		type("Post_Code_field_Xpath",postcode);
	//	Assert.fail();
		click("Add_Customer_submit_xpath");
		Alert alert =driver.switchTo().alert();
		
		softassert.assertTrue(alert.getText().startsWith("Customer added successfully"));
		alert.accept();
		//softassert.assertTrue(false);
		//softassert.assertAll();
		//assert.assertFalse(alert.getText().startsWith("Customer added successfully"));
		softassert.assertAll();
	}
	@DataProvider()
	public static Object[][] getdata(){
		String sheetName = "testdata";
		int rowNum = excel.getRowCount(sheetName);
		int colNum = excel.getColumnCount(sheetName);
         Object[][] data = new Object[rowNum-1][colNum];
		
		System.out.println("Total rows are : "+rowNum+"  total cols are : "+colNum);
		
            for(int rows=2; rows<=rowNum; rows++) {
			
			for(int cols=0; cols<colNum; cols++) {
				
		     data[rows-2][cols] = excel.getCellData(sheetName, cols, rows);
				
			}
			
		}
	
		
		return data;
		
		
	}
	@Test(priority=2,dataProvider="getvalue")
	public static void searchcustomer(String value)
	{
		click("Customer_button_xpath");
	//	List <WebElement> list = driver.findElements(By.xpath(OR.getProperty("Default_table_row")));
		//int size=list.size();
	//	System.out.println("Original size is"+size);
		type("Search_bar_xpath",value);
		softassert.assertTrue(IsElementPresent("Delete_button_xpath"));
		/*List <WebElement> list1 = driver.findElements(By.xpath(OR.getProperty("Default_table_row")));
		int newsize=list1.size();
		System.out.println(newsize);
		Boolean bool;
		if(newsize>size){
			bool=true;
			System.out.println("in if statement size is"+size+"and new size is"+newsize);
		}
		else 
		{
			bool=false;
			System.out.println("in else statement size is"+size+"and new size is"+newsize);
		}
		System.out.println(list1.get(1).getText());
		softassert.assertTrue(bool);*/
		softassert.assertAll();
	}
	@DataProvider()
	public static Object[][] getvalue(){
		String sheetName = "testvalue";
		int rowNum = excel.getRowCount(sheetName);
		int colNum = excel.getColumnCount(sheetName);
         Object[][] data = new Object[rowNum-1][colNum];
		
		System.out.println("Total rows are : "+rowNum+"  total cols are : "+colNum);
		
            for(int rows=2; rows<=rowNum; rows++) {
			
			for(int cols=0; cols<colNum; cols++) {
				
		     data[rows-2][cols] = excel.getCellData(sheetName, cols, rows);
				
			}
			
		}
	
		
		return data;
		
		
	}
}
