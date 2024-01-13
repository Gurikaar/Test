package Java_Chapter15;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.openqa.selenium.support.locators.RelativeLocator.*;

public class RelativeLocators {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
// Step 1 : Import "import static org.openqa.selenium.support.locators.RelativeLocator.*;" Manually
		
		System.setProperty("webdriver.chrome.driver", "/Users/gagana/Downloads/chromedriver_mac_arm64 2/chromedriver");

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://rahulshettyacademy.com/angularpractice/");

		// Task : Capture he label of Name attribute
		// 1. above()

		WebElement NameEditBox = driver.findElement(By.name("name"));

		System.out.println(driver.findElement(with(By.tagName("label")).above(NameEditBox)).getText());

		// 2. below()

		WebElement DOB = driver.findElement(By.xpath("//label[@for='dateofBirth']"));
		driver.findElement(with(By.tagName("input")).below(DOB)).click();

		// As a result it will click on Submit button as it doesn't work on flex html
		// webelement

		// 3. ofLeftOf
		WebElement checkoxtext = driver.findElement(By.className("form-check-label"));

		driver.findElement(with(By.tagName("input")).toLeftOf(checkoxtext)).click();

		// 4 ofRightOf
		WebElement RadioButton = driver.findElement(By.id("inlineRadio1"));
		System.out.println(driver.findElement(with(By.tagName("label")).toRightOf(RadioButton)).getText());

		driver.quit();
	}

}
