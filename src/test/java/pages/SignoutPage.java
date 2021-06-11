package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class SignoutPage {
	public WebDriver driver;
	public SignoutPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	@FindBy(how=How.XPATH,using="/html/body/div[1]/header/nav/div[2]/ul[2]/li[3]/a/span")
	public WebElement demo;
	@FindBy(how=How.XPATH,using="/html/body/div[1]/header/nav/div[2]/ul[2]/li[3]/ul/li[3]/form/div/button")
	public WebElement logout;
	
}
