package testcases;

import org.testng.annotations.Test;

import pages.Login;
import pages.SignoutPage;
import utility.Utility;

import org.testng.annotations.BeforeTest;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;

public class SignOutTestng {
	WebDriver driver;
	Utility objutil;
	String url = "http://buffalocart.com/demo/erp/login";
	String browser = "chrome";

	@BeforeTest
	public void beforeTest() {
		objutil = new Utility();
		driver = objutil.launchBrowser(url, browser);
	}

	@Test(priority = 1)
	public void validUserPswd() throws InterruptedException {

		Login loginobj = new Login(driver);
		objutil.enterUsername(loginobj.username, "admin");
		objutil.enterPassword(loginobj.password, "123456");
		objutil.click1(loginobj.siginbutton);
		Thread.sleep(4000);

	}

	@Test(priority = 2)
	public void SignOut() throws InterruptedException {
		SignoutPage snout=new SignoutPage(driver);
		objutil.click1(snout.demo);
		objutil.click1(snout.logout);
		Thread.sleep(4000);
		
	}
	@AfterTest
	public void afterTest()
	{
		driver.quit();
	}
	

}
