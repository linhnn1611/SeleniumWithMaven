package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PracticeFormPage extends Page {

	public PracticeFormPage(WebDriver dr) {
		super(dr);
	}

	public By lbFirstName = By.id("firstName");
	public By lbLastName = By.id("lastName");
	public By lbEmail = By.id("userEmail");
	public By lbMobile = By.xpath("//*[@id=\"userNumber\"]");
	public By birthday = By.id("dateOfBirthInput");
	public By lbCurrentAddress = By.id("currentAddress");

	public void inputData(String firstName, String lastName, String email, String phone, String currentAddress) {
		driver.findElement(By.id("firstName")).sendKeys(firstName);
		driver.findElement(By.id("lastName")).sendKeys(lastName);
		driver.findElement(By.id("userEmail")).sendKeys(email);
//		driver.findElement(By.name("gender")).isSelected();
		driver.findElement(By.xpath("//*[@id=\"userNumber\"]")).sendKeys(phone);
//		driver.findElement(By.id("dateOfBirthInput")).isSelected();
//		driver.findElement(By.id("subjectsContainer")).sendKeys();
//		driver.findElement(By.id("hobbiesWrapper")).isSelected();
		driver.findElement(By.id("currentAddress")).sendKeys(currentAddress);
//		driver.findElement(By.id("state")).isSelected();
//		driver.findElement(By.id("city")).isSelected();
	}

//Zoomout page
	public void zoomout() {
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("document.body.style.zoom = '0.4'");
	}

	public void clickOnSubmit() {
		driver.findElement(By.id("submit")).click();
	}
}
