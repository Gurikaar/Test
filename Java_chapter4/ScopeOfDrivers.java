package Java_chapter4;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ScopeOfDrivers {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "/Users/gagana/Downloads/chromedriver_mac_arm64 2/chromedriver");

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://qaclickacademy.com/practice.php");
		
		//1. to get the count of a link in a page 
		System.out.println(driver.findElements(By.tagName("a")).size());
		
		//2. get the link in just footer scetion
		//1. find the webelement of that section
		//2. with that webelement get the tag names
		
		WebElement footersection = driver.findElement(By.id("gf-BIG"));
		
		System.out.println(footersection.findElements(By.tagName("a")).size());
		
		//3. get the count of single column in footer section
		
		WebElement Columnfooter = driver.findElement(By.xpath("//div/table/tbody/tr/td[1]/ul"));
		System.out.println(Columnfooter.findElements(By.tagName("a")).size());
		
		//4. click on each link in the column and check if the pages are opening 
		//1st link is not working in the application that why count is starting from 1
		for (int i=1;i<Columnfooter.findElements(By.tagName("a")).size();i++) {
			
			//Below code is to open in a new tab without using navigating function 
			String clicklinkTab =Keys.chord(Keys.COMMAND,Keys.ENTER);
			
			Columnfooter.findElements(By.tagName("a")).get(i).sendKeys(clicklinkTab);
			Thread.sleep(5000);
		}
		//Navigate to each tab and print the title 
		
		Set<String> windows = driver.getWindowHandles();
		
		Iterator<String>it = windows.iterator();
		while(it.hasNext()) {
			
			driver.switchTo().window(it.next());
			System.out.println( driver.getTitle());
		}
		
		driver.quit();
		
	
	}

}
