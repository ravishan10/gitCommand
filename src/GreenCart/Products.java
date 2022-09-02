package GreenCart;

import java.util.List;
import java.util.Arrays;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Products {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\ravin\\Documents\\Selenium\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
		String[] items = { "Cucumber", "Brocolli", "Tomato", "Potato", "Mango" };
		int j = 0;
		Thread.sleep(2000);
		driver.manage().window().maximize();
		// //button[text()='ADD TO CART']
		// H4.product-name
		List<WebElement> products = driver.findElements(By.cssSelector("H4.product-name"));
		// format it to get actual vegetable name
		// check whether name you extracted is present in array or not-
		// convert array into array list for easy search

		List itemsNeeded = Arrays.asList(items);

		for (int i = 0; i < products.size(); i++) {
			// Brocolli - 1 Kg

			String[] name = products.get(i).getText().split("-");
			// name[0]-Brocolli
			// name[1]= 1 Kg

			String formatedName = name[0].trim();

			if (itemsNeeded.contains(formatedName)) {
				// Click to Add to cart
				driver.findElements(By.xpath("//div[@class='product-action']/button[1]")).get(i).click();
				// code comes to block depends on itemlist.
				j++;
				if (j == items.length)
					break;
			}
		}

	}

}
