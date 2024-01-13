package Java_chatper1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Lecture9_Asserts {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		Assert.assertFalse(driver.findElement(By.cssSelector("input[id *='friendsandfamily']")).isSelected());
		//System.out.println(driver.findElement(By.cssSelector("input[id *='friendsandfamily']")).isSelected());
		
		
		driver.findElement(By.cssSelector("input[id *='friendsandfamily']")).click();
		
		Assert.assertTrue(driver.findElement(By.cssSelector("input[id *='friendsandfamily']")).isSelected());
		//System.out.println(driver.findElement(By.cssSelector("input[id *='friendsandfamily']")).isSelected());
		
		driver.findElement(By.id("divpaxinfo")).click();
		Thread.sleep(3000);
		for(int i=1;i<4;i++) {
			driver.findElement(By.id("hrefIncAdt")).click();
		}
		driver.findElement(By.id("btnclosepaxoption"));
		Assert.assertEquals(driver.findElement(By.id("divpaxinfo")).getText(), "4 Adult");
		
		driver.quit();

	}

}
