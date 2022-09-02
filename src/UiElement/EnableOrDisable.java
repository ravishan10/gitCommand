package UiElement;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class EnableOrDisable {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\ravin\\Documents\\Selenium\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		
		Thread.sleep(2000);
		driver.manage().window().maximize();
		String s1 = driver.findElement(By.id("Div1")).getAttribute("style");
		System.out.println(s1);
		//System.out.println(driver.findElement(By.name("ctl00$mainContent$view_date2")).isEnabled());
		driver.findElement(By.cssSelector("input[value='RoundTrip']")).click();
		//System.out.println(driver.findElement(By.name("ctl00$mainContent$view_date2")).isEnabled());
		
		
		String s2 = driver.findElement(By.id("Div1")).getAttribute("style");
		System.out.println(s2);
		
		if(driver.findElement(By.id("Div1")).getAttribute("style").contains("1")) {
			
			System.out.println("Its Enabled");
			
		}
		else {
			
			System.out.println("Its not Enabled");
		}
		
		
	}

}
