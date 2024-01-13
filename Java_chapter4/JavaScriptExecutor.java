package Java_chapter4;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class JavaScriptExecutor {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "/Users/gagana/Downloads/chromedriver_mac_arm64 2/chromedriver");

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		//Try this in console to check what pixel you need : window.scrollBy(0,500)
		((JavascriptExecutor)driver).executeScript("scroll(0,500)");
		Thread.sleep(2000);
		//Try this in console to check what pixel you need : document.querySelector(\".tableFixHead\").scrollTop= 5000"
		
		((JavascriptExecutor)driver).executeScript("document.querySelector(\".tableFixHead\").scrollTop= 5000");

		
	}

}
