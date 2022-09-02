package UiElement;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Radio {

	public static void main(String[] args) throws InterruptedException {
		//input[value='']
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\ravin\\Documents\\Selenium\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		
		Thread.sleep(2000);
		driver.manage().window().maximize();
		Thread.sleep(2000);
		System.out.println(driver.findElement(By.cssSelector("input[value='OneWay']")).isSelected());
		
		driver.findElement(By.cssSelector("input[value='OneWay']")).click();
		
		System.out.println(driver.findElement(By.cssSelector("input[value='OneWay']")).isSelected());
		
		driver.findElement(By.cssSelector("input[value='RoundTrip']")).click();
		System.out.println(driver.findElement(By.cssSelector("input[value='OneWay']")).isSelected());
		
	}

}
