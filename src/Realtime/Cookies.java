package Realtime;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Cookies {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\ravin\\Documents\\Selenium\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		// if you want to delete particular cookie
		driver.manage().deleteCookieNamed("xyx");
		// delete session cookie
		// click on any link will direct to login page

		driver.get("https://rahulshettyacademy.com/AutomationPractice/");

	}

}
