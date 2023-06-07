import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
public class XpathYahooExample {
	
			public static void main(String[] args) throws InterruptedException {
					System.setProperty("webdriver.chrome.driver", "D:\\Study\\Testing\\MR\\Selenium\\chromedriver_win32\\chromedriver.exe");
					WebDriver driver = new ChromeDriver();
					driver.manage().window().maximize();

					driver.get("https://login.yahoo.com/account/create");
					driver.findElement(By.xpath("//input[@id='usernamereg-firstName']")).sendKeys("Pranay"); // Will send values to First Name tab
					driver.findElement(By.xpath("//input[@id='usernamereg-lastName']")).sendKeys("Chavan"); // Will send values to Last Name tab
					driver.findElement(By.xpath("//input[@name='userId']")).sendKeys("pranaychavan1992");
					driver.findElement(By.xpath("//input[@id='usernamereg-password']")).sendKeys("psc123456789");
					WebElement monthDropdown = driver.findElement(By.xpath("//select[@id='usernamereg-month']"));
			  
			        Select monthSelect = new Select(monthDropdown); // Create a Select object
			        monthSelect.selectByVisibleText("December"); // Select the desired option by visible text (e.g., "December")
					driver.findElement(By.xpath("//input[@id='usernamereg-day']")).sendKeys("22");
					driver.findElement(By.xpath("//input[@id='usernamereg-year']")).sendKeys("1992");
					Thread.sleep(3000);
					// Find the "Continue" button by its locator (e.g., CSS selector, XPath, etc.)
			        WebElement continueButton = driver.findElement(By.xpath("//button[@id=\"reg-submit-button\"]"));			        
			        continueButton.click(); // Click the "Continue" button		       
			        driver.quit(); // Close the browser
					
					
			}
			
}