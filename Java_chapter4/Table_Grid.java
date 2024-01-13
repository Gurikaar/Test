package Java_chapter4;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Table_Grid {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "/Users/gagana/Downloads/chromedriver_mac_arm64 2/chromedriver");

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		//Try this in console to check what pixel you need : window.scrollBy(0,500)
		((JavascriptExecutor)driver).executeScript("scroll(0,500)");
		Thread.sleep(2000);
		//Try this in console to check what pixel you need : document.querySelector(\".tableFixHead\").scrollTop= 5000"
		
		((JavascriptExecutor)driver).executeScript("document.querySelector(\".tableFixHead\").scrollTop= 5000");
		
		List<WebElement> TblAmount =driver.findElements(By.xpath("//div[@class='tableFixHead']/table/tbody/tr/td[4]"));
		int Sum =0;
		for (int i=0;i<TblAmount.size();i++) {
			//>> 1st step TblAmount.get(i).getText(); 
			//>> 2nd step I have convert string into int : Integer.parseInt(TblAmount.get(i).getText());
			// >> Sum each value. for that Initaise a sum variable befor for loop
			
			Sum = Sum +Integer.parseInt(TblAmount.get(i).getText());
			
		}
		
		
		//Now Assert
		
		String compare =driver.findElement(By.xpath("//div[@class='totalAmount']")).getText().split(":")[1].trim();
		
		Assert.assertNotSame(Sum, compare);
		
		driver.quit();
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		

	}

}
