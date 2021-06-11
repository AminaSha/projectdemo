package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class OpportunitiesPage {
	
	public WebDriver driver;
	public OpportunitiesPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	@FindBy(how=How.XPATH,using="/html/body/div[1]/aside[1]/div/nav/ul[2]/li[8]/a/span")
	public WebElement opportu;
	@FindBy(how=How.XPATH,using="/html/body/div[1]/section/div/div[2]/div/div/ul/li[2]/a")
	public WebElement newoppor;
	@FindBy(how=How.NAME,using="opportunity_name")
	public WebElement opponame;
	@FindBy(how=How.XPATH,using="//*[@id=\"form\"]/div/div[9]/button")
	public WebElement save;
	
	
}
