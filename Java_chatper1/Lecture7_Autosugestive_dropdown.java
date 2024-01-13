package Java_chatper1;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Lecture7_Autosugestive_dropdown {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		driver.findElement(By.id("autosuggest")).sendKeys("Ind");
		Thread.sleep(3000);
		
		// What I have done in the below line is 
		// I have taken the parent xpath and given child tagnames to it 
		
		List<WebElement> options = driver.findElements(By.xpath("//li[@class='ui-menu-item']/a"));
		for(WebElement option : options) {
			if(option.getText().equalsIgnoreCase("India")) {
			option.click();
			break;
			}
		}
		//System.out.println(driver.findElement(By.id("autosuggest")).getText());
		driver.quit();
	}

}
