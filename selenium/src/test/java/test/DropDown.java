package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import utility.MainClass;

public class DropDown {

	public static void main(String[] args) throws InterruptedException {
		MainClass obj=new MainClass();
		 WebDriver driver= obj.launchBrowser();
		 Thread.sleep(3000);
		 
		 
		 WebElement nothanks =driver.findElement(By.linkText("No, thanks!"));
	     nothanks.click();
	     Thread.sleep(2000);
	     
	     WebElement inputform=driver.findElement(By.className("dropdown-toggle"));
	     inputform.click();
	     Thread.sleep(2000);
	     
	     WebElement selectdropdown=driver.findElement(By.xpath("//*[@id='navbar-brand-centered']/ul[1]/li[1]/ul/li[4]/a"));
	     selectdropdown.click();
	     Thread.sleep(2000);
	     
	     WebElement selectlistdemo=driver.findElement(By.id("select-demo"));
		Select obj1=new Select(selectlistdemo);
	     obj1.isMultiple();
	     obj1.selectByValue("Sunday");
	     Thread.sleep(2000);
		 obj1.selectByIndex(4);
		 Thread.sleep(2000);
		 obj1.selectByVisibleText("Monday");
		 Thread.sleep(2000);
		 
		 WebElement multiselect=driver.findElement(By.id("multi-select"));
		 Select objj =new Select(multiselect);
		 boolean status=objj.isMultiple();
		 objj.selectByIndex(1);
		 Thread.sleep(3000);
		 objj.selectByValue("New Jersey");
		 Thread.sleep(4000);
		 if(status ==true)
		 {
			 System.out.println("multi select");
		 }
		 else
		 {
		   System.out.println("single select"); 
		 }
		 
		 
		 
		 driver.close();

	}

}
