package ActionFrame;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Frames {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\ravin\\Documents\\Selenium\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://jqueryui.com/droppable/");
		driver.manage().window().maximize();
		
		driver.switchTo().frame(driver.findElement(By.cssSelector("iframe[class=\"demo-frame\"]")));
		
		Actions a =  new Actions(driver);
		WebElement source = driver.findElement(By.cssSelector("#draggable"));
		
		WebElement target = driver.findElement(By.cssSelector("#droppable"));
		
		a.dragAndDrop(source, target).build().perform();
		Thread.sleep(2000);
		driver.switchTo().defaultContent();//to come back from frame to original page.
		
		//Switching Frame by using index
		
		//driver.switchTo().frame(0);
		//0 for first frame or zero index
		//driver.switchTo.frame(1);
		//count number of frame available on webpage
		System.out.println(driver.findElements(By.tagName("iframe")).size());
		
		
		
		
		System.out.println(driver.getTitle());
		driver.close();
	}

}
