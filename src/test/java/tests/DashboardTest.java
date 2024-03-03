package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import pages.DashboardPage;
import pages.LoginPage;
import util.BrowserFactory;
import util.ExcelReader;

public class DashboardTest {
	
	WebDriver driver;

	ExcelReader excelRead = new ExcelReader("src\\test\\java\\testData\\myData.xlsx");
	String emailOrUsername = excelRead.getCellData("LoginInformation", "EmailOrUsername", 2);
	String userName = excelRead.getCellData("LoginInformation", "UserName", 2);
	String password = excelRead.getCellData("LoginInformation", "Password", 2);
	String dashboardHeaderText = excelRead.getCellData("ValidateHeaderText", "HeaderText", 2);
	
	@Test
	public void userShouldBeAbleToClickOnCustomersAndAddCustomerMenus() throws InterruptedException {
	
		driver = BrowserFactory.init();
		
		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		
		loginPage.insertUsername(userName);
		loginPage.insertPassword(password);
		loginPage.clickOnSinginButton();
		Thread.sleep(2000);

		DashboardPage dashboardPage = PageFactory.initElements(driver, DashboardPage.class);
		dashboardPage.validateDahsboardHeaderText(dashboardHeaderText);
		Thread.sleep(3000);

		dashboardPage.clickOnCustomersMenu();
		Thread.sleep(2000);

		dashboardPage.clickOnAddCustomerMenu();
		Thread.sleep(2000);
		
		//BrowserFactory.tearDown();
		
	}

}
