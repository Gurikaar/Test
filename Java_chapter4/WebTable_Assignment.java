package Java_chapter4;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebTable_Assignment {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "/Users/gagana/Downloads/chromedriver_mac_arm64 2/chromedriver");

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		((JavascriptExecutor)driver).executeScript("scroll(0,500)");
		
		List<WebElement> rows= driver.findElements(By.xpath("//table[@class='table-display']/tbody/tr"));
		
		List<WebElement> column= driver.findElements(By.xpath("//table[@class='table-display']/tbody/tr/th"));
		
		int rowcount= rows.size();
		int colcount =column.size();
		int count_rows =0;
		int count_col =0;
		
		for(int i=0;i<rowcount;i++) {
			count_rows++;

			if(count_rows==3) {
				
				String row_data=driver.findElements(By.xpath("//table[@class='table-display']/tbody/tr")).get(i).getText();
				System.out.println(row_data);
			}
			
		for(int j=0;j<colcount;j++) { 
			count_col++;
			
		}
			
			
		}
		System.out.println("Row count:" + count_rows);
		
		System.out.println("column count:" + count_col);
		
		driver.quit();
	}

}
