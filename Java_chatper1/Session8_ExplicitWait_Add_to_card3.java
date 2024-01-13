package Java_chatper1;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Session8_ExplicitWait_Add_to_card3 {
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "/Users/gagana/Downloads/chromedriver_mac_arm64 2/chromedriver");
		// If you want to add more than one product to the card

		WebDriver driver = new ChromeDriver();
		
		//Implicit wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	
		
		driver.manage().window().maximize();

		String NeededItems[] = { "Brocolli", "Cucumber", "Beans" };

		driver.get("https://rahulshettyacademy.com/seleniumPractise/");
		Thread.sleep(3000);

		additems(driver, NeededItems);

		Thread.sleep(2000);
		
		//Click on cart icon
		driver.findElement(By.xpath("//img[@alt='Cart']")).click();
		
		driver.findElement(By.xpath("//button[contains(text(),'PROCEED TO CHECKOUT')]")).click();
		
		driver.findElement(By.xpath("//input[@class='promoCode']")).sendKeys("rahulshettyacademy");
		
		driver.findElement(By.xpath("//button[@class='promoBtn']")).click();
	
		
		System.out.println(driver.findElement(By.xpath("//span[@class='promoInfo']")).getText());
		
		
		
		
		driver.quit();
	}

	public static void additems(WebDriver driver, String NeededItems[]) {

		int j = 0;
		// Get the product name
		List<WebElement> products = driver.findElements(By.xpath("//h4[@class='product-name']"));

		// iterate
		for (int i = 0; i < products.size(); i++) {

			// format it to actual vegetable name >> // name >> Beans - 1 KG.

			String[] name = products.get(i).getText().split("-");
			String formattedName = name[0].trim();

			// check whether the name you extracted is present in the array or not
			// convert array into array list for easy search

			List ItemNeededList = Arrays.asList(NeededItems);

			if (ItemNeededList.contains(formattedName)) {

				j++;

				// To add into cart
				driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click();

				if (j == NeededItems.length)
					break;

			}
		}
	}

}
