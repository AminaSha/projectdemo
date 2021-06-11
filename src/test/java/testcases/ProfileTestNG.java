package testcases;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import pages.Login;
import pages.ProfilePage;
import poi.Readexcel;
import utility.Utility;

import org.testng.annotations.BeforeTest;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;

public class ProfileTestNG {

	WebDriver driver;
	Utility utilobj1;
	Readexcel objreadexcel=new Readexcel();
	String url = "http://buffalocart.com/demo/erp/login";
	String browser = "chrome";

	@BeforeTest
	public void beforeTest() {
		utilobj1 = new Utility();
		driver = utilobj1.launchBrowser(url, browser);
		Login loginobj = new Login(driver);
		utilobj1.enterUsername(loginobj.username, "admin");
		utilobj1.enterPassword(loginobj.password, "123456");
		utilobj1.click1(loginobj.siginbutton);
		
	}

	
	@Test(priority = 1)
	public void projectclick() throws InterruptedException {

		ProfilePage profile = new ProfilePage(driver);
		utilobj1.click1(profile.project);
		Thread.sleep(4000);
		String actualurlpage="http://buffalocart.com/demo/erp/admin/projects";
		String expectedurlpage=driver.getCurrentUrl();
		SoftAssert objassert=new SoftAssert();
		objassert.assertEquals(expectedurlpage,actualurlpage);
		objassert.assertAll();
		System.out.println("page url verified");
	}
	

	@Test(priority = 2)
	public void addNameInNewProject() throws InterruptedException, IOException {
		ProfilePage profile = new ProfilePage(driver);
		utilobj1.click1(profile.newproject);
		Thread.sleep(4000);
		String value=objreadexcel.readExcelFun(1,1,"Sheet1");
		utilobj1.sendKey1(profile.projectname,value);
		Thread.sleep(4000);

	}
	@Test(priority = 3)
	public void projectNamefieldpresent() {
		ProfilePage profile = new ProfilePage(driver);
		boolean project=profile.projectname.isEnabled();
		if(project==true)
		{
			System.out.println("Projectname field is present");
		}
		else
		{
			System.out.println("Projectname field is  not present");
		}	
	}

	@Test(priority = 4)
	public void selectClientSelected() throws InterruptedException {
		ProfilePage profile = new ProfilePage(driver);
		utilobj1.click1(profile.selectClint);
		Thread.sleep(4000);
		utilobj1.selectByIndex1(profile.select, 2);
		boolean client=profile.select.isEnabled();
		if(client==true)
		{
			System.out.println("client field is selected");
		}
		else
		{
			System.out.println("client field is  not selected");
		}	
	}
	@Test(priority = 5)
	public void selectProjectStartDate() throws InterruptedException {
		ProfilePage profile = new ProfilePage(driver);

		utilobj1.sendKey1(profile.startdate, "2020-1-4");
		Thread.sleep(4000);

	}

	@Test(priority = 6)
	public void selectProjectendtDate() throws InterruptedException, IOException {
		ProfilePage profile = new ProfilePage(driver);
		utilobj1.sendKey1(profile.enddate, "2020-1-8");
		Thread.sleep(4000);
		
	}

	@Test(priority = 7)
	public void checkRadioButton() throws InterruptedException {
		ProfilePage profile = new ProfilePage(driver);

		utilobj1.click1(profile.custom);
		Thread.sleep(4000);
		utilobj1.click1(profile.admin);
		Thread.sleep(4000);

	}

	@Test(priority = 8)
	public void ProjectSave() throws InterruptedException {
		ProfilePage profile = new ProfilePage(driver);
		utilobj1.click1(profile.save);
		Thread.sleep(4000);
	}

	@AfterTest
	public void afterTest() {
		driver.close();
	}

}
