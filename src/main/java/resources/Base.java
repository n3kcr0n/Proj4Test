package resources;

import java.io.File;
import java.io.FileInputStream;

import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class Base {	
	
	public static WebDriver driver;
	public Properties globalData;
	FileInputStream fileLoc;
	

	public WebDriver initializeDriver() throws IOException {
		globalData = new Properties();
		fileLoc = new FileInputStream("C:\\Users\\ronro\\Project\\src\\main\\java\\Resources\\data.properties");
		globalData.load(fileLoc);
		
		String browserName =  globalData.getProperty("browser");
		
		if (browserName.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver","C:\\Selenium\\chromedriver.exe");
            driver = new ChromeDriver();
		} else if (browserName.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver","C:\\Selenium\\geckodriver.exe");
			driver = new FirefoxDriver();
		}else {
			//MSEDGE driver
		}
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		return driver;
	}
	
	public void getScreenShot(String string) throws IOException {
		File srcShot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(srcShot, new File("./ScreenShot/"+string+"_Screenshot.png"));
	}
}
