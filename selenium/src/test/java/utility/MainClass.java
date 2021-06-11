package utility;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import com.google.common.io.Files;

public class MainClass {
	WebDriver driver;

	public WebDriver launchBrowser() {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "C:\\AMINA\\selenium\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.seleniumeasy.com/test/");
		//implicit wait
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	
		driver.manage().window().maximize();
		return driver;
	}

	public WebDriver launchBrowser(String url, String browser) {

		switch (browser) {
        
		case "chrome":

			System.setProperty("webdriver.chrome.driver","C:\\AMINA\\selenium\\chromedriver_win32\\chromedriver.exe");
			driver = new ChromeDriver();
			driver.get(url);
			driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
			driver.manage().window().maximize();
			break;

		case "edge":
			System.setProperty("webdriver.edge.driver", "C:\\AMINA\\selenium\\edgedriver_win64\\msedgedriver.exe");
			driver = new EdgeDriver();
			driver.get(url);
			driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
			driver.manage().window().maximize();
			break;
			
		case "firefox":
			System.setProperty("webdriver.firefox.driver", "C:\\AMINA\\selenium\\geckodriver-v0.29.1-win64\\firefoxdriver.exe");
			driver = new FirefoxDriver();
			driver.get(url);
			driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
			driver.manage().window().maximize();
			break;

		}

		return driver;
	}

	  
	 
	 
	public void click(By value) {
		driver.findElement(value).click();
	}

	public void sendKey(By value, String message) {
		driver.findElement(value).sendKeys(message);
	}

	public String getText(By value) {
		String text = driver.findElement(value).getText();
		return text;
	}

	public void alertAccept() {
		org.openqa.selenium.Alert obj = driver.switchTo().alert();

		obj.accept();

	}

	public void alertDismiss() {
		
		org.openqa.selenium.Alert objalert = driver.switchTo().alert();
		objalert.dismiss();

	}

	public void alertConfirmAccept() {
		
		org.openqa.selenium.Alert objalert = driver.switchTo().alert();
		objalert.accept();

	}

	public void alertPromptAccept(String message) {
		org.openqa.selenium.Alert objpro = driver.switchTo().alert();
		objpro.sendKeys(message);
		objpro.accept();
	}

	public void selectByValue(By value, String key) {
		Select obj = new Select(driver.findElement(value));
		obj.selectByValue(key);
	}

	public void selectByIndex(By value, int index) {
		Select obj = new Select(driver.findElement(value));
		obj.selectByIndex(index);
	}

	public void selectByVisibleText(By value, String text) {
		Select obj = new Select(driver.findElement(value));
		obj.selectByVisibleText(text);

	}

	public boolean isMultiple(By value) {
		boolean flg = false;
		Select obj = new Select(driver.findElement(value));
		if (obj.isMultiple()) {
			flg = true;
			return flg;
		}
		return flg;
	}

	public void takeScreenshot() throws IOException {

		String directory = "C:\\EXTRA\\SCR";
		String filename = "ElementScreenshot";
		String savename = filename + ".jpg";
		int num = 1;

		TakesScreenshot scrShot = ((TakesScreenshot) driver);
		File SrcFile = scrShot.getScreenshotAs(OutputType.FILE);

		File DestFile = new File(directory, savename);
		while (DestFile.exists()) {
			savename = filename + (num++) + ".jpg";
			DestFile = new File(directory, savename);
		}

		Files.copy(SrcFile, DestFile);

	}

	public void iframeEnter(By value) throws InterruptedException {
		driver.switchTo().frame(driver.findElement(value));
		Thread.sleep(2000);
	}

	public void iframeExit() {
		driver.switchTo().parentFrame();
		// driver.switchTo().defaultContent();
	}

}
