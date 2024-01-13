package Java_chapter4;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Calender {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "/Users/gagana/Downloads/chromedriver_mac_arm64 2/chromedriver");

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		driver.get("https://www.path2usa.com/travel-companion/");
		
		//Scroll 
		((JavascriptExecutor)driver).executeScript("scroll(0,900)");
		Thread.sleep(3000);
		
		//Nov 3 : click
		//Step 1 : Get the attribute, put it in a list and iterate 
		driver.findElement(By.xpath("//input[@placeholder='Date of travel']")).click();
		Thread.sleep(2000);
		
		while(! driver.findElement(By.xpath("//div[@class='flatpickr-month']/div[@class='flatpickr-current-month']/span")).getText().contains("July")) {

			driver.findElement(By.xpath("//div[@class='flatpickr-month']/span[2]")).click();
		
		}
		
		driver.findElement(By.xpath("//input[@placeholder='Date of travel']")).click();
		Thread.sleep(3000);
		List<WebElement> date = driver.findElements(By.cssSelector(".flatpickr-day"));
		int count = driver.findElements(By.cssSelector(".flatpickr-day")).size();
		
		//Steps 2 : Iterate 
		for(int i=0;i<count;i++) {
			String text = driver.findElements(By.cssSelector(".flatpickr-day")).get(i).getText();
			
			if (text.equals("6")) {
				driver.findElements(By.cssSelector(".flatpickr-day")).get(i).click();
				Thread.sleep(3000);
				break;
			}
		}
		driver.quit();

	}

}
