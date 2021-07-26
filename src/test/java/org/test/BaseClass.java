package org.test;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class BaseClass {
	

	
		
		public static WebDriver driver;
		
		public void getDriver(String browserName) 
			{
			try
			{
				if(browserName.equalsIgnoreCase("chrome"))
				{
					System.setProperty("webdriver.chrome.driver", "C:\\Users\\Dell\\eclipse-workspace\\SeleniumFirstDay\\Driver\\chromedriver.exe");
					driver=new ChromeDriver();
					

				}
				else if(browserName.equalsIgnoreCase("firefox"))
				{
					System.setProperty("webdriver.gecko.driver", "C:\\Users\\Dell\\eclipse-workspace\\SeleniumFirstDay\\Driver\\geckodriver.exe");
					driver=new FirefoxDriver();
				}
				else
				{
					System.out.println("Invalid browser");
				}
				driver.manage().window().maximize();

			}
			catch(Exception e)
			{
				System.out.println(e);
			}
			}
		
		public void launchUrl(String url)
		{
			try
			{
				driver.get(url);
			}
			catch(Exception e)
			{
				System.out.println(e);
			}
		}
		
		public void printTitle() 
		{
			try
			{
				String title = driver.getTitle();
				System.out.println(title);
				
			}
			catch (Exception e) {
				System.out.println(e);
			}
		}
		
		public void printCurrentUrl()
		{
			try
			{
				String currentUrl = driver.getCurrentUrl();
				System.out.println(currentUrl);
			}
			catch (Exception e) {
				System.out.println(e);
			}
		}
		
		public void typeText(WebElement element,String data)
		{
			try
			{
				element.sendKeys(data);
			}
			catch(Exception e)
			{
				System.out.println(e);
			}
		}
		
		public void btnClick(WebElement element)
		{
			try
			{
				element.click();
			}
			catch(Exception e)
			{
				System.out.println(e);
			}
		}
		public WebElement findById(String locator,String value)
		{
			WebElement findElement = null;
			try
			{
				if(locator.equalsIgnoreCase("id"))
				{
					findElement = driver.findElement(By.id(value));
				}
				else if(locator.equalsIgnoreCase("xpath"))
				{
				findElement = driver.findElement(By.xpath(value));
				
				}
				else if(locator.equalsIgnoreCase("name"))
				{
				findElement = driver.findElement(By.name(value));
					
				}
			}
			catch(Exception e)
			{
				System.out.println(e);
			}
			return findElement;
		}
		 
		public void moveToElement(WebElement target)
		{
			try {
				Actions act=new Actions(driver);
		act.moveToElement(target).perform();
			}
			catch (Exception e) {
				System.out.println(e);
			}
			
		}
		
		public void dragAndDrop(WebElement src,WebElement dest)
		{
		try
		{
			Actions act=new Actions(driver);
			act.dragAndDrop(src, dest).perform();
		}
		catch (Exception e) {
			System.out.println(e);
		}
		}
		
		public void doubleClick(WebElement element)
		{
			try
			{
				Actions act=new Actions(driver);
				act.doubleClick(element).perform();
			}
			catch (Exception e) {
				System.out.println(e);
			}
		}
		
		public void contextClick(WebElement element)
		{
		try
		{
			Actions act=new Actions(driver);
		 act.contextClick(element).perform();	
		}
		catch (Exception e)
		{
			System.out.println(e);
		}
		}
		
		public void selectByDropDown(String name,WebElement refname,String data)
		{
			try
			{
				Select object=new Select(refname);
				if(name.equalsIgnoreCase("index"))
				{
					object.selectByIndex(Integer.parseInt(data));
				} 
				else if(name.equalsIgnoreCase("value"))
				{
					object.selectByValue(data);
					
				}
				else if(name.equalsIgnoreCase("visibleText"))
				{
					object.selectByVisibleText(data);
					
				}
			}
			catch (Exception e) {
				
			}
		}
		
		public String getDataFromExcel(String pathName, String sheetName,int rowNo,int cellNo)
		{
			String value=null;
			try 
			{
				File file=new File(pathName);
				FileInputStream stream=new FileInputStream(file);
				Workbook workbook=new XSSFWorkbook(stream);
				Sheet sheet = workbook.getSheet(sheetName);
				Row row = sheet.getRow(rowNo);
				Cell cell = row.getCell(cellNo);
				int cellType = cell.getCellType();
				if(cellType==1)
				{
					value = cell.getStringCellValue();
					
				}
				 else if (DateUtil.isCellDateFormatted(cell)) 
				 {
					Date dateCellValue = cell.getDateCellValue();
					SimpleDateFormat dateFormat=new SimpleDateFormat("dd-MM-yyyy");
					 value = dateFormat.format(dateCellValue);
				}
				 else
				 {
					 double numericCellValue = cell.getNumericCellValue();
					 long l=(long)numericCellValue;
					 value=String.valueOf(l);
				 }
				
			} 
			catch (Exception e) 
			{
				System.out.println(e);
			}
			return value;
		}
		
		
		
		public void enterTextByJs(String data,WebElement refName)
		{
			try {
				JavascriptExecutor js=(JavascriptExecutor)driver;
				js.executeScript("arguments[0].setAttribute('value', ' "+data+" ')", refName);
			} 
			catch (Exception e) {
				System.out.println(e);
			}
			
		}
		
		public void writeDataToExcel(String pathName,String sheetName,int rowNo,int cellNo,String OrderId)
		{
					try 
			{
				
				File file=new File(pathName);
				FileInputStream filestream=new FileInputStream(file);
				Workbook book=new XSSFWorkbook(filestream);
				Sheet createSheet = book.getSheet(sheetName);
				Row createRow = createSheet.createRow(rowNo);
				Cell createCell = createRow.createCell(cellNo);
				//String text = refName.getText();
				createCell.setCellValue(OrderId);
				
				FileOutputStream stream=new FileOutputStream(file);
				book.write(stream);
				
			} catch (Exception e) 
			{
				System.out.println(e);
			}
		}
		
		public void getScreenshot(String pagename) throws IOException
		{
			try
			{
				TakesScreenshot tkeScreenshot=(TakesScreenshot)driver;
				File src=tkeScreenshot.getScreenshotAs(OutputType.FILE);
				File desti=new File(pagename+".png");
				FileUtils.copyFile(src, desti);
				
				
		}
			catch (Exception e) 
			{
				System.out.println(e);
			}
		}
		
		public String getValueByAttribute(WebElement refName)
		{
			String attribute=null;
			try {
				 attribute = refName.getAttribute("value");
				System.out.println(attribute);
			
				
			} catch (Exception e) {
				
			}
			return attribute;
			
			
		}
		
		
		
		}




