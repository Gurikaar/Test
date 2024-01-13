package Java_Chapter13;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class MaxWindow_DeleteCookies {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "/Users/gagana/Downloads/chromedriver_mac_arm64 2/chromedriver");

		WebDriver driver = new ChromeDriver(); 
		
		driver.manage().window().maximize(); //1
		 driver.manage().deleteAllCookies(); //2
		 
		 //driver.manage().deleteCookieNamed("SesssionKey"); //3 if we want to delete a particular cookie 

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		driver.get("https://www.google.com/");

	}

}
