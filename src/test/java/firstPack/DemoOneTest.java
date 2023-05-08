package firstPack;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class DemoOneTest {
	
	@Test
	public void testOne() {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.google.co.in/");
		System.out.println(driver.getTitle());
		System.out.println("Arun has updated this code with this statement");
		System.out.println("Arun has updated this code to add into abranch");
		driver.quit();
	}

}
