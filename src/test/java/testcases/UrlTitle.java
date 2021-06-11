package testcases;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import utility.Utility;

import org.testng.annotations.BeforeTest;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;

public class UrlTitle {
	WebDriver driver;
	Utility utilobj2;
	String url="http://buffalocart.com/demo/erp/login";
	String title="Welcome to Codecarrots";
	String browser="chrome";
	@BeforeTest
	  public void beforeTest() {
		
		utilobj2=new Utility();
		driver=utilobj2.launchBrowser(url, browser);
		
	  }
  @Test(priority=1)
  public void urlVerification() {
	  
	  String expectedUrl=driver.getCurrentUrl();
	  SoftAssert objassert=new SoftAssert();
	  objassert.assertEquals(expectedUrl, url);
	  objassert.assertAll();
	  System.out.println("url verified");
	  
  }
  @Test(priority=2)
  public void titleVerification() {
	  
	  String expectedtitle=driver.getTitle();
	  SoftAssert objassert=new SoftAssert();
	  objassert.assertEquals(expectedtitle, title);
	  objassert.assertAll();
	  System.out.println(" verified");
	  
  }
  

  @AfterTest
  public void afterTest() {
	  driver.close();
  }

}
