package Java_Chapter15;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

public class PartialScreenshot {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		//Continuation of Invoke_MultipleWindows_orTab
		// Requirement is to just take the SS of whatever we have pasted in name textbox

		System.setProperty("webdriver.chrome.driver", "/Users/gagana/Downloads/chromedriver_mac_arm64 2/chromedriver");

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://rahulshettyacademy.com/angularpractice/");
		driver.switchTo().newWindow(WindowType.WINDOW);

		Set<String> windows = driver.getWindowHandles(); // 1
		Iterator<String> it = windows.iterator(); // 2
		String ParentWindow = it.next(); // 3
		String ChildWindow = it.next(); // 4
		driver.switchTo().window(ChildWindow); // 5

		driver.get("https://rahulshettyacademy.com/");

		String course = driver.findElements(By.cssSelector("a[href*= 'https://courses.rahulshettyacademy.com/p'] "))
				.get(1).getText();

		driver.switchTo().window(ParentWindow);

		WebElement name = driver.findElement(By.name("name"));
		name.sendKeys(course);
		
		File src = name.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File("logo.png"));
		
		// To see the SS
		// Project Right click 
		// under target folder. logo.png is updated 
		//Now RC >> properties>> open in file (select)
		
		
		
		//Next task is to get the height and width 
		//This is he code below 
		//name.getRect().getDimension().getHeight()
		//name.getRect().getDimension().getWidth()
		
		System.out.println(name.getRect().getDimension().getHeight());
		System.out.println(name.getRect().getDimension().getWidth());
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		driver.quit();

	}

}
