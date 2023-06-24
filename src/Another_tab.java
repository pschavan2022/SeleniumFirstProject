import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

public class Another_tab {
    public static void main(String[] args) {
        // Set the system property so that Chrome driver is located
        System.setProperty("webdriver.chrome.driver", "D:\\Study\\Testing\\MR\\Selenium\\chromedriver_win32\\chromedriver.exe");

        // Create the object of the browser interface
        WebDriver driver = new ChromeDriver();

        // Launch Amazon URL in the first tab
        driver.get("https://www.google.com/");
        driver.manage().window().maximize();

        // Open a new tab with Google
        driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL + "t");

        // Switch to the newly opened tab
        driver.switchTo().newWindow(WindowType.TAB);

        // Load Google in the new tab
        driver.get("https://www.github.com/");

        // Switch back to the first tab (Amazon)
        driver.switchTo().window(driver.getWindowHandles().toArray()[0].toString());
    }
}
