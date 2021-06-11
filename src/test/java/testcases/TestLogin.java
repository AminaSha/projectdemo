package testcases;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import pages.Login;
import utility.Utility;

import org.testng.annotations.BeforeTest;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;

public class TestLogin {
	WebDriver driver;
	Utility utilobj;
	String url="http://buffalocart.com/demo/erp/login";
	String browser="chrome";
	String error="username or password information doesn't exist!";
	@BeforeTest
	  public void beforeTest() {
		
		utilobj=new Utility();
		driver=utilobj.launchBrowser(url, browser);
		
		
		
	  }
	
  @Test(priority=3)
  public void validUserPswd() {
	  
	  Login loginobj=new Login(driver);
	  utilobj.enterUsername(loginobj.username,"admin");
	  utilobj.enterPassword(loginobj.password,"123456");
	  utilobj.click1(loginobj.siginbutton);
	  
	  
  }
  @Test(priority=1)
  public void invaildUsernameValidPswd() throws IOException {
	  
	  Login loginobj=new Login(driver);
	  utilobj.enterUsername(loginobj.username,"adrtfu");
	  utilobj.enterPassword(loginobj.password,"123456");
	  utilobj.click1(loginobj.siginbutton);
	  
	  String actualerror=loginobj.invalid.getText();
	  SoftAssert objassert=new SoftAssert();
	  objassert.assertEquals(actualerror, error);
	  objassert.assertAll();
	  utilobj.takeScreenshot();
	  
	  
	  
  }
  @Test(priority=2)
  public void validUserInvalidPswd() throws IOException {
	  
	  Login loginobj=new Login(driver);
	  utilobj.enterUsername(loginobj.username,"admin");
	  utilobj.enterPassword(loginobj.password,"11126");
	  utilobj.click1(loginobj.siginbutton);
	  
	  String actualerror=loginobj.invalid.getText();
	  SoftAssert objassert=new SoftAssert();
	  objassert.assertEquals(actualerror, error);
	  objassert.assertAll();
	  utilobj.takeScreenshot();
	  
  }

  @AfterTest
  public void afterTest() {
	  
	  driver.close();
  }
}
