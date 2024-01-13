package Java_chatper1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Lecture10_Assignment1 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		
		driver.findElement(By.xpath("//input[@id ='checkBoxOption1']")).click();
		
		Assert.assertTrue(driver.findElement(By.xpath("//input[@id ='checkBoxOption1']")).isSelected());
		//System.out.println(driver.findElement(By.cssSelector("input[id *='friendsandfamily']")).isSelected());
		
		driver.findElement(By.xpath("//input[@id ='checkBoxOption1']")).click();
		
		Assert.assertFalse(driver.findElement(By.xpath("//input[@id ='checkBoxOption1']")).isSelected());
		
		System.out.println(driver.findElements(By.xpath("//input[@type='checkbox']")).size());
		
		driver.quit();

	}

}
