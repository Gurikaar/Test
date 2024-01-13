package Java_Chapter3;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Window_Handle_concept {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "/Users/gagana/Downloads/chromedriver_mac_arm64 2/chromedriver");

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://rahulshettyacademy.com/loginpagePractise/");
		driver.findElement(By.xpath("//a[@class='blinkingText']")).click();
		
		Set<String> windows = driver.getWindowHandles(); //parentid and childId
		
		// need to provide which needs to select 
		Iterator<String> it =windows.iterator();
		String parentId= it.next();
		String childId = it.next();
		
		driver.switchTo().window(childId);
		
		//Grabbing the text in parent page
		System.out.println(driver.findElement(By.xpath("//p[@class='im-para red']")).getText());
		
		String EMailId =driver.findElement(By.xpath("//p[@class='im-para red']")).getText().split("at")[1].trim().split(" ")[0];
		
		driver.switchTo().window(parentId);
		
		driver.findElement(By.id("username")).sendKeys(EMailId);
		
		driver.quit();
		

	}

}
