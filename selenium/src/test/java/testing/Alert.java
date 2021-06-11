package testing;

import org.testng.annotations.Test;

import utility.MainClass;

import org.testng.annotations.BeforeTest;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;

public class Alert {

	WebDriver driver;
	MainClass obj1;

	By nothanks = By.linkText("No, thanks!");
	By alerts = By.xpath("//*[@id='navbar-brand-centered']/ul[2]/li[2]/a");
	By jalerts = By.xpath("//*[@id='navbar-brand-centered']/ul[2]/li[2]/ul/li[5]/a");
	By clicks = By.xpath("//*[@id='easycont']/div/div[2]/div[2]/div[2]/button");

	By clickemealert = By.xpath("//*[@id='easycont']/div/div[2]/div[1]/div[2]/button");
	By clickmeconfirm = By.xpath("//*[@id='easycont']/div/div[2]/div[2]/div[2]/button");
	By clickmeprompt = By.xpath("//*[@id='easycont']/div/div[2]/div[3]/div[2]/button");

	@Test(priority = 1)
	public void alertVerification() throws InterruptedException, IOException {

		obj1.click(nothanks);
		Thread.sleep(2000);

		obj1.click(alerts);
		Thread.sleep(2000);

		obj1.click(jalerts);
		Thread.sleep(2000);

		Thread.sleep(3000);
		obj1.click(clicks);
		// org.openqa.selenium.Alert obj = driver.switchTo().alert();
		// obj.accept();
		obj1.alertAccept();
		Thread.sleep(3000);
		obj1.takeScreenshot();
	}

	@Test(priority = 2)
	public void alertConfirmverification() throws InterruptedException, IOException {
		obj1.click(clickmeconfirm);
		obj1.alertConfirmAccept();
		obj1.takeScreenshot();
		Thread.sleep(3000);
	}

	@Test(priority = 3)
	public void alertPromptverification() throws InterruptedException, IOException {
		obj1.click(clickmeprompt);
		obj1.alertPromptAccept("hello");
		obj1.takeScreenshot();
		Thread.sleep(3000);
	}

	@BeforeTest
	public void beforeTest() throws InterruptedException {
		obj1 = new MainClass();
		driver = obj1.launchBrowser();
		Thread.sleep(3000);
	}

	@AfterTest
	public void afterTest() {
		driver.close();

	}

}
