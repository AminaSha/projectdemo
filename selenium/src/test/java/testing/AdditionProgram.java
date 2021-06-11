package testing;

import org.testng.annotations.Test;
import com.google.common.io.Files;

import poi.ReadExcel;
import utility.MainClass;

import org.testng.annotations.BeforeTest;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class AdditionProgram {
	WebDriver driver;
	MainClass cls;
	ReadExcel objreadexcel=new ReadExcel();
	
	By nothanks = By.linkText("No, thanks!");
	By inputform = By.className("dropdown-toggle");
	By simpleformdemo = By.xpath("//*[@id='navbar-brand-centered']/ul[1]/li[1]/ul/li[1]/a");
	By entermessage = By.id("user-message");
	By showmessage = By.xpath("//*[@id='get-input']/button");
	By messagefromapp = By.id("display");

	By entervalue = By.id("sum1");
	By entervalue2 = By.id("sum2");
	By gettotal = By.xpath("//*[@id='gettotal']/button");
	By total = By.id("displayvalue");

	@Test(priority = 1)
	public void urlVerification() {

		String temp = driver.getCurrentUrl();
	    /*if (temp.contains("https://www.seleniumeasy.com/test/")) {
			System.out.println("pass");
		} else {
			System.out.println("fail");
		}*/
		//soft assert
		/*SoftAssert objassert =new SoftAssert();
		objassert.assertEquals(temp,"https://www.seleniumeasy.com/test/","url verified");
		objassert.assertAll();
*/
	   Assert.assertEquals(temp,"https://www.seleniumeasy.com/test/");
	   
	   //explicit wait
	 //  WebDriverWait wait=new WebDriverWait(driver,30);
	  // wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'COMPOSE')]")));
		
	}

	@Test(priority = 2)
	public void titleVerification() {

		String title = "Selenium Easy - Best Demo website to practice Selenium Webdriver Online";
		String titlefromapp = driver.getTitle();
		if (titlefromapp.contains(title)) {
			System.out.println("pass title");
		} else {
			System.out.println("fail title");
		}

	}

	@Test(priority = 4)
	public void textVerification() throws InterruptedException, IOException {

		cls.click(nothanks);
		Thread.sleep(2000);

	//	String value = "amina";
		String value=objreadexcel.readExcelFun(1,1,"student Details");

		cls.click(inputform);
		Thread.sleep(2000);

		cls.click(simpleformdemo);
		Thread.sleep(2000);

		cls.sendKey(entermessage, value);

		cls.click(showmessage);

		String valuefromapp = cls.getText(messagefromapp);

		if (valuefromapp.contains(value)) {
			System.out.println("value pass");
		} else {
			System.out.println("value fail");
		}
		Thread.sleep(3000);

	}

	@Test(priority = 5)
	public void additionVerification() throws InterruptedException {

		String num1 = "5";
		String num2 = "10";
		// WebElement entervalue =driver.findElement(By.id("sum1"));
		// entervalue.sendKeys(num1);
		cls.sendKey(entervalue, num1);
		Thread.sleep(3000);

		// WebElement entervalue2 =driver.findElement(By.id("sum2"));
		// entervalue2.sendKeys(num2);
		cls.sendKey(entervalue2, num2);
		Thread.sleep(3000);

		// WebElement
		// gettotal=driver.findElement(By.xpath("//*[@id='gettotal']/button"));
		// gettotal.click();
		cls.click(gettotal);
		Thread.sleep(3000);
		// WebElement total=driver.findElement(By.id("displayvalue"));
		String totalvalue = cls.getText(total);

		int number1 = Integer.parseInt(num1);
		int number2 = Integer.parseInt(num2);
		int addnum = number1 + number2;
		String addtotal = String.valueOf(addnum);

		if (totalvalue.contains(addtotal)) {
			System.out.println("total pass");
		} else {
			System.out.println("total fail");
		}
		Thread.sleep(2000);

	}

	@Test(priority = 3)
	
	  public void testFun() throws IOException {
	 
	  TakesScreenshot scrShot =((TakesScreenshot)driver); File
	  SrcFile=scrShot.getScreenshotAs(OutputType.FILE); File DestFile=new
	  File("C:\\EXTRA\\ElementScreenshot.jpg"); Files.copy(SrcFile,DestFile);
	  
	 }
	 
	 
	@BeforeTest
	public void beforeTest() throws InterruptedException {

		cls = new MainClass();
		driver = cls.launchBrowser();
		Thread.sleep(3000);
	}

	@AfterTest
	public void afterTest() {

		driver.close();
	}

}
