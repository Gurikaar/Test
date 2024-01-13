package Java_chatper1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Lecture11_Attributes {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		
		
		driver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_1")).click();
		
		System.out.println(driver.findElement(By.id("Div1")).getAttribute("style"));
		
		driver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_1")).click();
		
		System.out.println(driver.findElement(By.id("Div1")).getAttribute("style"));
		
		if(driver.findElement(By.id("Div1")).getAttribute("style").contains("0.5")){
			
			System.out.println("It's Enabled");
			Assert.assertTrue(true);
		}
		else {
			Assert.assertFalse(false);
			System.out.println("It's not Enabled");
		}
		
		Thread.sleep(3000);
		
		driver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_0")).click();
		
		
		System.out.println(driver.findElement(By.id("Div1")).getAttribute("style"));
		
		driver.quit();
		

	}

}
