import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BrokenLinks_WindowHandles {
	
	public static void main(String[] args) throws IOException {
		// Set the system property so that Chrome driver is located
		System.setProperty("webdriver.chrome.driver","D:\\Study\\Testing\\MR\\Selenium\\chromedriver_win32\\chromedriver.exe");

		// Create the object of browser interface
		WebDriver driver = new ChromeDriver();

		// Launch URL
		driver.get("https://www.toolsqa.com/");
		driver.manage().window().maximize();
		WebDriverWait exp_wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		Actions act = new Actions(driver);

		JavascriptExecutor js = (JavascriptExecutor) driver;
		// Scroll to the bottom of the screen
		WebElement ScrollTarget = driver.findElement(By.xpath("//div[contains(text(),\"All rights reserved\")]"));
		js.executeScript("arguments[0].scrollIntoView();", ScrollTarget);

		// Fetch the Hyperlinks
		List<WebElement> hyperlinks = exp_wait.until(ExpectedConditions.visibilityOfAllElements
				(driver.findElements(By.xpath("//div[text()=\"Recent Tutorials\"]/../ul/li/a"))));
		int count = hyperlinks.size();
		// Open all hyperlinks in a new window
		for (int i = 0; i < count; i++) {
			act.moveToElement(hyperlinks.get(i)).keyDown(Keys.CONTROL).click().build().perform();
		}
		// Verify if hyperlinks are open correctly
		Set<String> windows = driver.getWindowHandles();
		Iterator<String> windowsIterator = windows.iterator();
		String mainWindow = windowsIterator.next();

		while (windowsIterator.hasNext()) {
			String windowHandle = windowsIterator.next();
			driver.switchTo().window(windowHandle);
			String windowTitle = driver.getTitle().replaceAll("[^a-zA-Z0-9]", " ");
			System.out.println(windowTitle);
			File screenShotSource = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			File screenshotFile = new File("D:\\Study\\Testing\\MR\\Selenium\\BrokenlinksScreenshots\\" + windowTitle + ".png");
			FileUtils.copyFile(screenShotSource, screenshotFile);
			driver.close();
		}
		
		// Switch back to the main window
		driver.switchTo().window(mainWindow);

		// Close the browser
		driver.quit();
	}
}
