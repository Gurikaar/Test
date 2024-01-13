package Java_Chapter14;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class CustomMethods_Stream_Mapper {

	// Continuation of WebTable_sorting
	// Requirement is to get the price of each vegetable

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "/Users/gagana/Downloads/chromedriver_mac_arm64 2/chromedriver");

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");

		// Click on the column

		driver.findElement(By.xpath("//tr/th[1]")).click();

		List<String> price;
		// Scan the name column with getText -> returns Rice -> Print the price of the Rice

		do {
			// capture all webelement into list
			List<WebElement> elements = driver.findElements(By.xpath("//td[1]"));

			price = elements.stream().filter(s -> s.getText().contains("Rice")).map(s -> getPriceVeggie(s))
					.collect(Collectors.toList());

			price.forEach(a -> System.out.println(a));

			if (price.size() < 1) {
				driver.findElement(By.xpath("//a[@aria-label='Next']")).click();
			}
		} while (price.size() < 1);

		driver.quit();

	}

	private static String getPriceVeggie(WebElement s) {
		// TODO Auto-generated method stub

		String PriceValue = s.findElement(By.xpath("following-sibling::td[1]")).getText();
		return PriceValue;
	}

}
