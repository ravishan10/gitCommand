package UiElement;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Dropdown {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver","C:\\Users\\ravin\\Documents\\Selenium\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		//https://rahulshettyacademy.com/dropdownsPractise/
		Thread.sleep(2000);
		
		WebElement StaticDropdown = driver.findElement(By.xpath("//select[@id=\"ctl00_mainContent_DropDownListCurrency\"]"));
		Select dropdown = new Select(StaticDropdown);
		
		dropdown.selectByIndex(2);
		Thread.sleep(2000);
		dropdown.selectByVisibleText("INR");
		Thread.sleep(2000);
		dropdown.selectByValue("USD");
		
		String a = dropdown.getFirstSelectedOption().getText();
		System.out.println(a);
		
		driver.close();
		
	}

}
