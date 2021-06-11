package testing;

import org.testng.annotations.Test;

import utility.MainClass;

import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;

public class TableTestng {
	

	WebDriver driver;
	MainClass objtbl;
	By nothanks = By.linkText("No, thanks!");
	By tableentry=By.xpath("// *[@id='navbar-brand-centered']/ul[1]/li[3]/a");
	By tablepage=By.xpath("//*[@id='navbar-brand-centered']/ul[1]/li[3]/ul/li[1]/a");
	

	@AfterTest
	public void afterTest()  {
		
		driver.close();
	}

	@Test(priority=1)
	public void tableEntry() throws InterruptedException {
		objtbl.click(nothanks);
		Thread.sleep(3000);
		objtbl.click(tableentry);
		Thread.sleep(3000);
		
		Actions actions = new Actions(driver);
		WebElement tablepage=driver.findElement(By.xpath("//*[@id='navbar-brand-centered']/ul[1]/li[3]/ul/li[1]/a"));
		actions.moveToElement(tablepage).perform();
		Thread.sleep(4000);
		tablepage.click();
		Thread.sleep(4000);
		String Text = driver.findElement(By.xpath("//*[@id='myTable']/tr[3]/td[5]")).getText(); 
		System.out.println(Text); 
		for(int i=1;i<=5;i++)
			{
			
		String Textall = driver.findElement(By.xpath("//*[@id='myTabl']")).getText(); 
		System.out.println(Textall); 
			}
		
	}
	
	

	@BeforeTest
	public void beforeTest() throws InterruptedException {
		
		objtbl = new MainClass();
		driver=objtbl.launchBrowser();
		Thread.sleep(3000);
		
		
	}

}
