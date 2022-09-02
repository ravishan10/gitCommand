package Realtime;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Calender {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\ravin\\Documents\\Selenium\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.path2usa.com/travel-companion/");
		driver.manage().window().maximize();
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(209, 1314)");
		
		
		driver.findElement(By.cssSelector("input[id=\"form-field-travel_comp_date\"]")).click();
		
		List<WebElement> dates = driver.findElements(By.cssSelector(".flatpickr-day"));
		
		for(int i=0;i<dates.size();i++) {
			
			String text = driver.findElements(By.cssSelector(".flatpickr-day")).get(i).getText();
			if(text.equals("10")) {
				
				driver.findElements(By.cssSelector(".flatpickr-day")).get(i).click();
				break;
				
			}
			
		}

	}

}
