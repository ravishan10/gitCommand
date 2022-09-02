package Selenium4.O;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.openqa.selenium.support.locators.RelativeLocator.*;


public class RelativeLocator {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\ravin\\Documents\\Selenium\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://rahulshettyacademy.com/angularpractice/");
		//above
		WebElement namr= driver.findElement(By.cssSelector("input[name=\"name\"]"));
		System.out.println(driver.findElement(with(By.tagName("label")).above(namr)).getText());
		//driver.findElement(with(By.tagName("label")).above(namr)).getText();
		//below
		WebElement belw = driver.findElement(By.cssSelector("label[for='dateofBirth']"));
		driver.findElement(with(By.tagName("input")).below(belw)).click();
		
		//left
		WebElement lef = driver.findElement(By.xpath("//label[text()='Check me out if you Love IceCreams!']"));
		
		driver.findElement(with(By.tagName("input")).toLeftOf(lef)).click();
		//right : inlineRadio1
		
		WebElement rigt = driver.findElement(By.id("inlineRadio1"));
		String s = driver.findElement(with(By.tagName("label")).toRightOf(rigt)).getText();
		System.out.println(s);
		
	}

}
