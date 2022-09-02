package Realtime;

import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;

public class Certifications {

	public static void main(String[] args) {
		
		ChromeOptions options = new ChromeOptions();
		options.setAcceptInsecureCerts(true);
		//FirefoxOptions options1 =  new FirefoxOptions();
		//EdgeOptions options2 = new EdgeOptions();
		//options.addExtensions("pathofextentionfile");
		//Proxy proxy = new Proxy();//Ask your support /secruty team to provide proxy string
		//proxy.setHttpProxy("ipaddress:444");
		
		options.setCapability(null, options);
		
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\ravin\\Documents\\Selenium\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver(options);
		
		driver.get("https://expired.badssl.com/");
		
		System.out.println(driver.getTitle());
		

	}

}
