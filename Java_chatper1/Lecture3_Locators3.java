package Java_chatper1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Lecture3_Locators3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		//xpath - parent to child and sibling to sibling 
		
		System.out.println(driver.findElement(By.xpath("//header/div/button/following-sibling::button[contains(text(),'Login')]")).getText());

		
		//xpath - parent > child > parent >> child 
		
		System.out.println(driver.findElement(By.xpath("//header/div/button/parent::div/button[2]")).getText());
		driver.quit();
			}

			}
