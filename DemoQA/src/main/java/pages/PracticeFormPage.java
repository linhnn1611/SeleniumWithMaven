package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class PracticeFormPage extends Page {

	public PracticeFormPage(WebDriver dr) {
		super(dr);
	}

//	public By lbFirstName = By.id("firstName");
//	public By lbLastName = By.id("lastName");
//	public By lbEmail = By.id("userEmail");
//	public By lbMobile = By.xpath("//*[@id=\"userNumber\"]");
//	public By birthday = By.id("dateOfBirthInput");
//	public By lbCurrentAddress = By.id("currentAddress");

	public void inputData(String firstName, String lastName, String email, String phone,
			String currentAddress) {
		driver.findElement(By.id("firstName")).sendKeys(firstName);
		driver.findElement(By.id("lastName")).sendKeys(lastName);
		driver.findElement(By.id("userEmail")).sendKeys(email);
		driver.findElement(By.xpath("//input[@id='gender-radio-1']/..")).click();
		driver.findElement(By.xpath("//*[@id=\"userNumber\"]")).sendKeys(phone);
//		driver.findElement(By.id("subjectsContainer")).sendKeys();
//		driver.findElement(By.xpath("//input[@id='hobbies-checkbox-1']/..")).click();
		driver.findElement(By.id("currentAddress")).sendKeys(currentAddress);
//		driver.findElement(By.id("state")).isSelected();
//		driver.findElement(By.id("city")).isSelected();
	}

	/**
	 * 
	 * @param date: dd MMM yyyy
	 * @return 
	 */
	public void inputDate(String date) {
		String[] splittedDate = date.split(" ");
		driver.findElement(By.xpath("//input[@id='dateOfBirthInput']/..")).click();
		WebElement monthElement= driver.findElement(By.xpath("//div/div[1]/select"));
		Select month=new Select(monthElement);
		month.selectByVisibleText(splittedDate[1]);
		WebElement yearElement= driver.findElement(By.xpath("//div/div[1]/select"));
		Select year=new Select(yearElement);
		year.selectByVisibleText(splittedDate[2]);
		String day=splittedDate[0];
		String newDay ="";
		if(day.charAt(0)=='0') {
			newDay = day.replace("0", "");
		} else {
			newDay = day;
		}
		List<WebElement> dayList = driver.findElements(By.xpath("//div[@class='react-datepicker__week']/div"));
		int[] index = new int[2];
		int i =0;
		for (WebElement e: dayList)
		{
			if(e.getText().equals("1"))
			{
				index[i]= dayList.indexOf(e);
				i++;
			}
		}
		
		for (int k =index[0]; k< index[1]-1; k++) {
			if(dayList.get(k).getText().equals(newDay)) {
				dayList.get(k).click();
			}
			
		}
	}

//Zoomout page
	public void zoomout() {
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("document.body.style.zoom = '0.6'");
	}

	public void clickOnSubmit() {
		WebElement e = driver.findElement(By.id("submit"));
		e.submit();
	}
}
