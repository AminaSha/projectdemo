package testcases;

import org.testng.annotations.Test;

import pages.BugPage;
import pages.Login;
import utility.Utility;

import org.testng.annotations.BeforeTest;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;

public class BugTestng {

	WebDriver driver;
	Utility utilobj2;
	String url = "http://buffalocart.com/demo/erp/login";
	String browser = "chrome";

	@BeforeTest
	public void beforeTest() {
		utilobj2 = new Utility();
		driver = utilobj2.launchBrowser(url, browser);

	}
	@Test(priority = 1)
	public void validUserPswd()  {

		Login loginobj = new Login(driver);
		utilobj2.enterUsername(loginobj.username, "admin");
		utilobj2.enterPassword(loginobj.password, "123456");
		utilobj2.click1(loginobj.siginbutton);
		

	}

	@Test(priority=2)
	public void bugtab() throws InterruptedException {
		BugPage bugpage=new BugPage(driver);
		utilobj2.click1(bugpage.bug);
		Thread.sleep(3000);
		
	}
	@Test(priority=3)
	public void newbug() throws InterruptedException {
		BugPage bugpage=new BugPage(driver);
		utilobj2.click1(bugpage.newbug);
		Thread.sleep(3000);
		
	}
	@Test(priority=4)
	public void issue() throws InterruptedException {
		BugPage bugpage=new BugPage(driver);
		utilobj2.sendKey1(bugpage.issue,"Text Issue");
		Thread.sleep(3000);
		
	}
	@Test(priority=5)
	public void budTittle() throws InterruptedException {
		BugPage bugpage=new BugPage(driver);
		utilobj2.sendKey1(bugpage.bug_title,"Text not write it");
		Thread.sleep(3000);
		
	}
	@Test(priority=6)
	public void budrelated() throws InterruptedException {
		BugPage bugpage=new BugPage(driver);
		utilobj2.selectByIndex1(bugpage.related,2);
		Thread.sleep(3000);
		
		
	}
	@Test(priority=7)
	public void savebug() throws InterruptedException {
		BugPage bugpage=new BugPage(driver);
		utilobj2.click1(bugpage.savebug);
		Thread.sleep(3000);	
	}

	@AfterTest
	public void afterTest() {
		driver.close();
	}

}
