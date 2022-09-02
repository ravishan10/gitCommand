package JavaStream;

import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class WebTableSort {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\ravin\\Documents\\Selenium\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		driver.get("https://rahulshettyacademy.com/seleniumPractise/");
		driver.findElement(By.xpath("//a[contains(text(),'Top Deals')]")).click();
		Set<String> handle = driver.getWindowHandles();
		Iterator<String> it = handle.iterator();
		String parent = it.next();
		String child = it.next();
		driver.switchTo().window(child);
		// Click on column
		driver.findElement(By.xpath("//tr[1]/th[1]")).click();

		// capture all webelement into list
		List<WebElement> list = driver.findElements(By.xpath("//tr/td[1]"));

		// capture text of all webelement into new(original) list
		List<String> originalList = list.stream().map(s -> s.getText()).collect(Collectors.toList());

		// sort on the original list of step 3 ->sorted list
		List<String> sortedList = originalList.stream().collect(Collectors.toList());
		// compare original list vs sorted list

		Assert.assertTrue(originalList.equals(sortedList));

		// scan the name column with getText - >Rice ->print the price of the rice

		List<String> price =list.stream().filter(s->s.getText().contains("Beans")).map(s->getPriceVeggie(s)).collect(Collectors.toList());
		price.forEach(a->System.out.println(a));
		
		
		
	}

	private static String getPriceVeggie(WebElement s) {
		
		
		String pricevalue = s.findElement(By.xpath("following-sibling::td[1]")).getText();
		
		
		return pricevalue;
	}
}