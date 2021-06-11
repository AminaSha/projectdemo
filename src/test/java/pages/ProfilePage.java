package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class ProfilePage {
	public WebDriver driver;

	public ProfilePage( WebDriver driver) {
		
		this.driver=driver;
		
		PageFactory.initElements(driver,this);
	}
	
	
	@FindBy(how=How.XPATH, using="/html/body/div[1]/aside[1]/div/nav/ul[2]/li[5]/a/span")
	public WebElement project;
	@FindBy(how=How.XPATH, using="/html/body/div[1]/section/div/div[2]/div/div[3]/div/div[2]/ul/li[2]/a")
	public WebElement newproject;
	
	@FindBy(how=How.XPATH, using="//*[@id='create']//form//div//div[1]//div[2]//div//input")
	public WebElement projectname;
	
	@FindBy(how=How.XPATH, using="//*[@title='Select Client']")
	public WebElement selectClint;
	@FindBy(how=How.XPATH, using="//*[@id=\"create\"]/form/div/div[1]/div[3]/div/div/select")
	public WebElement select;
	 
	@FindBy(how=How.NAME, using="start_date")
	public WebElement startdate;
	@FindBy(how=How.NAME, using="end_date")
	public WebElement enddate;
	
	@FindBy(how=How.XPATH, using="//SPAN[@id='select2-billing_type-6e-container']")
    public WebElement billing;
	@FindBy(how=How.XPATH, using="//*[@id='border-none']/div/div[2]/label")
    public WebElement custom;
	@FindBy(how=How.XPATH, using="//*[@id=\"permission_user_1\"]/div/div[1]/label/strong")
    public WebElement admin;
	
	@FindBy(how=How.XPATH, using="//span[@id='select2-project_status-gp-container']")
     public WebElement status;
	@FindBy(how=How.CLASS_NAME, using="note-editable")
    public WebElement text;
	@FindBy(how=How.XPATH, using="//*[@id=\"create\"]/form/div/div[3]/div[2]/button")
    public WebElement save;
	
	
	
	
}
