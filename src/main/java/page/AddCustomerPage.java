package page;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class AddCustomerPage extends BasePageCommonMethods {
	WebDriver driver;
	String genratedFullName;
	
	public AddCustomerPage(WebDriver driver){
		this.driver = driver;
	}
	
	//WebElements
	@FindBy(xpath="//strong[contains(text(),'New Customer')]")WebElement newCustomerHeaderElement;
	@FindBy(css="input[name='name']")WebElement fullNameElement;
	@FindBy(css="select[name='company_name']") WebElement companyElement;
	@FindBy(css="input[name='email']") WebElement emailElement;
	@FindBy(css="input[name='phone']") WebElement phoneElement;
	@FindBy(css="input[name='address']") WebElement addressElement;
	@FindBy(css="input[name='city']") WebElement cityElement;
	@FindBy(css="input[name='port']") WebElement zipElement;
	@FindBy(xpath="//p[contains(text(),'less than 5 digits')]") WebElement zipMinElement;
	@FindBy(xpath="//p[contains(text(),'more than 9 digits')]") WebElement zipMaxElement;
	@FindBy(css="select[name='country']") WebElement countryElement;
	@FindBy(css="select[name='customer_group']") WebElement groupElement;
	@FindBy(css="button[id='save_btn']") WebElement saveElement;
	@FindBy(xpath="//tbody/tr") List<WebElement> listOfElement;
	
	public void validateNewCustomerHeaderText(String expected) {
		validateElement(newCustomerHeaderElement.getText(),expected,"Customer Page is not avalable!");
	}
	
	public void insertFullName(String fullName) {
		genratedFullName =fullName+genrateRandomNum(999);
		fullNameElement.sendKeys(genratedFullName);
	}
	
	public void clickOnFullName() {
		fullNameElement.click();
	}
	
	public void selectCompanyFromDropdown(String company) {
		selectDropdown(companyElement,company);
	}
	
	public void insertEmail(String email) {
		String generatedEmail = genrateRandomNum(999)+email;
		emailElement.sendKeys(generatedEmail);
	}
	
	public void insertPhone(String phone) {
		String generatedPhone = phone + genrateRandomNum(999);
		phoneElement.sendKeys(generatedPhone);
	}
	
	public void insertAddress(String address) {
		addressElement.sendKeys(address);
	}
	
	public void insertCity(String city) {
		cityElement.sendKeys(city);
	}
	
	public void zipCode(String zip) {
		zipElement.sendKeys(zip);
	}
	
	public void clearZipCode() {
		zipElement.clear();
	}
	
	public void zipCodeMinValidation(String zipcodeMin, String expZipLessCharText  ) {
		zipCode(zipcodeMin);
		clickOnSaveButton();
		validateElement(zipMinElement.getText(),expZipLessCharText,"Msg don't match");
	}
	
	public void zipCodeMaxValidation(String zipcodeMax, String expZipMoreCharText) {
		clickOnFullName();
		clearZipCode();
		zipCode(zipcodeMax);
		clickOnSaveButton();
		validateElement(zipMaxElement.getText(),expZipMoreCharText,"Msg don't match");
	}
	
	public void selectCountryFromDropDown(String country) {
		selectDropdown(countryElement, country);
	}
	
	public void selectGroup(String group) {
		selectDropdown(groupElement, group);
	}
	
	public void clickOnSaveButton() {
		saveElement.click();
	}
	
	}
