import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MakeMyTripDemo {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "D:\\Study\\Testing\\MR\\Selenium\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("http://www.makemytrip.com/");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.xpath("//iframe[starts-with(@title, 'notification-frame')]")));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//i[@class='wewidgeticon we_close']"))).click();
        
        // From Input
        WebElement fromTab = driver.findElement(By.xpath("//span[text()='From']"));
        fromTab.click();
        System.out.println("Clicked on From tab");

        WebElement fromInput = driver.findElement(By.xpath("//input[@placeholder='From']"));
        fromInput.click();
        Thread.sleep(2000);
        fromInput.sendKeys("Mumbai");
        Thread.sleep(2000);
        fromInput.sendKeys(Keys.ARROW_DOWN);
        Thread.sleep(2000);
        fromInput.sendKeys(Keys.ENTER);
        Thread.sleep(2000);

        // To Input
        WebElement toTab = driver.findElement(By.xpath("//span[text()='To']"));
        toTab.click();
        System.out.println("Clicked on To tab");

        WebElement toInput = driver.findElement(By.xpath("//input[@placeholder='To']"));
        toInput.click();
        Thread.sleep(2000);
        toInput.sendKeys("New Delhi");
        Thread.sleep(2000);
        toInput.sendKeys(Keys.ARROW_DOWN);
        Thread.sleep(2000);
        toInput.sendKeys(Keys.ENTER);
        Thread.sleep(2000);
        
        //Date picker for departure & return
        WebElement dateBox = driver.findElement(By.xpath("//span[text()='Departure']"));
        dateBox.click();
        driver.findElement(By.xpath("//div[@aria-label='Wed Jun 21 2023']//p[contains(text(),'21')]")).click();
        WebElement dateBoxReturn = driver.findElement(By.xpath("//label[@for='return']"));
        dateBoxReturn.click();
        driver.findElement(By.xpath("//div[@aria-label='Sat Jun 24 2023']//p[contains(text(),'24')]")).click();
        
        // Close the browser
        //driver.quit();
    }
}
