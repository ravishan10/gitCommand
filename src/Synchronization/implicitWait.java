package Synchronization;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class implicitWait {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\ravin\\Documents\\Selenium\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		//driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
		

		String[] items = { "Cucumber", "Brocolli", "Tomato", "Potato", "Mango" };

		driver.manage().window().maximize();
		addItems(driver, items);
		driver.findElement(By.cssSelector("img[alt=\"Cart\"]")).click();
		
		driver.findElement(By.xpath("//button[contains(text(),'PROCEED TO CHECKOUT')]")).click();
		
		driver.findElement(By.cssSelector(".promoCode")).sendKeys("rahulshettyacademy");
		driver.findElement(By.cssSelector("button.promoBtn")).click();
		//Explicit Wait
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));


		//WebDriverWait w = new WebDriverWait(driver,5); Deprecated selenium4
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("span.promoInfo")));
		
		
		System.out.println(driver.findElement(By.cssSelector("span.promoInfo")).getText());
		
		driver.close();
		
	}

	public static void addItems(WebDriver driver, String[] items) {
		int j = 0;

		List<WebElement> products = driver.findElements(By.cssSelector("H4.product-name"));

		List itemsNeeded = Arrays.asList(items);

		for (int i = 0; i < products.size(); i++) {

			String[] name = products.get(i).getText().split("-");

			String formatedName = name[0].trim();

			if (itemsNeeded.contains(formatedName)) {

				driver.findElements(By.xpath("//div[@class='product-action']/button[1]")).get(i).click();

				j++;
				if (j == items.length)
					break;
			}
		}

	}
}
