package Java_chatper1;

import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Session8a_Add_to_card {
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver","/Users/gagana/Downloads/chromedriver_mac_arm64 2/chromedriver");
		// If you want to add more than one product to the card

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		int j = 0;
		String NeededItems[] = { "Brocolli", "Cucumber", "Beans" };

		driver.get("https://rahulshettyacademy.com/seleniumPractise/");
		Thread.sleep(3000);

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
		Thread.sleep(2000);
		driver.quit();
	}

}
