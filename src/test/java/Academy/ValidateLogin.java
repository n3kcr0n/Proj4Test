package Academy;

import java.io.IOException;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import PageObjects.LandingPage;
import PageObjects.LoginPage;
import resources.Base;

public class ValidateLogin extends Base {

	LandingPage LandingPage;
	WebDriverWait wait;

	@BeforeTest
	public void initializeD() throws IOException {
		driver = initializeDriver();	
	}

	@Test(dataProvider = "getData")
	public void basePageNavigation(String uname, String pass, String user, String url) throws IOException {
		driver.get(globalData.getProperty("url"));
		this.LandingPage = new LandingPage(driver);
		LandingPage.getSignIn().click();
		LoginPage LoginPage = new LoginPage(driver);
		LoginPage.getUserName().clear();
		LoginPage.getUserName().sendKeys(uname);
		LoginPage.getPassword().clear();
		LoginPage.getPassword().sendKeys(pass);
		LoginPage.getLoginBtn().click();
		
	}

	@AfterTest
	public void driverClose() {
		driver.quit();
		driver = null;
	}

	@DataProvider
	public Object[][] getData() {
		Object[][] data = new Object[2][4];

		data[0][0] = "RestrictedUser@gc.co";
		data[0][1] = "1234142";
		data[0][2] = "Restricted User";
		data[0][3] = "http://www.qaclickacademy.com";

		data[1][0] = "Non-RestrictedUser@cs.com";
		data[1][1] = "54321";
		data[1][2] = "Non-Restricted User";
		data[1][3] = "http://www.qaclickacademy.com";

		return data;
	}
}
