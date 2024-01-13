package Java_Chapter13;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class SSSl_Check {

	public static void main(String[] args) {

		// SInce the below url is not a secure HTTP or HTTPs we need to call a class
		ChromeOptions option = new ChromeOptions(); // 1
		option.setAcceptInsecureCerts(true); // 2

		// To open proxy site 
		Proxy proxy = new Proxy();
		proxy.setHttpProxy("ipaddress:4444");
		option.setCapability("proxy", proxy);

		// to download in a specific directory 
		Map<String, Object> prefs = new HashMap<String, Object>();
		prefs.put("download.default_directory", "/directory/path");
		option.setExperimentalOption("prefs", prefs);

		System.setProperty("webdriver.chrome.driver", "/Users/gagana/Downloads/chromedriver_mac_arm64 2/chromedriver");

		WebDriver driver = new ChromeDriver(option); // 3
		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		driver.get("https://expired.badssl.com/");

		System.out.println(driver.getTitle());
		driver.quit();

	}

}
