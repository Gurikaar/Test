package Java_chatper1;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public  class Lecture2_Locators2 {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		
		String name = "Gagana";
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		
		driver.get("https://rahulshettyacademy.com/locatorspractice/");
		
		driver.findElement(By.cssSelector("#inputUsername")).sendKeys(name);
		
		String password = getpassword(driver);
		Thread.sleep(3000);
		
		driver.findElement(By.cssSelector("input[placeholder *='Pass']")).sendKeys(password);
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//*[contains(text(),'Sign In')]")).click();
		Thread.sleep(2000);
		
		System.out.println(driver.findElement(By.tagName("p")).getText());
		
		Assert.assertEquals(driver.findElement(By.tagName("p")).getText(), "You are successfully logged in.");
		
		System.out.println(driver.findElement(By.cssSelector("div[class=login-container] h2")).getText());
		
		Assert.assertEquals(driver.findElement(By.cssSelector("div[class=login-container] h2")).getText(),"Hello "+name+",");
		driver.close();
	}
		public static String getpassword(WebDriver driver) throws InterruptedException {
		driver.findElement(By.linkText("Forgot your password?")).click();
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//div/button[2]")).click();
		
		//Please use temporary password 'rahulshettyacademy' to Login.
		String passwordText = driver.findElement(By.cssSelector(".infoMsg")).getText();
		
		String passwordArray[] = passwordText.split("'");
		
		String password = passwordArray[1].split("'")[0];
		
		driver.findElement(By.xpath("//div[@class='forgot-pwd-btn-conainer']/button[1]")).click();
		Thread.sleep(2000);
		
		return password;
		
	}
	

}
