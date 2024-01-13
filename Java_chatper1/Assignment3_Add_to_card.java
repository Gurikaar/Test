package Java_chatper1;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Assignment3_Add_to_card {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "/Users/gagana/Downloads/chromedriver_mac_arm64 2/chromedriver");

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		String NeededItems[] = { "iphone X", "Samsung Note 8", "Nokia Edge", "Nokia Edge" };
		
	
		driver.get("https://rahulshettyacademy.com/loginpagePractise/");
		
		
		driver.findElement(By.id("username")).sendKeys("rahulshettyacademy");
		driver.findElement(By.id("password")).sendKeys("learning");
		driver.findElement(By.xpath("//label[@class='customradio'][2]")).click();
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@id='cancelBtn']")));
		
		driver.findElement(By.xpath("//button[@id='cancelBtn']")).click();
		
		WebElement dropdown = driver.findElement(By.xpath("//select[@class='form-control']"));
		Select option = new Select(dropdown);
		option.selectByIndex(2);
		
		System.out.println(option.getFirstSelectedOption().getText());
		
		driver.findElement(By.xpath("//input[@id='terms']")).click();
		driver.findElement(By.xpath("//input[@id='signInBtn']")).click();
		
		addcart(driver,NeededItems);
		System.out.println("Successfully added to the card");
		
		driver.findElement(By.xpath("//a[@class='nav-link btn btn-primary']")).click();
		
		driver.quit();
		
	}
	public  static void addcart(WebDriver driver,String[] NeededItems) {
		
		int j = 0;
		
		//Got the name of all products
		List<WebElement> names = driver.findElements(By.xpath("//h4[@class='card-title']"));
		
		//Iterate 
		for(int i=0;i<names.size();i++) {
			
			//Convert into Array list for easy search
			List totalname = Arrays.asList(NeededItems);
			if(totalname.contains(names)) {
				
				j++;
				driver.findElements(By.xpath("//button[@class='btn btn-info']")).get(i).click();
				
				if(j==NeededItems.length)
					break;
			}
		}
		
	}
		

	

}
