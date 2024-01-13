package Java_chatper1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Lecture1_Locators {

	public static void main(String[] args) throws InterruptedException {
		//System.setProperty("webdriver.chrome.driver","/Users/gagana/Downloads/chromedriver_mac_arm64/chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		
		driver.get("https://rahulshettyacademy.com/locatorspractice/");
		
		driver.findElement(By.id("inputUsername")).sendKeys("Gagana");
		
		driver.findElement(By.name("inputPassword")).sendKeys("12345678");
		
		driver.findElement(By.className("submit")).click();
		
		System.out.println(driver.findElement(By.cssSelector("p[class='error']")).getText());
		
		driver.findElement(By.linkText("Forgot your password?")).click();
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//input[@placeholder= 'Name']")).sendKeys("Gagana");
		
		driver.findElement(By.xpath("//form/input[@placeholder ='Email']")).sendKeys("gurikaar@gmail.com");
		
		driver.findElement(By.cssSelector("input[type='text']:nth-child(4)")).sendKeys("9876545678");
		
		driver.findElement(By.xpath("//div/button[2]")).click();
		Thread.sleep(2000);
		
		System.out.println(driver.findElement(By.cssSelector(".infoMsg")).getText());
		
		driver.findElement(By.xpath("//div[@class='forgot-pwd-btn-conainer']/button[1]")).click();
		Thread.sleep(2000);
		
		driver.findElement(By.cssSelector("#inputUsername")).sendKeys("Gagana");
		
		driver.findElement(By.cssSelector("input[placeholder *='Pass']")).sendKeys("rahulshettyacademy");
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//*[contains(text(),'Sign In')]")).click();
		Thread.sleep(2000);
		
		driver.quit();
		
		

	}

}
