package Java_chapter4;

import java.time.Duration;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Autosugestion_dropdown_Assignment {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "/Users/gagana/Downloads/chromedriver_mac_arm64 2/chromedriver");

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");

		
		
		driver.findElement(By.id("autocomplete")).sendKeys("Ind");
		
		List<WebElement>dropdown=driver.findElements(By.xpath("//ul[@class='ui-menu ui-widget ui-widget-content ui-autocomplete ui-front']/li/div"));
		
		for(WebElement option : dropdown) {
			if(option.getText().equalsIgnoreCase("India")) {
			option.click();
			Thread.sleep(3000);
			break;
			}
		}
		
		
		driver.quit();
		
		

	}

}
