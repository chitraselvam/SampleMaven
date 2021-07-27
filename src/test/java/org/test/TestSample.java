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
		
		@Test
		public void tc3() {
			SearchHotel book=new SearchHotel();
			WebElement txtFirstName = book.getTxtFirstName();
			base.typeText(txtFirstName, base.getDataFromExcel("C:\\Users\\Dell\\eclipse-workspace\\WorkbookTask\\TestData\\AdactinHotel.xlsx", "Sheet1", 22, 1));
			Assert.assertEquals(txtFirstName.getAttribute("value"), "Selvam");
			
			
			WebElement txtLastName = book.getTxtLastName();
			base.typeText(txtLastName, base.getDataFromExcel("C:\\Users\\Dell\\eclipse-workspace\\WorkbookTask\\TestData\\AdactinHotel.xlsx", "Sheet1", 23, 1));
			Assert.assertEquals(txtLastName.getAttribute("value"), "Annamalai");
			
			WebElement txtBillingaddress = book.getTxtBillingaddress();
			base.typeText(txtBillingaddress, base.getDataFromExcel("C:\\Users\\Dell\\eclipse-workspace\\WorkbookTask\\TestData\\AdactinHotel.xlsx", "Sheet1", 24, 1));
			Assert.assertEquals(txtBillingaddress.getAttribute("value"), "No 12 ,Jagadambal street,Tnagar");
			
			WebElement txtCardNumber = book.getTxtCardNumber();
			base.typeText(txtCardNumber, base.getDataFromExcel("C:\\Users\\Dell\\eclipse-workspace\\WorkbookTask\\TestData\\AdactinHotel.xlsx", "Sheet1", 25, 1));
			Assert.assertEquals(txtCardNumber.getAttribute("value"), "1234567890567890");
			
			WebElement txtCardType = book.getTxtCardType();
			base.selectByDropDown("value", txtCardType, base.getDataFromExcel("C:\\Users\\Dell\\eclipse-workspace\\WorkbookTask\\TestData\\AdactinHotel.xlsx", "Sheet1", 26, 1));
			Assert.assertEquals(txtCardType.getAttribute("value"), "MAST");
			
			WebElement drpdwnExpiryMonth = book.getDrpdwnExpiryMonth();
			base.selectByDropDown("value", drpdwnExpiryMonth, base.getDataFromExcel("C:\\Users\\Dell\\eclipse-workspace\\WorkbookTask\\TestData\\AdactinHotel.xlsx", "Sheet1", 27, 1));
			Assert.assertEquals(drpdwnExpiryMonth.getAttribute("value"), "8");
			
			WebElement drpdwnExpiryYear = book.getDrpdwnExpiryYear();
			base.selectByDropDown("value", drpdwnExpiryYear, base.getDataFromExcel("C:\\Users\\Dell\\eclipse-workspace\\WorkbookTask\\TestData\\AdactinHotel.xlsx", "Sheet1", 27, 2));
			Assert.assertEquals(drpdwnExpiryYear.getAttribute("value"), "2022");
			
			WebElement txtCCV = book.getTxtCCV();
			base.typeText(txtCCV, base.getDataFromExcel("C:\\Users\\Dell\\eclipse-workspace\\WorkbookTask\\TestData\\AdactinHotel.xlsx", "Sheet1", 28, 1));
			Assert.assertEquals(txtCCV.getAttribute("value"), "721");
			
			WebElement btnBookNow = book.getBtnBookNow();
			base.btnClick(btnBookNow);

		}

	}



