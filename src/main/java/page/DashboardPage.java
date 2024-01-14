package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class DashboardPage extends BasePageCommonMethods {
	WebDriver driver;
	
	public DashboardPage(WebDriver driver){
		this.driver = driver;
	}
	
	@FindBy(how=How.XPATH,using="//strong[contains(text(),'Dashboard')]") WebElement dashBoardHeaderText;
	@FindBy(how=How.CSS, using="a[href$='#customers']") WebElement customerMenuElement;
	@FindBy(how=How.CSS,using="a[title='Add Customer']") WebElement addCustomerMenuElement;
	
	
	public void dashboardValidationText(String expectedText) {
		validateElement(dashBoardHeaderText.getText(),expectedText,"Dashboard page is not available");
	}
	
	public void clickOnCustomerMenuButton() {
		customerMenuElement.click();
	}
	
	public void clickOnAddCustomerMenuButton() {
		addCustomerMenuElement.click();
	}
}
