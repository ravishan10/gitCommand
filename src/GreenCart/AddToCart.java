package GreenCart;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AddToCart {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\ravin\\Documents\\Selenium\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");

		Thread.sleep(2000);
		driver.manage().window().maximize();
		// //button[text()='ADD TO CART']
		// H4.product-name
		List<WebElement> products = driver.findElements(By.cssSelector("H4.product-name"));
		
		for(int i=0;i<=products.size();i++) {
			
			String name = products.get(i).getText();
			
			if (name.contains("Cucumber")) {
				
				//click on Add to Cart
				driver.findElements(By.xpath("//button[text()='ADD TO CART']")).get(i).click();
				break;
			}
		}
		
		
	}

}
