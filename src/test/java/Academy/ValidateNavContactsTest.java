package Academy;

import java.io.IOException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import PageObjects.LandingPage;
import resources.Base;

public class ValidateNavContactsTest extends Base {
	
	LandingPage LandingPage; 
	WebDriverWait wait;

	@BeforeTest
	public void initializeD() throws IOException {
		driver = initializeDriver();
		driver.get(globalData.getProperty("url"));
		getRidPopUp();
	}
	
	@Test
	public void validateNavBarContacts() {
		Assert.assertTrue(LandingPage.getContactNav().isDisplayed());
	}
	
	@AfterTest
	public void driverClose() {
		driver.close();
		driver = null;
	}
	
	public void getRidPopUp() {
		this.LandingPage = new LandingPage(driver);
		this.wait = new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.visibilityOf(LandingPage.getPopUp()));
		LandingPage.getPopUpBtn().click();
	}
}
