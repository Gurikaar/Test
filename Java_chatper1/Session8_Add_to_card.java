package Java_chatper1;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Session8_Add_to_card {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/");

		// If you want to add one specific product to the card

		// Get the product name
		List<WebElement> products = driver.findElements(By.xpath("//h4[@class='product-name']"));

		// iterate
		for (int i = 0; i < products.size(); i++) {

			// name >> Beans - 1 Kg

			String name = products.get(i).getText();
			
			if (name.contains("cucumber")) {


			// To add into cart
			driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click();
			break;
			}
		}

	}

}
