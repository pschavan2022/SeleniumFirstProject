import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class InstantiateEdgeBrowser {	

	public static void main(String[] args) {
		// Set the system property so that Edge driver is located

		System.setProperty("webdriver.edge.driver","D:\\Study\\Testing\\MR\\Selenium\\edgedriver_win64\\msedgedriver.exe");
		
		// Create the object of browser interface 
		WebDriver driver = new EdgeDriver();	
		
		// Launch URL
		driver.get("https://www.google.in/");
		driver.manage().window().maximize();
		
	}

}
