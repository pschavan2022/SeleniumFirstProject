import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CurrentDate_Calendar {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver","D:\\Study\\Testing\\MR\\Selenium\\chromedriver_win32\\chromedriver.exe");
		 
		WebDriver driver = new ChromeDriver();	
		
		driver.get("https://www.goibibo.com/");
		driver.manage().window().maximize();
		// Handle Login Pop-up - If login popup comes than close it or if it doesn't come than proceed further
		boolean popupvisible = driver.findElement(By.xpath("//h3[text()=\"Login/Signup\"]")).isDisplayed();
		
		if (popupvisible == true) {
			
			driver.findElement(By.xpath("//span[@class=\"logSprite icClose\"]")).click();
			Thread.sleep(3000);
		}
		// Handle goibibo scanner Pop-up
		boolean popupvisible2 = driver.findElement(By.xpath("//div[@class=\"sc-jlwm9r-6 gJRYxx\"]")).isDisplayed();
		
		if (popupvisible2 == true) {
			
			driver.findElement(By.xpath("//p[@class=\"sc-jlwm9r-1 dRQhOp\"]")).click();
		
		}
		driver.findElement(By.xpath("//span[@class=\"sc-12foipm-21 lerOcM fswDownArrow\"]")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//div[contains(@class,\"DayPicker-Day--today\")]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//span[@class=\"fswTrvl__done\"]")).click();
		Thread.sleep(3000);
		driver.quit();
	}
}

/* Setting up the WebDriver:
The code sets the system property "webdriver.chrome.driver" to the path of the ChromeDriver executable.
It initializes a new instance of the ChromeDriver, which launches the Chrome browser.

Navigating to the website:
The driver navigates to the "https://www.goibibo.com/" URL.
The window is maximized to ensure the full view of the web page.

Handling login pop-up:
The code checks if the login/signup pop-up is displayed by locating the "Login/Signup" heading element.
If the pop-up is visible, it clicks the close button to dismiss it.
A pause of 3 seconds is added using Thread.sleep() to allow time for the pop-up to close.

Handling Goibibo scanner pop-up:
The code checks if the Goibibo scanner pop-up is displayed by locating a specific div element.
If the pop-up is visible, it clicks the element to dismiss it.

Selecting the current date:
The code clicks on a dropdown element that displays the calendar.
A pause of 5 seconds is added using Thread.sleep() to allow time for the calendar to open.
It locates and clicks on the element representing the current date on the calendar.
Another pause of 3 seconds is added to allow time for the date selection to take effect.

Completing the selection and quitting the browser:
The code locates and clicks the element representing the "Done" button to complete the date selection.
A pause of 3 seconds is added before quitting the browser using driver.quit(). */


