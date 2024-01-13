package Java_chatper1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Lecture6_Dynamic_dropdown {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");

		driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();

		/*
		driver.findElement(By.xpath("//a[@value='BLR']")).click();		
		Thread.sleep(2000);
		// if there are 2 same xapth, then by default first xapth is selected,
		//hence to select the second dropdown, wrap the whole xapth in with round brackets and specify 
		//the index
		driver.findElement(By.xpath("(//a[@value='MAA'])[2]")).click();
		*/

		
		// BY parent to child
		driver.findElement(By.xpath("//div[@id='ctl00_mainContent_ddl_originStation1_CTNR'] //a[@value='BLR']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@id='ctl00_mainContent_ddl_destinationStation1_CTNR'] //a[@value='MAA']")).click();
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("a[class*='ui-state-highlight']")).click();
		
		driver.quit();
		
		

	}

}
