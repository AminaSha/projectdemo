package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class TaskPage {
	public WebDriver driver;

	public TaskPage( WebDriver driver) {
		
		this.driver=driver;
		
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(how=How.XPATH, using="//A[@title='Tasks']")
	public WebElement task;
	@FindBy(how=How.XPATH, using="/html/body/div[1]/section/div/div[2]/div/div[4]/div/div[2]/ul/li[2]/a")
	public WebElement newtask;
	@FindBy(how=How.NAME, using="task_name")
	public WebElement taskname;
	@FindBy(how=How.ID, using="check_related")
	public WebElement related;
	@FindBy(how=How.NAME, using="due_date")
	public WebElement duedate;
	@FindBy(how=How.XPATH, using="//*[@id='assign_task']/div/div/form/div[15]/button")
	public WebElement tasksave;
	
	
}
