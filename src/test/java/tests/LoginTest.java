package tests;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.AccountPage;
import pageObjects.LandingPage;
import pageObjects.LoginPage;
import resources.Base;
import resources.ExcelReader;

public class LoginTest extends Base {
	
	WebDriver driver;
	@BeforeMethod
	public void SetUp() throws IOException {
		driver=initializeDriver();
		driver.get(prop.getProperty("url"));
	}

	@Test(dataProvider = "getData")
	public void login(String uname,String pwd,String expected) throws IOException {
		
		LandingPage landing = new LandingPage(driver);
		landing.getMyaccField().click();
		landing.getLoginoptField().click();

		LoginPage lp = new LoginPage(driver);
		lp.getEmailField().sendKeys(uname);
		lp.getPasswdField().sendKeys(pwd);
		lp.getLoginBtnField().click();

		AccountPage account = new AccountPage(driver);
		String actual=null;
		try {
		if(account.getEditaccField().isDisplayed()) {
			actual="success";
		}
		}catch (Exception e) {
			actual="failure";
		}
		Assert.assertEquals(actual, expected);
	}

	@DataProvider
	public Object[][] getData() throws IOException {
		ExcelReader excel = new ExcelReader();
		Object[][] exceldata = excel.excelRead();
		return exceldata;
	}
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
