package Java_chatper1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Lecture8_Checkboxes {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		
		System.out.println(driver.findElement(By.cssSelector("input[id *='friendsandfamily']")).isSelected());
		
		//Using Regex in css selector
		driver.findElement(By.cssSelector("input[id *='friendsandfamily']")).click();
		System.out.println(driver.findElement(By.cssSelector("input[id *='friendsandfamily']")).isSelected());
		
		//Count the number of checkboxes
		System.out.println(driver.findElements(By.xpath("//input[@type='checkbox']")).size());
		
		

	}

}
