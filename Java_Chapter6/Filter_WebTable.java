package Java_Chapter14;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Filter_WebTable {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "/Users/gagana/Downloads/chromedriver_mac_arm64 2/chromedriver");

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		
		driver.findElement(By.xpath("//input[@id='search-field']")).sendKeys("Almond");
		List<WebElement> Veggies = driver.findElements(By.xpath("//td[1]"));
		//From Above code >> will get one result 
		
		List<WebElement> ListedItems = Veggies.stream().filter(s -> s.getText().contains("Almond")).collect(Collectors.toList());
		//From Above code >> will get one result 
		
		
		Assert.assertEquals(Veggies.size(), ListedItems.size());
		
		driver.quit();
	}

}
