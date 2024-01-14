package test;

import java.io.FileReader;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

import page.DashboardPage;
import page.LoginPage;
import util.BrowserFactory;

public class LoginTest {
	WebDriver driver;
	JsonElement jsonElementObj;
	
	
	@SuppressWarnings("deprecation")
	@BeforeMethod(alwaysRun = true)
	public void readJson() {
		try {
			FileReader fileReader = new FileReader("src\\main\\java\\testData\\TF_TestData.json");
			JsonParser jsonParser = new JsonParser();
			jsonElementObj = jsonParser.parse(fileReader);
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void userShouldBeAbleToLogin() {
		driver = BrowserFactory.init();
		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		loginPage.insertUserName(jsonElementObj.getAsJsonObject().get("LoginInfo").getAsJsonObject().get("UserName").getAsString());
		loginPage.insertPassword(jsonElementObj.getAsJsonObject().get("LoginInfo").getAsJsonObject().get("Password").getAsString());
		loginPage.clickOnSigninButton();
		
		DashboardPage dashboardPage = PageFactory.initElements(driver, DashboardPage.class);
		dashboardPage.dashboardValidationText(jsonElementObj.getAsJsonObject().get("LoginInfo").getAsJsonObject().get("ValidationTextLogin").getAsString());
		BrowserFactory.tearDown();
	}
	
	@Test
	public void validateLoginAlertMsg() {
		driver = BrowserFactory.init();
		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		loginPage.clickOnSigninButton();
		loginPage.validateUserAlertMsg(jsonElementObj.getAsJsonObject().get("LoginInfo").getAsJsonObject().get("alertUserValidationText").getAsString());
		loginPage.insertUserName(jsonElementObj.getAsJsonObject().get("LoginInfo").getAsJsonObject().get("UserName").getAsString());
		loginPage.clickOnSigninButton();
		loginPage.validatePasswordAlertMsg(jsonElementObj.getAsJsonObject().get("LoginInfo").getAsJsonObject().get("alertPasswordValidationText").getAsString());
		loginPage.insertPassword(jsonElementObj.getAsJsonObject().get("LoginInfo").getAsJsonObject().get("Password").getAsString());
		loginPage.clickOnSigninButton();
		BrowserFactory.tearDown();
	}
}
