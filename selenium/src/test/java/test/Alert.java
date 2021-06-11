package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import utility.MainClass;

public class Alert {

	public static void main(String[] args) throws InterruptedException {
		MainClass main=new MainClass();
		WebDriver driver= main.launchBrowser();
		Thread.sleep(3000);
		
		
		 WebElement nothanks =driver.findElement(By.linkText("No, thanks!"));
	     nothanks.click();
	     Thread.sleep(2000);
	     
		
		WebElement alerts=driver.findElement(By.xpath("//*[@id='navbar-brand-centered']/ul[2]/li[2]/a"));
		alerts.click();
		Thread.sleep(2000);
		
		WebElement jalerts=driver.findElement(By.xpath("//*[@id='navbar-brand-centered']/ul[2]/li[2]/ul/li[5]/a"));
		jalerts.click();
		Thread.sleep(2000);
		
		WebElement clicks=driver.findElement(By.xpath("//*[@id='easycont']/div/div[2]/div[2]/div[2]/button"));
		clicks.click();
		Thread.sleep(3000);
		org.openqa.selenium.Alert obj = driver.switchTo().alert();
		obj.accept();
		

		driver.close();
	}

}
