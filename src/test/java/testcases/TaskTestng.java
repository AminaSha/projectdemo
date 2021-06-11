package testcases;

import org.testng.annotations.Test;

import pages.Login;
import pages.TaskPage;
import utility.Utility;

import org.testng.annotations.BeforeTest;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;

public class TaskTestng {
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
	public void validUserPswd() throws InterruptedException {

		Login loginobj = new Login(driver);
		utilobj2.enterUsername(loginobj.username, "admin");
		utilobj2.enterPassword(loginobj.password, "123456");
		utilobj2.click1(loginobj.siginbutton);
		Thread.sleep(4000);

	}

	@Test(priority = 2)
	public void tasks() {
		TaskPage objtask = new TaskPage(driver);
		utilobj2.click1(objtask.task);
	}

	@Test(priority = 3)
	public void newtasks() throws InterruptedException {
		TaskPage objtask = new TaskPage(driver);
		utilobj2.click1(objtask.newtask);
		Thread.sleep(4000);
	}

	@Test(priority = 4)
	public void taskName() throws InterruptedException {
		TaskPage objtask = new TaskPage(driver);
		utilobj2.sendKey1(objtask.taskname, "proectx");
		Thread.sleep(4000);
	}

	@Test(priority = 5)
	public void relatedTo() throws InterruptedException {
		TaskPage objtask = new TaskPage(driver);
		utilobj2.selectByIndex1(objtask.related, 2);
		Thread.sleep(4000);
	}

	@Test(priority = 6)
	public void dueDatee() throws InterruptedException {
		TaskPage objtask = new TaskPage(driver);
		utilobj2.sendKey1(objtask.duedate, "2021-06-20");
		Thread.sleep(4000);
	}

	@Test(priority = 7)
	public void taskSave() throws InterruptedException {
		TaskPage objtask = new TaskPage(driver);
		utilobj2.click1(objtask.tasksave);
		Thread.sleep(4000);
	}

	@AfterTest
	public void afterTest() {
		driver.close();
	}

}
