package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class BugPage {
	public WebDriver driver;

	public BugPage(WebDriver driver) {

		this.driver = driver;

		PageFactory.initElements(driver, this);
	}

	@FindBy(how = How.XPATH, using = "/html/body/div[1]/aside[1]/div/nav/ul[2]/li[7]/a/span")
	public WebElement bug;
	@FindBy(how = How.XPATH, using = "/html/body/div[1]/section/div/div[2]/div/div[3]/div/div[2]/ul/li[2]/a")
	public WebElement newbug;
	@FindBy(how = How.NAME, using = "issue_no")
	public WebElement issue;
	@FindBy(how = How.NAME, using = "bug_title")
	public WebElement bug_title;

	@FindBy(how = How.ID, using = "check_related")
	public WebElement related;
	@FindBy(how = How.XPATH, using = "//*[@id=\"assign_task\"]/div/div/form/div[13]/button")
	public WebElement savebug;

}
