package Java_Chapter14;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class WebTable_Sorting {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "/Users/gagana/Downloads/chromedriver_mac_arm64 2/chromedriver");

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		
		// Click on the column
		
		driver.findElement(By.xpath("//tr/th[1]")).click();
		
		// capture all webelement into list
		List<WebElement> elements = driver.findElements(By.xpath("//td[1]"));
		
		//capture text all webelements into a new (Original)list 
		List<String> Originallist = elements.stream().map(s->s.getText()).collect(Collectors.toList());
		
		// sort for the list in step 3>> sorted list
		List<String> SortedList= Originallist.stream().sorted().collect(Collectors.toList());
		
		//assert
		Assert.assertTrue(Originallist.equals(SortedList));
		
		driver.quit();
		

	}

}
