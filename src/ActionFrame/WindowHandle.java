package ActionFrame;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowHandle {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\ravin\\Documents\\Selenium\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/loginpagePractise/");
		driver.manage().window().maximize();
		driver.findElement(By.cssSelector("a.blinkingText")).click();
		Set<String> window = driver.getWindowHandles();
		
		Iterator<String> it = window.iterator();
		
		String Parentid = it.next();
		String Childid = it.next();
		
		driver.switchTo().window(Childid);
		
		String s = driver.findElement(By.cssSelector(".im-para.red")).getText();
		driver.findElement(By.cssSelector(".im-para.red")).getText();
		System.out.println(s);
		String Email = driver.findElement(By.cssSelector(".im-para.red")).getText().split("at")[1].trim().split(" ")[0];
		
		driver.switchTo().window(Parentid);
		
		
		driver.findElement(By.cssSelector("input[id='username']")).sendKeys(Email);
		
		
		
	}

}
