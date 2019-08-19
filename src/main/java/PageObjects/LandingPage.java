package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage {
	public WebDriver driver;

	By signIn_nav = By.cssSelector("a[href*='sign_in']");
	
	By popUp = By.xpath("//div[@class='sumo-form-wrapper listbuilder-popup']");
	
	By popUp_noThanks_btn = By.xpath("//button[contains(text(),'NO THANKS')]");
	
	By featuresTitle = By.xpath("//h2[contains(text(),'Featured Courses')]");
	
	By contacts_nav = By.xpath("//a[contains(text(),'Contact')]");
	
	/*-----------------------------------------------------------------------------------------*/
	
		public LandingPage(WebDriver driver) {
			this.driver = driver;
		}
	
		public WebElement getSignIn() {
			return driver.findElement(signIn_nav);
		}
	
		public WebElement getPopUp() {
			return driver.findElement(popUp);
		}
		public WebElement getPopUpBtn() {
			return driver.findElement(popUp_noThanks_btn);
		}
		public WebElement getFeatureTitle() {
			return driver.findElement(featuresTitle);
		}
		public WebElement getContactNav() {
			return driver.findElement(contacts_nav);
		}
}
