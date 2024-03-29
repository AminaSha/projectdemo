package utility;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import com.google.common.io.Files;

public class Utility {

	
	WebDriver driver;

	public WebDriver launchBrowser() {

		System.setProperty("webdriver.chrome.driver",
				"C:\\AMINA\\selenium\\chromedriver_win32\\chromedriver.exe");
		
		driver = new ChromeDriver();
		
		//implicit wait
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;
		
		// launch browser and redirect it to the Base URL
		driver.get("http://buffalocart.com/demo/erp/login");
		
		
		//Maximizes the browser window
		driver.manage().window().maximize();
		
		return driver;
		
		//order : new chrom() maximze implictwait geturl
	}

	public WebDriver launchBrowser(String url, String browser) {

		switch (browser) {
        
		case "chrome":

			System.setProperty("webdriver.chrome.driver","C:\\AMINA\\selenium\\chromedriver_win32\\chromedriver.exe");
			driver = new ChromeDriver();
			driver.get(url);
			//implicit wait
			driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;
			driver.manage().window().maximize();
			break;

		case "edge":
			System.setProperty("webdriver.edge.driver", "C:\\AMINA\\selenium\\edgedriver_win64\\msedgedriver.exe");
			driver = new EdgeDriver();
			driver.get(url);
			//implicit wait
			driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;
			driver.manage().window().maximize();
			break;

		case "firefox":
			System.setProperty("webdriver.gecko.driver","C:\\AMINA\\selenium\\geckodriver-v0.29.1-win64\\firefoxdriver.exe");
			driver = new FirefoxDriver();
			driver.get(url);
			//implicit wait
			driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;
			driver.manage().window().maximize();
			break;

		}

		return driver;
	}

	
	// for with page factory
	public void click1(WebElement value)
	{
		   value.click();
	}

	
	

	public void selectByValue(WebElement element, String key) {
		Select obj = new Select(element);
		obj.selectByValue(key);

	}

	public void selectByIndex1(WebElement element, int index) {
		Select obj = new Select(element);
		obj.selectByIndex(index);

	}

	public void selectByVisibleText(WebElement element, String text) {
		Select obj = new Select(element);
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

	public void alertAccept() {

		org.openqa.selenium.Alert objalert = driver.switchTo().alert();
		objalert.accept();

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

		org.openqa.selenium.Alert objprompt = driver.switchTo().alert();
		objprompt.sendKeys(message);
		objprompt.accept();

	}

	public void takeScreenshot() throws IOException {
		
		String directory="C:\\EXTRA\\SCR";
		String filename="ElementScreenshot";
		String savename=filename+".jpg";
		int num = 1;
		
		TakesScreenshot scrShot = ((TakesScreenshot) driver);
		File SrcFile = scrShot.getScreenshotAs(OutputType.FILE);

		File DestFile = new File(directory,savename);
		while(DestFile.exists()) 
		{
			 savename=filename+(num++)+".jpg";
			 DestFile = new File(directory,savename);
		}
		
		Files.copy(SrcFile, DestFile);

	}
	
	public void iframeEnter(By value) throws InterruptedException
	{
		 driver.switchTo().frame(driver.findElement(value));
		 Thread.sleep(2000);
	}
	
	public void iframeExit()
	{
		 driver.switchTo().parentFrame();
		 //driver.switchTo().defaultContent();
	}
	public String getText(WebElement element) {
		String text =element.getText();
		return text;
	}
	
	
	//newly created methods for project
	
	public void enterUsername(WebElement element,String username)
	{
	    element.sendKeys(username);
	}
	
	public void enterPassword(WebElement element,String password)
	{
		element.sendKeys(password);
	}
	public void sendKey1(WebElement element,String value)
	{
		element.sendKeys(value);
	}
}
	
