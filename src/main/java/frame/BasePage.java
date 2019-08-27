package frame;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
	public static WebDriver driver;

	public BasePage() {
		System.setProperty("webdriver.chrome.driver", "D:\\Chromedriver\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://automationpractice.com/index.php");
	}
	public void setText(WebElement element, String name) {
	if(name!=null) {
		element.click();
		element.clear();
		element.sendKeys(name);
	}
	}
	public String getTxtAttribute(WebElement element) {
		return element.getAttribute("value");
	}
	public String selectFromDropDown(WebElement element, String option) {
		Select obj=new Select(element);
		obj.selectByValue(option);
		return obj.getFirstSelectedOption().getText();
	}
	public boolean isElementVisible(WebElement element) {
		try {
			WebDriverWait wait=new WebDriverWait(driver, 60);
			wait.until(ExpectedConditions.visibilityOf(element));
			return true;
		}
		catch(Exception e) {
			return false;
		}
	}
	public String getTitle() {
		return driver.getTitle();
	}
	public void quitDriver() {
		driver.quit();
	}

}
