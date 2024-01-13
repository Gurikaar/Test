package Java_Chapter15;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

public class Invoke_MultipleWindows_orTab {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "/Users/gagana/Downloads/chromedriver_mac_arm64 2/chromedriver");

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://rahulshettyacademy.com/angularpractice/"); //A
		
		//1. Open A URL 
		//2. Open a new window/Tab
		//3. Input the URL 
		//4. get the text of first course 
		//5. Redirect to the previous tab ie A
		//in the name section paste it 
		
		driver.switchTo().newWindow(WindowType.TAB);
		
		//or
		//driver.switchTo().newWindow(WindowType.WINDOW);
		
		//Now to give the driver control to the newly opened window, perform the following steps 
		
		Set<String> windows = driver.getWindowHandles(); //1
		Iterator<String> it = windows.iterator(); //2
		String ParentWindow = it.next(); //3
		String ChildWindow = it.next(); //4
		driver.switchTo().window(ChildWindow); //5
		
		driver.get("https://rahulshettyacademy.com/");
		
		String course = driver.findElements(By.cssSelector("a[href*= 'https://courses.rahulshettyacademy.com/p'] ")).get(1).getText();
		
		driver.switchTo().window(ParentWindow);
		
		driver.findElement(By.name("name")).sendKeys(course);
		
		driver.quit();
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
