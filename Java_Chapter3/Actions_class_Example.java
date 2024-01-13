package Java_Chapter3;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Actions_class_Example {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "/Users/gagana/Downloads/chromedriver_mac_arm64 2/chromedriver");

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://www.amazon.com/");
		
		Actions hover = new Actions(driver);
		WebElement move = driver.findElement(By.xpath("//span[@class='nav-line-2 ']"));
		WebElement caps = driver.findElement(By.id("twotabsearchtextbox"));
		
		
		
		//Moves to specific element & context click(clicking on that element)
		hover.moveToElement(move).contextClick().build().perform();
		
		//enter capital letter in the search box & double click 
		hover.moveToElement(caps).click().keyDown(Keys.SHIFT).sendKeys("Hello").doubleClick().build().perform();

		
		driver.quit();
		
		
		

	}

}
