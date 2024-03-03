package pages;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class BasePage {

	public int generateRandomNumber(int boundryNumber) {
		Random random = new Random();
		int generatedNum = random.nextInt(boundryNumber);
		return generatedNum;
	}

	public void selectFromDropdown(WebElement element, String visibleText) {
		Select select = new Select(element);
		select.selectByVisibleText(visibleText);

	}

	public void clickOnButton(WebElement element) {
		try {
			element.click();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void takeScreenshot(WebDriver driver) {
		TakesScreenshot ts = (TakesScreenshot) driver; // it called type casting //1
		File sourceFile = ts.getScreenshotAs(OutputType.FILE); // 2

		String currentDirectory = System.getProperty("user.dir"); // 3
		SimpleDateFormat formatter = new SimpleDateFormat("MMddyy_HHmmss"); // 5
		Date date = new Date(); // 6
		String label = formatter.format(date); // 7

		try {
			FileUtils.copyFile(sourceFile, new File(currentDirectory + "/screenshot/" + label + ".png")); // 4
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
