package Realtime;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrokenLink {

	public static void main(String[] args) throws MalformedURLException, IOException {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\ravin\\Documents\\Selenium\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		//Broken URL
		
		//Step 1 is to get all urls tied up to the links using selenium
		//Java methods will call URL and gets you the status code
		//if status code >400 then that url is not working
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		String url = driver.findElement(By.cssSelector("a[href*='soapui']")).getAttribute("href");
		HttpURLConnection conn =(HttpURLConnection) new URL(url).openConnection();
		conn.setRequestMethod("HEAD");
		conn.connect();
		int i= conn.getResponseCode();
		System.out.println(i);
		
		List<WebElement> links = driver.findElements(By.xpath("//li[@class='gf-li']/a"));
		
		for(WebElement link : links) {
			
			String url1 =link.getAttribute("href");
			HttpURLConnection con =(HttpURLConnection) new URL(url1).openConnection();
			con.setRequestMethod("HEAD");
			con.connect();
			int j= con.getResponseCode();
			System.out.println(j);
			
			if(j>400) {
				System.out.println("The Link with Text" +link.getText()+ "is broken with code"+ j);
				
			}
		}
	}

}
