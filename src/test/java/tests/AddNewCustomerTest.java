package tests;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import pages.AddNewCustomerPage;
import pages.BasePage;
import pages.DashboardPage;
import pages.LoginPage;
import util.BrowserFactory;
import util.ExcelReader;

public class AddNewCustomerTest extends BasePage{

	WebDriver driver;
	
	ExcelReader excelRead = new ExcelReader("src\\test\\java\\testData\\myData.xlsx");
	String emailOrUsername = excelRead.getCellData("LoginInformation", "EmailOrUsername", 2);
	String userName = excelRead.getCellData("LoginInformation", "UserName", 2);
	String password = excelRead.getCellData("LoginInformation", "Password", 2);
	String dashboardHeaderText = excelRead.getCellData("ValidateHeaderText", "HeaderText", 2);
	
	String newCustomerHeaderText = excelRead.getCellData("ValidateHeaderText", "HeaderText", 3);
	String fullName = excelRead.getCellData("NewCustomerInfo", "FullName", 2);
	String companyName = excelRead.getCellData("NewCustomerInfo", "CompanyName", 2);
	String email = excelRead.getCellData("NewCustomerInfo", "Email", 2);
	String phone = excelRead.getCellData("NewCustomerInfo", "Phone", 2);
	String address = excelRead.getCellData("NewCustomerInfo", "Address", 2);
	String city = excelRead.getCellData("NewCustomerInfo", "City", 2);
	String zipCode = excelRead.getCellData("NewCustomerInfo", "ZipCode", 2);
	String country = excelRead.getCellData("NewCustomerInfo", "Country", 2);
	String group = excelRead.getCellData("NewCustomerInfo", "Group", 2);
	
	@Test
	public void userShuldBeAbleToAddNewCustomer() throws InterruptedException {
		
		driver = BrowserFactory.init();
		
		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		Thread.sleep(2000);
		takeScreenshot(driver);
		
		loginPage.insertUsername(userName);
		Thread.sleep(2000);
		
		loginPage.insertPassword(password);
		Thread.sleep(2000);
		
		loginPage.clickOnSinginButton();
		Thread.sleep(2000);

		DashboardPage dashboardPage = PageFactory.initElements(driver, DashboardPage.class);
		
		dashboardPage.validateDahsboardHeaderText(dashboardHeaderText);
		Thread.sleep(3000);
		takeScreenshot(driver);
		
		dashboardPage.clickOnCustomersMenu();
		Thread.sleep(2000);

		dashboardPage.clickOnAddCustomerMenu();
		Thread.sleep(2000);
		
		AddNewCustomerPage addNewCustomerPage = PageFactory.initElements(driver, AddNewCustomerPage.class);
		
		addNewCustomerPage.validateAddCustomerPage(newCustomerHeaderText);
		Thread.sleep(2000);
		takeScreenshot(driver);
		
		addNewCustomerPage.insertFullname(fullName);
		Thread.sleep(2000);	
		addNewCustomerPage.selectCompanyfromDropDown(companyName);
	
		addNewCustomerPage.insertEmail(email);
		
		addNewCustomerPage.insertPhone(phone);
		
		addNewCustomerPage.insertAddress(address);
		
		addNewCustomerPage.insertCity(city);
		
		addNewCustomerPage.insertZipCode(zipCode);
		
		addNewCustomerPage.selectCountryFromDropDown(country);
		
		addNewCustomerPage.selectGroupFromDropDown(group);
		
		addNewCustomerPage.clickOnSaveButton();
		
		addNewCustomerPage.validateInsertedCustomer();
		Thread.sleep(2000);
		takeScreenshot(driver);
		
		
		//BrowserFactory.tearDown();
	}
}
