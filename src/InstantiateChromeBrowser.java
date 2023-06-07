import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class InstantiateChromeBrowser {	
	@Test
	public static void main(String[] args) {
		// Set the system property so that Chrome driver is located

		System.setProperty("webdriver.chrome.driver","D:\\Study\\Testing\\MR\\Selenium\\chromedriver_win32\\chromedriver.exe");
		
		// Create the object of browser interface 
		WebDriver driver = new ChromeDriver();	
		
		// Launch URL
		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();
		
	}

}
