package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class ProjectSearch {
	public WebDriver driver;

	public ProjectSearch( WebDriver driver) {
		
		this.driver=driver;
		
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(how=How.XPATH, using="/html/body/div[1]/section/div/div[2]/div/div[3]/div/div[2]/div/div[1]/div/div/div[3]/label/input")
	public WebElement search;
	@FindBy(how=How.XPATH, using="//*[@id='table_0']/td[1]/div/label/span")
	public WebElement choice;
	@FindBy(how=How.XPATH, using="//*[@id='table_0']/td[2]/a")
	public WebElement projectname;
	@FindBy(how=How.XPATH, using="//*[@id='table_0']/td[7]/a[1]/span")
	public WebElement viewproject;
}
