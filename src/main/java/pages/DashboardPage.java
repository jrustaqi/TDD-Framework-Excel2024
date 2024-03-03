package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Assert;

public class DashboardPage {

	WebDriver driver;
	
	public DashboardPage(WebDriver driver) {
		this.driver = driver;
	}
	
	@FindBy(how = How.XPATH, using = "//strong[contains(text(), 'Dashboard')]") WebElement DASHBOARD_HEADER_TEXT_ELEMENT;
	@FindBy(how = How.XPATH, using = "//em[@class = 'fa fa-fw fa-users']") WebElement CUSTOMERS_MENU_ELEMENT;
	@FindBy(how = How.XPATH, using = "//span[contains(text(), 'Add Customer')]") WebElement ADD_CUSTOMER_MENU_ELEMENT;
	
	public void validateDahsboardHeaderText(String validateDashboardHeaderText) {
		Assert.assertEquals(DASHBOARD_HEADER_TEXT_ELEMENT.getText(), validateDashboardHeaderText, "Dashborad Page is not available!!!");
	}
	
	public void clickOnCustomersMenu() {
		CUSTOMERS_MENU_ELEMENT.click();
	}
	
	public void clickOnAddCustomerMenu() {
		ADD_CUSTOMER_MENU_ELEMENT.click();
	}
	
	
	
	
	
	
	
}
