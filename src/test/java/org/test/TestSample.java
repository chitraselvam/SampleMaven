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
		
		

	}



