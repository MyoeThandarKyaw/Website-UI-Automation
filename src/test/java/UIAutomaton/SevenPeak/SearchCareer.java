package UIAutomaton.SevenPeak;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;

public class SearchCareer {
	WebDriver driver;
	public static final String URL = "https://sevenpeakssoftware.com/";
	public static final String searchPosition = "Product Owner";
	WebDriverWait wait = null;
	JavascriptExecutor js;

	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.chrome.driver", "resources\\chromedriver.exe");

		// Instantiate a ChromeDriver class.
		ChromeOptions options = new ChromeOptions();

		options.addArguments("--remote-allow-origins=*");

		driver = new ChromeDriver(options);
		// Maximize the browser
		driver.manage().window().maximize();

	//	wait = new WebDriverWait(driver, 5);
		js= (JavascriptExecutor) driver;
	}

	@BeforeMethod
	public void beforeMethod() {
		driver.get(URL);
	}

	@Test
	public void searchCareer() throws InterruptedException {
		Thread.sleep(4000);
		WebElement careerButton = driver.findElement(By.linkText("Career"));
		careerButton.click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[@href='https://sevenpeakssoftware.com/career/']")).click();
		
		WebElement searchBox = driver
				.findElement(By.xpath("//input[@placeholder='Search']"));
		js.executeScript("arguments[0].scrollIntoView();", searchBox);
		searchBox.sendKeys(searchPosition);
		searchBox.sendKeys(Keys.ENTER);
	}

	@AfterMethod
	public void afterMethod() {
	}

	@AfterClass
	public void afterClass() {
		//driver.quit();
	}

}
