package page;

import java.util.Random;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class BasePageCommonMethods {
		
	
	public int genrateRandomNum(int intBoundNum) {
		Random random = new Random();
		int genratedNum =random.nextInt(intBoundNum);
		return genratedNum;
	}
	
	public void validateElement(String actual,String expected,String errorMessage) {
		Assert.assertEquals(actual, expected, errorMessage);
	}
	
	public void selectDropdown(WebElement element, String visibleText) {
		Select sel = new Select(element);
		sel.selectByVisibleText(visibleText);
	}
	
}
