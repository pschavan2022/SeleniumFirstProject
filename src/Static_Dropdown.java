import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Static_Dropdown {

	public static void main(String[] args) throws InterruptedException 	{	

	System.setProperty("webdriver.chrome.driver","D:\\Study\\Testing\\MR\\Selenium\\chromedriver_win32\\chromedriver.exe");
	
	// Create the object of webdriver interface 
	WebDriver driver = new ChromeDriver();	
	
	// Launch URL
	driver.get("https://www.amazon.in/");
	driver.manage().window().maximize();
	WebElement dropdown = driver.findElement(By.xpath("//select[@id=\"searchDropdownBox\"]"));
	Select StaticDropdown = new Select(dropdown);
	//StaticDropdown.selectByIndex(11);
	//StaticDropdown.selectByValue("search-alias=apparel");
	StaticDropdown.selectByVisibleText("Electronics");
	/* List<WebElement> dropdownoption=driver.findElements(By.xpath("//select[@id=\"searchDropdownBox\"]/option"));
	int count = dropdownoption.size();
	for(int i=0 ; i<count ; i++) {
		
		StaticDropdown.selectByIndex(i);
		
	   } */
	 Thread.sleep(3000); // Wait for 3 seconds
	 
	}
}

/* Setting up the WebDriver:
The code sets the system property "webdriver.chrome.driver" to the path of the ChromeDriver executable.
It initializes a new instance of the ChromeDriver, which launches the Chrome browser.

Navigating to the website:
The driver navigates to the "https://www.amazon.in/" URL.
The window is maximized to ensure the full view of the web page.

Locating the static dropdown:
The code finds the dropdown element using XPath with the expression "//select[@id="searchDropdownBox"]".
It stores the dropdown element in a WebElement variable called "dropdown".

Selecting an option from the dropdown:
The code creates a new instance of the Select class, passing the "dropdown" WebElement as the argument.
It then uses different methods to select an option from the dropdown:
selectByIndex(11) selects the option at index 11.
selectByValue("search-alias=apparel") selects the option with the specified value.
selectByVisibleText("Electronics") selects the option with the specified visible text.

Locating the dropdown and selecting an option:
The code uses the findElement method to locate the dropdown element using an XPath expression (//select[@id="searchDropdownBox"]).
It creates an instance of the Select class, passing the dropdown element as a parameter, to work with the dropdown options.
The code selects a specific option from the dropdown using selectByIndex method (StaticDropdown.selectByIndex(11)).

Iterating through the dropdown options:
The code finds all the option elements within the dropdown using the findElements method and stores them in a list (dropdownoption).
It retrieves the count of options using the size method.
A loop is used to iterate through each option.
Inside the loop, each option is selected using selectByIndex(i) to choose an option based on its index.

Pausing the execution:
A pause of 3 seconds is added using Thread.sleep() to wait for 3 seconds before the program terminates. */