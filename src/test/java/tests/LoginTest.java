package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import pages.LoginPage;
import util.BrowserFactory;
import util.ExcelReader;

public class LoginTest {

	WebDriver driver;
	
	ExcelReader excelRead = new ExcelReader("src\\test\\java\\testData\\myData.xlsx");
	String emailOrUsername = excelRead.getCellData("LoginInformation", "EmailOrUsername", 2);
	String userName = excelRead.getCellData("LoginInformation", "UserName", 2);
	String password = excelRead.getCellData("LoginInformation", "Password", 2);
	
	@Test
	public void validUserShouldBeAbleToLogIn() throws InterruptedException {
		
		driver = BrowserFactory.init();
		
		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);

		loginPage.insertUsername(userName);
		loginPage.insertPassword(password);
		loginPage.clickOnSinginButton();
		Thread.sleep(2000);
		
		//BrowserFactory.tearDown();
	}
}
