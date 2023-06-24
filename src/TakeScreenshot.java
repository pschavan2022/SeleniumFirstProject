import java.io.File;
import java.io.IOException;
import java.time.Duration;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TakeScreenshot {

	public static void main(String[] args) throws IOException {
		
		System.setProperty("webdriver.chrome.driver","D:\\Study\\Testing\\MR\\Selenium\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();	
		
		driver.get("https://www.google.com/"); 
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		String pagetitle = driver.getTitle();
		System.out.println(pagetitle);
		pagetitle = pagetitle.replaceAll(".", "");
		
		File screenShotSource=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		File screenshotFile = new File("D:\\Study\\Testing\\MR\\Selenium\\Screenshot\\"+pagetitle+".png");
		FileUtils.copyFile(screenShotSource, screenshotFile);
		driver.quit();
	}
	
}
