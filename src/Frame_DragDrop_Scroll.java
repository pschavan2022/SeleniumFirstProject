import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.JavascriptExecutor;

public class Frame_DragDrop_Scroll {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver","D:\\Study\\Testing\\MR\\Selenium\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://jqueryui.com/droppable/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		Actions act = new Actions(driver);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		
		//Switch to a frame
		
		WebElement frame = driver.findElement(By.xpath("//iframe[@class=\"demo-frame\"]"));
		
		driver.switchTo().frame(frame);
		
		WebElement dragelement = driver.findElement(By.xpath("//div[@id=\"draggable\"]"));
		WebElement droptarget = driver.findElement(By.xpath("//div[@id=\"droppable\"]"));
		
		act.dragAndDrop(dragelement, droptarget).build().perform();
			
		//Switch to parent frame
		driver.switchTo().parentFrame();
		
		//Scroll
		WebElement ScrollTarget = driver.findElement(By.xpath("//a[text()=\"Widget Factory\"]"));
		js.executeScript("arguments[0].scrollIntoView();", ScrollTarget);
		ScrollTarget.click();
		
		//driver.quit();
	}

}
