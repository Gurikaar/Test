package Java_chapter4;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Assignment {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "/Users/gagana/Downloads/chromedriver_mac_arm64 2/chromedriver");

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://qaclickacademy.com/practice.php");
		
		//Task
		//1. Select any checkbox and grab the label of the selected checkbox [Hint: Put that in a variable ]
		//2.Select the option from drop, Here the option should come from Step2 
		//3. Enter the step2 grabbed label text into Edit box
		//4. Click alert and verify if the text grabbed from step2 is present in the pop up message 

		driver.findElement(By.id("checkBoxOption1")).click();
		String label = driver.findElement(By.xpath("//label[@for='bmw']")).getText();
		
		
		WebElement dropdown = driver.findElement(By.id("dropdown-class-example"));
		
		Select option = new Select(dropdown);
		option.selectByVisibleText(label);
		Thread.sleep(3000);
		
		driver.findElement(By.id("name")).sendKeys(label);
		Thread.sleep(3000);
		driver.findElement(By.id("alertbtn")).click();
		
		
		String message = driver.switchTo().alert().getText().split("Hello")[1].trim().split(",")[0];
		System.out.println(message);
		
		driver.quit();
		
		
		
		
	}

}
