import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FutureDates_Calendar {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver","D:\\Study\\Testing\\MR\\Selenium\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		driver.get("https://www.goibibo.com/"); // Launch Goibibo URL
		driver.manage().window().maximize();
		// Handle Login Pop-up1 
		try {
			driver.findElement(By.xpath("//h3[text()=\"Login/Signup\"]")).isDisplayed();
			driver.findElement(By.xpath("//span[@class=\"logSprite icClose\"]")).click();
			Thread.sleep(3000);
		} catch (NoSuchElementException Popup1) {
			System.out.println("Login/Signup popup is not visible");
		}

		// Handle QR code Pop-up2
		try {
			driver.findElement(By.xpath("//div[@class=\"sc-jlwm9r-6 gJRYxx\"]")).isDisplayed();
			driver.findElement(By.xpath("//p[@class=\"sc-jlwm9r-1 dRQhOp\"]")).click();
			Thread.sleep(3000);
		} catch (NoSuchElementException Popup2) {
			System.out.println("QR code popup is not visible");
		}
		driver.findElement(By.xpath("//span[@class=\"sc-12foipm-21 lerOcM fswDownArrow\"]")).click();
		Thread.sleep(3000);
		List<WebElement> dateClick = driver.findElements(By.xpath("//div[contains(@class,\"DayPicker-Day\") and @aria-disabled=\"false\" and contains(@aria-label,\"Jun\")]"));
		List<WebElement> dateText = driver.findElements(By.xpath("//div[contains(@class,\"DayPicker-Day\") and @aria-disabled=\"false\" and contains(@aria-label,\"Jun\")]/p"));

		int countofdates = dateClick.size();
		for (int i = 0; i < countofdates; i++) {
			String dateTextvalue = dateText.get(i).getText();
			System.out.println(dateTextvalue);
			if (dateTextvalue.equals("25")) 
			{
				System.out.println("Desired date found: " + dateTextvalue);
				dateClick.get(i).click();
				break;
			} 
			else 
			{
				System.out.println("Desired date not found");
			}
		}
		Thread.sleep(3000);
		driver.findElement(By.xpath("//span[@class=\"fswTrvl__done\"]")).click();
		Thread.sleep(3000);
		//driver.quit();
	}
}