package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utility.MainClass;

public class InputForm {

	public static void main(String[] args) throws InterruptedException {
		 MainClass  util=new  MainClass ();
	    WebDriver driver= util.launchBrowser();
	     Thread.sleep(2000);
	     //test verification
	     WebElement nothanks =driver.findElement(By.linkText("No, thanks!"));
	     nothanks.click();
	     Thread.sleep(2000);
	     
	     String value="amina";
	     
	     WebElement inputform=driver.findElement(By.className("dropdown-toggle"));
	     inputform.click();
	     Thread.sleep(2000);
	     
	     WebElement simpleformdemo = driver.findElement(By.xpath("//*[@id='navbar-brand-centered']/ul[1]/li[1]/ul/li[1]/a"));
	     simpleformdemo.click();
	     Thread.sleep(2000);
	     
	     WebElement entermessage =driver.findElement(By.id("user-message"));
	     entermessage.sendKeys(value);
	     
	     WebElement showmessage = driver.findElement(By.xpath("//*[@id='get-input']/button"));
	     showmessage.click();
	     
	     WebElement messagefromapp= driver.findElement(By.id("display"));
	     String valuefromapp=messagefromapp.getText();
	     
	     if(valuefromapp.contains(value))
	     {
	    	 System.out.println("value pass");
	     }
	     else
	     {
	    	 System.out.println("value fail");
	     }
	    Thread.sleep(3000);
	    
	    
	    //two input form
	    
	    String num1="5";
	    String num2="10";
	    WebElement entervalue =driver.findElement(By.id("sum1"));
	    entervalue.sendKeys(num1);
	    Thread.sleep(3000);
	    
	    WebElement entervalue2 =driver.findElement(By.id("sum2"));
	    entervalue2.sendKeys(num2);
	    Thread.sleep(3000);
	    
	    WebElement gettotal=driver.findElement(By.xpath("//*[@id='gettotal']/button"));
	    gettotal.click();
	    Thread.sleep(3000);
	    WebElement total=driver.findElement(By.id("displayvalue"));
	    String totalvalue=total.getText();
	    
	    int number1 = Integer.parseInt(num1);
	    int number2 = Integer.parseInt(num2);
	    int addnum  = number1+number2;
	    String addtotal=String.valueOf(addnum);
	    
	    if(totalvalue.contains(addtotal))
	    {
	    	System.out.println("total pass");
	    }
	    else
	    {
	    	System.out.println("total fail");
	    }
	   Thread.sleep(2000);
	    driver.close();
	}

}
