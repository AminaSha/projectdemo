package iframe;

import org.testng.annotations.Test;

import utility.MainClass;

import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;

public class TestIframe {
	
	WebDriver driver;
	MainClass mc;
	
	String url="https://www.w3schools.com/html/html_iframe.asp";
    String browser="edge";
    
    By iframeenter=By.xpath("//*[@id='main']/div[3]/iframe");
    By iframecssmenuclick=By.xpath("//*[@id='topnav']/div/div/a[4]");
    
    By parentcssmenuclick=By.xpath("//*[@id='topnav']/div/div/a[4]");
    		
 @BeforeTest
	  public void beforeTest() throws InterruptedException {
	  
	  mc=new MainClass();
	  driver=mc.launchBrowser(url,browser);
	  Thread.sleep(3000);
	 
	  }
  @Test
  public void iframeVerification() throws InterruptedException {
	  
	  //get into iframe
		//WebElement iframeelement=driver.findElement(iframeenter);
	    //driver.switchTo().frame(iframeelement);
		mc.iframeEnter(iframeenter);
	    Thread.sleep(2000);
	    
	    // click css menu in iframe
	    mc.click(iframecssmenuclick);
	    Thread.sleep(2000);
	    
	    //exit from current from and switch to parent frame
	     //driver.switchTo().parentFrame();
	    //driver.switchTo().defaultContent();
	    mc.iframeExit();
	    
	    //click css menu in parent frame
	    mc.click(parentcssmenuclick);
	    Thread.sleep(2000);
  }
  

  @AfterTest
  public void afterTest() {
	  
	  driver.close();
  }

}
