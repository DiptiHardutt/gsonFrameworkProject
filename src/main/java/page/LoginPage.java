package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LoginPage extends BasePageCommonMethods{
	WebDriver driver;
	
	public LoginPage(WebDriver driver){
		this.driver=driver;
	}

	@FindBy(how = How.XPATH, using = "//*[@id=\"user_name\"]")
	WebElement userNameElement;
	@FindBy(id="password") WebElement passwordElement;
	@FindBy(id="login_submit") WebElement signinElement;
	
	public void insertUserName(String userName) {
		userNameElement.sendKeys(userName);
	}
	
	public void insertPassword(String password) {
		passwordElement.sendKeys(password);
	}
	
	public void clickOnSigninButton() {
		signinElement.click();
	}
	
	public void validateUserAlertMsg(String expected) {
		String actualUserAlertMsg=driver.switchTo().alert().getText();
		validateElement( actualUserAlertMsg, expected, "Alert msg is not avalible!");
		driver.switchTo().alert().accept();
	}
	
	public void validatePasswordAlertMsg(String expected) {
		String actualPasswordAlertMsg=driver.switchTo().alert().getText();
		validateElement(actualPasswordAlertMsg, expected, "Alert msg is not available!");
		driver.switchTo().alert().accept();
	}
}
