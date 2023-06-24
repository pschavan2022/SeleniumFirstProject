import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumWaits {

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "D:\\Study\\Testing\\MR\\Selenium\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.google.co.in/");
        driver.manage().window().maximize();
        
        // Implicit Wait
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        
        // Create the object of Explicit Wait and define the maximum timeout
        WebDriverWait exp_wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        
        WebElement searchBox = driver.findElement(By.xpath("//textarea[@title=\"Search\"]"));
        // searchBox.sendKeys("Automation");
        exp_wait.until(ExpectedConditions.visibilityOf(searchBox)).sendKeys("Selenium");
        
        List<WebElement> option_click = driver.findElements(By.xpath("(//ul[@role=\"listbox\"])[1]/li"));
        List<WebElement> option_text = driver.findElements(By.xpath("(//ul[@role=\"listbox\"])[1]/li/div/div[2]/div[1]/div[1]/span"));
        
        int countofoption = exp_wait.until(ExpectedConditions.visibilityOfAllElements(option_text)).size();
        
        for (int i = 0; i < countofoption; i++) {
            String optionvalue = option_text.get(i).getText();
            if (optionvalue.equalsIgnoreCase("Selenium Webdriver")) {
                exp_wait.until(ExpectedConditions.visibilityOf(option_click.get(i))).click();
                System.out.println("Desired option found in current iteration " + i + ".");
                break;
            } else {
                System.out.println("Desired option not found in current iteration " + i + ", Hence retrying");
            }
        }
        
        driver.quit();
    }
}

