import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
public class DynamicAndAutosuggestiveDropdown {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver","D:\\Study\\Testing\\MR\\Selenium\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();	
		
		driver.get("https://www.google.in/"); // Launch Google URL
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//textarea[@title=\"Search\"]")).sendKeys("Selenium");
		Thread.sleep(6000);
		List<WebElement> clickoption = driver.findElements(By.xpath("//li[@data-view-type=\"1\"]"));
		List<WebElement> textoption = driver.findElements(By.xpath("//li[@data-view-type=\"1\"]/div/div[2]/div[1]/div[1]/span"));
		
		int count = clickoption.size();
		for (int i=0 ; i<count ; i++) {
			
			String optionvalue = textoption.get(i).getText();
			System.out.println(optionvalue);
			if (optionvalue.equalsIgnoreCase("Selenium webdriver"))
			{
				System.out.println("Desired value found in iteration");			
				clickoption.get(i).click();
				break;
			} 
			else 
			{
				System.out.println("Desired value not found in current iteration");
			}
		}	
		Thread.sleep(3000);
		driver.quit();
	 }
}

/* Setting up the WebDriver:
The code sets the system property "webdriver.chrome.driver" to the path of the ChromeDriver executable.
It initializes a new instance of the ChromeDriver, which launches the Chrome browser.

Navigating to the website:
The driver navigates to the "https://www.google.in/" URL.
The window is maximized to ensure the full view of the web page.

Entering the search term:
The code locates the search input field on the Google page using XPath and sends the "Selenium" text to it.
A pause of 6 seconds is added using Thread.sleep() to allow time for the autosuggestive dropdown to appear.

Handling the autosuggestive dropdown:
The code finds all the elements in the dropdown using the XPath "//li[@data-view-type="1"]".
It also finds the corresponding text elements within each dropdown option using the XPath "//li[@data-view-type="1"]/div/div[2]/div[1]/div[1]/span".
The code retrieves the count of dropdown options using clickoption.size().
It then iterates over each option and checks if the option value (text) matches the desired value ("Selenium dev").
If a match is found, it prints a message and clicks on the option using clickoption.get(i).click().
If a match is not found in the current iteration, it prints a different message.

Quitting the browser:
A pause of 3 seconds is added using Thread.sleep() before quitting the browser using driver.quit(). */
