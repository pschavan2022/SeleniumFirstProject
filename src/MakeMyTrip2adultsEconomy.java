import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MakeMyTrip2adultsEconomy {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "D:\\Study\\Testing\\MR\\Selenium\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        
        driver.get("http://www.makemytrip.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		WebDriverWait exp_wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		
		try
		{
		 WebElement popupframe=exp_wait.until(ExpectedConditions.
				 visibilityOf(driver.findElement
						 (By.xpath("//iframe[contains(@title,\"notification-frame\")]"))));
		 driver.switchTo().frame(popupframe);
		 System.out.println("PopUp Found Hence Closing it proceed");
		 WebElement popupclose=exp_wait.until(ExpectedConditions.
				 elementToBeClickable(driver.findElement(By.xpath("//a[@class=\"close\"]"))));
		 popupclose.click();
		 driver.switchTo().parentFrame();
		}
		catch(NoSuchElementException e)
		{
		 System.out.println("PopUp Not Found");
		}
        // From Input
        WebElement fromTab = driver.findElement(By.xpath("//span[text()=\"From\"]"));
        fromTab.click();
        System.out.println("Clicked on From tab");

        WebElement fromInput = driver.findElement(By.xpath("//input[@placeholder=\"From\"]"));
        fromInput.click();
        Thread.sleep(2000);
        fromInput.sendKeys("Mumbai");
        Thread.sleep(2000);
        fromInput.sendKeys(Keys.ARROW_DOWN);
        Thread.sleep(2000);
        fromInput.sendKeys(Keys.ENTER);
        Thread.sleep(2000);

        // To Input
        WebElement toTab = driver.findElement(By.xpath("//span[text()=\"To\"]"));
        toTab.click();
        System.out.println("Clicked on To tab");

        WebElement toInput = driver.findElement(By.xpath("//input[@placeholder=\"To\"]"));
        toInput.click();
        Thread.sleep(2000);
        toInput.sendKeys("New Delhi");
        Thread.sleep(2000);
        toInput.sendKeys(Keys.ARROW_DOWN);
        Thread.sleep(2000);
        toInput.sendKeys(Keys.ENTER);
        Thread.sleep(2000);
        
        //Date picker for departure 
        WebElement dateBox = driver.findElement(By.xpath("//span[text()='Departure']"));
        dateBox.click();
        driver.findElement(By.xpath("//div[@aria-label=\"Sat Jun 24 2023\"]/div/p[text()=24]")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//span[text()=\"Travellers & Class\"]")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//div[@class=\"appendBottom20\"]/ul/li[text()=2]")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//button[text()=\"APPLY\"]")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//a[text()=\"Search\"] ")).click();
        // Close the browser
        //driver.quit();
    }
}
