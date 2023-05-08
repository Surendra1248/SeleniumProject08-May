package firstPack;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class DemoTwoTest {
	
	@Test
	public void testOne() {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.selenium.dev/");
		System.out.println(driver.getTitle());
		System.out.println("Pushkar has updated this code with this statement");
		driver.quit();
	}

}
