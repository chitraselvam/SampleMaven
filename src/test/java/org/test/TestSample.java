package org.test;


import java.io.IOException;
import java.util.Date;


import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebElement;


public class TestSample extends BaseClass{
	
	
		static BaseClass base;
		@BeforeClass
		public static void beforeClass() {
			 base=new BaseClass();
			base.getDriver("chrome");
			base.launchUrl("https://adactinhotelapp.com/index.php");
			

		}
		@Before
		public void beforeMethod() throws IOException {
			base.getScreenshot("LoginPage");
			Date date=new Date();
			System.out.println(date);

		}
		@Test
		public void tc0() {
			AdactLogin locators=new AdactLogin();
			WebElement txtUserName = locators.getTxtUserName();
			base.typeText(txtUserName,base.getDataFromExcel("C:\\Users\\Dell\\eclipse-workspace\\WorkbookTask\\TestData\\AdactinHotel.xlsx", "Sheet1", 3, 1));
			Assert.assertEquals(txtUserName.getAttribute("value"), "selvammalai");
			WebElement txtPassword = locators.getTxtPassword();
			base.typeText(txtPassword, base.getDataFromExcel("C:\\\\Users\\\\Dell\\\\eclipse-workspace\\\\WorkbookTask\\\\TestData\\\\AdactinHotel.xlsx", "Sheet1", 4, 1));
			Assert.assertEquals(txtPassword.getAttribute("value"), "AdactinTest123");
			WebElement btnLogin = locators.getBtnLogin();
			base.btnClick(btnLogin);

		}
		
		

	}



