package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
	
	WebDriver driver;
	
	By username_input = By.xpath("//input[@id='user_email']");
	By password_input = By.xpath("//input[@id='user_password']");
	By login_btn = By.xpath("//input[@value='Log In']");
	
	/*-----------------------------------------------------------------------------------------*/
	
		public LoginPage(WebDriver driver) {
			this.driver= driver;
		}
	
		public WebElement getUserName() {
			return driver.findElement(username_input);
		}
		
		public WebElement getPassword() {
			return driver.findElement(password_input);
		}
		
		public WebElement getLoginBtn() {
			return driver.findElement(login_btn);
		}

}
