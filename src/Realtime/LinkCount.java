package Realtime;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LinkCount {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\ravin\\Documents\\Selenium\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.manage().window().maximize();
		
		System.out.println(driver.findElements(By.tagName("a")).size());
		
		WebElement footer = driver.findElement(By.cssSelector("div[id=\"gf-BIG\"]"));
		
		
		System.out.println(footer.findElements(By.tagName("a")).size());//Limit driver scope to footer section.
		
		//find links in first column
		
		WebElement scope1 = driver.findElement(By.xpath("//tbody/tr/td[1]/ul[1]"));
		
		int i = scope1.findElements(By.tagName("a")).size();
		System.out.println(i);
		//Click on each link in the column if page are opeaning
		
		for(int j=1;j<i;j++) {
			
			String s = Keys.chord(Keys.CONTROL,Keys.ENTER);
			scope1.findElements(By.tagName("a")).get(j).sendKeys(s);
			
			
		}
		Thread.sleep(5000);
		Set<String> handler = driver.getWindowHandles();
		Iterator<String> it = handler.iterator();
		
		while(it.hasNext()) {
			
			driver.switchTo().window(it.next());
			System.out.println(driver.getTitle());
			
		}
		
	}

}
