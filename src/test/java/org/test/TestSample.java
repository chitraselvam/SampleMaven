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
		public void tc1() {
			SearchHotel search=new SearchHotel();
			WebElement drpdwnLocation = search.getDrpdwnLocation();
			base.selectByDropDown("value", drpdwnLocation,base.getDataFromExcel("C:\\Users\\Dell\\eclipse-workspace\\WorkbookTask\\TestData\\AdactinHotel.xlsx", "Sheet1", 12, 1));
			Assert.assertEquals(drpdwnLocation.getAttribute("value"),"London");
			
			WebElement drpdwnHotels = search.getDrpdwnHotels();
			base.selectByDropDown("value", drpdwnHotels, base.getDataFromExcel("C:\\\\Users\\\\Dell\\\\eclipse-workspace\\\\WorkbookTask\\\\TestData\\\\AdactinHotel.xlsx","Sheet1",13,1));
			Assert.assertEquals(drpdwnHotels.getAttribute("value"),"Hotel Sunshine");
			
			WebElement drpdwnRoomType = search.getDrpdwnRoomType();
			base.selectByDropDown("value", drpdwnRoomType, base.getDataFromExcel("C:\\Users\\Dell\\eclipse-workspace\\WorkbookTask\\TestData\\AdactinHotel.xlsx","Sheet1",14,1));
			Assert.assertEquals(drpdwnRoomType.getAttribute("value"), "Super Deluxe");
			
			WebElement drpdwnRoomNos = search.getDrpdwnRoomNos();
			base.selectByDropDown("value", drpdwnRoomNos, base.getDataFromExcel("C:\\\\\\\\Users\\\\\\\\Dell\\\\\\\\eclipse-workspace\\\\\\\\WorkbookTask\\\\\\\\TestData\\\\\\\\AdactinHotel.xlsx", "Sheet1",15,1));
			Assert.assertEquals(drpdwnRoomNos.getAttribute("value"), "1");
			
			WebElement txtCheckIn = search.getTxtCheckIn();
			txtCheckIn.clear();
			base.typeText(txtCheckIn, base.getDataFromExcel("C:\\Users\\Dell\\eclipse-workspace\\WorkbookTask\\TestData\\AdactinHotel.xlsx", "Sheet1", 16, 1));
			Assert.assertEquals(txtCheckIn.getAttribute("value"), "01-07-2021");
			
			
			WebElement txtCheckOut = search.getTxtCheckOut();
			txtCheckOut.clear();
			base.typeText(txtCheckOut, base.getDataFromExcel("C:\\\\Users\\\\Dell\\\\eclipse-workspace\\\\WorkbookTask\\\\TestData\\\\AdactinHotel.xlsx", "Sheet1", 17, 1));
			Assert.assertEquals(txtCheckOut.getAttribute("value"), "14-07-2021");
			
			WebElement drpdwnAdultPerRoom = search.getDrpdwnAdultPerRoom();
			base.selectByDropDown("value", drpdwnAdultPerRoom, base.getDataFromExcel("C:\\\\\\\\Users\\\\\\\\Dell\\\\\\\\eclipse-workspace\\\\\\\\WorkbookTask\\\\\\\\TestData\\\\\\\\AdactinHotel.xlsx", "Sheet1", 18, 1));
			Assert.assertEquals(drpdwnAdultPerRoom.getAttribute("value"), "2");
			
			WebElement drpdwnChildrenPerRoom = search.getDrpdwnChildrenPerRoom();
			base.selectByDropDown("value", drpdwnChildrenPerRoom, base.getDataFromExcel("C:\\Users\\Dell\\eclipse-workspace\\WorkbookTask\\TestData\\AdactinHotel.xlsx", "Sheet1", 19, 1));
			Assert.assertEquals(drpdwnChildrenPerRoom.getAttribute("value"), "1");
			
			WebElement btnSearch = search.getBtnSearch();
			base.btnClick(btnSearch);
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



