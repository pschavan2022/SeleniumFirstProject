import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class InstantiateFirefoxBrowser {	

	public static void main(String[] args) {
		// Set the system property so that Firefox driver is located

		System.setProperty("webdriver.firefox.driver","D:\\Study\\Testing\\MR\\Selenium\\geckodriver-v0.33.0-win32\\geckodriver.exe");
		
		// Create the object of browser interface 
		WebDriver driver = new FirefoxDriver();	
		
		// Launch URL
		driver.get("https://www.yahoo.in/");
		driver.manage().window().maximize();
		
	}

}
