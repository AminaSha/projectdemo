package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class Login {

	public WebDriver driver;

	public Login( WebDriver driver) {
		
		this.driver=driver;
		
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(how=How.NAME, using="user_name")
	public WebElement username;
	
	@FindBy(how=How.NAME, using="password")
	public WebElement password;
	
	@FindBy(how=How.XPATH, using="//button[contains(text(),'Sign in')]")
	public WebElement siginbutton;
	
	@FindBy(how=How.XPATH, using="/html/body/div[1]/div/div/div[2]/div")
	public WebElement invalid;
    
}
