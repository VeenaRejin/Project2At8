package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utility.ElementUtility;
import utility.WaitUtility;

public class EstimatePage {
	WebDriver driver;
	WaitUtility waitutil;
	ElementUtility elementutil;
	
	
	
	@FindBy(xpath="//span[text()='Estimates']")
	WebElement estimate;
	
	@FindBy(xpath="//span[text()='Estimate List']")
	WebElement estimatelist;
	
	@FindBy(xpath="//a[@title='Add estimate']")
	WebElement addestimate;

	@FindBy(xpath="//input[@placeholder='Estimate date']")
	WebElement estimatedate;
	
	@FindBy(xpath="//input[@placeholder='Valid until']")
	WebElement validuntil;
	
	


	
	@FindBy(id="s2id_estimate_client_id")
	private WebElement clientDropdown;
	
	@FindBy(xpath="//input[@id='s2id_autogen9_search']")
	private WebElement clientSearch;
	
	@FindBy(xpath="//ul[@class='select2-results']//li[1]//div//span")
	private WebElement clientOption;
	
	@FindBy(xpath="//button[@type='submit']")
	private WebElement button_submit;
	
	@FindBy(xpath="//button[@type='button']")
	private WebElement button_close;
	
	
	
	



public EstimatePage(WebDriver driver)
{
	this.driver=driver;
	waitutil=new WaitUtility(driver);
	elementutil=new ElementUtility(driver);
	PageFactory.initElements(driver,this );
	//initiaze webelements declared using @FindBY
	
}


public void doEstimate(String dateestimate,String datevalid,String SearchClient)
{
	waitutil.WaitClickable(estimate);
	estimate.click();
	waitutil.WaitClickable(estimatelist);
	estimatelist.click();
	waitutil.WaitClickable(addestimate);
	addestimate.click();
	
	elementutil.estimatedate(estimatedate,dateestimate);
	elementutil.estimatedate(validuntil,datevalid);
	waitutil.WaitClickable(clientDropdown);
	clientDropdown.click();
	 waitutil.WaitVisibility(clientSearch);
	clientSearch.sendKeys(SearchClient);
	clientOption.click();
	button_submit.click();
	button_close.click();
	estimate.click();
	
	
	

	

	
}
}
