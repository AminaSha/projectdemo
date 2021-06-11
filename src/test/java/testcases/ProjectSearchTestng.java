package testcases;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import pages.Login;
import pages.ProfilePage;
import pages.ProjectSearch;
import poi.Readexcel;
import utility.Utility;

import org.testng.annotations.BeforeTest;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;

public class ProjectSearchTestng {
	WebDriver driver;
	Utility utilobj1;
	Readexcel objreadexcel=new Readexcel();
	String url = "http://buffalocart.com/demo/erp/login";
	String browser = "chrome";

	@BeforeTest
	public void beforeTest() {
		utilobj1 = new Utility();

		driver = utilobj1.launchBrowser(url, browser);

	}
	@Test(priority = 1)
	public void validUserPswd() throws InterruptedException {

		Login loginobj = new Login(driver);
		utilobj1.enterUsername(loginobj.username, "admin");
		utilobj1.enterPassword(loginobj.password, "123456");
		utilobj1.click1(loginobj.siginbutton);
		Thread.sleep(4000);

	}

	@Test(priority = 2)
	public void projectclick() throws InterruptedException {

		ProfilePage profile = new ProfilePage(driver);
		utilobj1.click1(profile.project);
		Thread.sleep(4000);
	}
	@Test(priority = 3)
	public void projectSearch() throws InterruptedException, IOException {

		ProjectSearch psearch = new ProjectSearch(driver);
		String value="demo1";
		utilobj1.sendKey1(psearch.search,value);
		Thread.sleep(4000);
		utilobj1.click1(psearch.choice);
		Thread.sleep(4000);
	}
	
	@Test(priority = 4)
	public void checkProjectName() throws InterruptedException {

		ProjectSearch psearch = new ProjectSearch(driver);
		String name ="DEMO11";
		String actual_value=utilobj1.getText(psearch.projectname);
		SoftAssert ass=new SoftAssert();
		ass.assertEquals(actual_value,name);
		ass.assertAll();
		System.out.println("project is present");
	}
	
	@Test(priority = 5)
	public void checkProject() throws InterruptedException {

		ProjectSearch psearch = new ProjectSearch(driver);
		utilobj1.click1(psearch.viewproject);
		Thread.sleep(4000);
	}

	@AfterTest
	public void afterTest() {
		driver.close();
	}


}
