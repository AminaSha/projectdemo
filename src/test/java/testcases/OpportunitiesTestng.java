package testcases;

import org.testng.annotations.Test;

import pages.Login;
import pages.OpportunitiesPage;
import utility.Utility;

import org.testng.annotations.BeforeTest;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;

public class OpportunitiesTestng {
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
	public void opportunitiesopen() throws InterruptedException {
		OpportunitiesPage oppoobj = new OpportunitiesPage(driver);
		objutil.click1(oppoobj.opportu);
		objutil.click1(oppoobj.newoppor);
		Thread.sleep(3000);
	}

	@Test(priority = 3)
	public void newOpportunities() throws InterruptedException {
		OpportunitiesPage oppoobj = new OpportunitiesPage(driver);
		objutil.sendKey1(oppoobj.opponame, "Q.A");
        objutil.click1(oppoobj.save);
		Thread.sleep(3000);
	}

	
	@AfterTest
	public void afterTest() {
		driver.close();
	}

}
