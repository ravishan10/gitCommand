package Browser;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class Edge {

	public static void main(String[] args) {
		System.setProperty("webdriver.edge.driver", "C:\\Users\\ravin\\Documents\\Selenium\\edgedriver_win64\\msedgedriver.exe");
		WebDriver driver = new EdgeDriver();
		
		driver.get("https://www.google.co.in/");
		driver.close();
		
	}

}
