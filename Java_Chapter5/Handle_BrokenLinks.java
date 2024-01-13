package Java_Chapter13;

import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Duration;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Handle_BrokenLinks {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "/Users/gagana/Downloads/chromedriver_mac_arm64 2/chromedriver");

		WebDriver driver = new ChromeDriver(); 
		
		driver.manage().window().maximize(); //1
		 driver.manage().deleteAllCookies(); //2
		 
		 //driver.manage().deleteCookieNamed("SesssionKey"); //3 if we want to delete a particular cookie 

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		
		//broken links 
		//1. Is to get all URL's tied up to the links using selenium 
		//2. Java method will call you that url and get you all status code
		//3. If status code is greater then 400 then the url is not working >> link which tied up to the url is broken
		
		String url = driver.findElement(By.cssSelector("a[href *= 'brokenlink']")).getAttribute("href");
		
		//URL >> class
		//OpenConnection is the Java method 
		//HttpURLConnection is the return type of Openconnection
		
		HttpURLConnection connec	=(HttpURLConnection)new URL(url).openConnection();
		connec.setRequestMethod("HEAD");
		connec.connect();
		int responseCode= connec.getResponseCode();
		System.out.println(responseCode);
		
		driver.quit();

	}

}
