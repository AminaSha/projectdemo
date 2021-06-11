package test;

import org.openqa.selenium.WebDriver;
import utility.MainClass;

public class TitleUrl {

	public static void main(String[] args) throws InterruptedException {
		   
			 MainClass  util1=new  MainClass ();
			    WebDriver driver= util1.launchBrowser();
			String temp=driver.getCurrentUrl();
			if(temp.contains("https://www.seleniumeasy.com/test/"))
			{
				System.out.println("pass");
			}
			else
			{
				System.out.println("fail");
			}
			String title="Selenium Easy - Best Demo website to practice Selenium Webdriver Online";
			String titlefromapp=driver.getTitle();
			if(titlefromapp.contains(title))
			{
				System.out.println("pass title");
			}
			else
			{
				System.out.println("fail title");
			}
			Thread.sleep(2000);
			driver.close();
			
		}


	}


