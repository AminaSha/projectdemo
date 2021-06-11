package testing;

import org.testng.annotations.Test;

import com.google.common.io.Files;

import utility.MainClass;

import org.testng.annotations.BeforeTest;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;

 
 
public class DropeDownTestng {
	
	WebDriver driver;
	 MainClass drop;
	 
	 By nothanks = By.linkText("No, thanks!");
	 By inputform = By.className("dropdown-toggle");
	
	 By selectdrop=By.xpath("//*[@id='navbar-brand-centered']/ul[1]/li[1]/ul/li[4]/a");
	 By pleaseselect=By.id("select-demo");
	 By multiselect =By.id("multi-select");
	 By allselect=By.id("printAll");
	 
	 @BeforeTest
	  public void beforeTest() throws InterruptedException {
		  drop=new MainClass();
		  drop.launchBrowser();
		  Thread.sleep(3000);
	 }
  @Test(priority=1,enabled=true)
  public void dropdown() throws InterruptedException {
	  
	  drop.click(nothanks);
	  drop.click(inputform);
	  drop.click(selectdrop);
	  drop.click(pleaseselect);
	  Thread.sleep(3000);
	  drop.selectByValue(pleaseselect,"Sunday");
	  Thread.sleep(3000);
	  drop.selectByIndex(pleaseselect, 4);
	  Thread.sleep(3000);
	  drop.selectByVisibleText(pleaseselect, "Monday");
	  Thread.sleep(3000);
  }
  @Test(priority=2)
  public void dropdownMultiSelectVerification() throws InterruptedException
  {
	  
	  if(drop.isMultiple(multiselect))
	  {
		    drop.selectByValue(multiselect,"California");
		    drop.selectByValue(multiselect,"Florida");
		    Thread.sleep(2000);
		    drop.click(allselect);
		    Thread.sleep(4000);
	  }
	  
  }
  
  @Test(priority=3)
  public void testFun() throws IOException
  {
	  TakesScreenshot scrShot =((TakesScreenshot)driver); 
	  File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
	  File DestFile=new File("C:\\EXTRA\\SCR\\ElementScreenshot.jpg");
		 Files.copy(SrcFile,DestFile);
		 
  }
 

  @AfterTest
  public void afterTest() {
	  
	  driver.close();
  }

}
