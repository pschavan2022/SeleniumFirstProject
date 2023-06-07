import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;


public class MySeleniumJavaClass2 {
    @Test
    public void testExecution() throws InterruptedException {
        // Set the system property so that Chrome driver is located
        System.setProperty("webdriver.chrome.driver", "D:\\Study\\Testing\\MR\\Selenium\\chromedriver_win32\\chromedriver.exe");

        // Create the object of browser interface
        WebDriver driver = new ChromeDriver();

        // Launch URL & maximize the browser window
        driver.get("https://www.facebook.com/");
        driver.manage().window().maximize();
        driver.findElement(By.id("email")).sendKeys("vijayb123@gmail.com");
        driver.findElement(By.id("pass")).sendKeys("vijay123");
        Thread.sleep(3000);
        // driver.close();
        driver.quit();
    }
}