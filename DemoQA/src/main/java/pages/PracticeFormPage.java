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

	public String genderXpath = "//*[text()='{@param}']/..";
	public String hobbiesXpath = "//*[text()='{@param}']/..";
//Thanks Form
	public By lbStudentName = By.xpath("//td[text()='Student Name']/following-sibling::td");
	public By lbStudentEmail = By.xpath("//td[text()='Student Email']/following-sibling::td");
	public By lbGender = By.xpath("//td[text()='Gender']/following-sibling::td");
	public By lbMobile = By.xpath("//td[text()='Mobile']/following-sibling::td");
	public By lbDateofBirth = By.xpath("//td[text()='Date of Birth']/following-sibling::td");
	public By lbSubjects = By.xpath("//td[text()='Subjects']/following-sibling::td");
	public By lbHobbies = By.xpath("//td[text()='Hobbies']/following-sibling::td");
	public By lbPicture = By.xpath("//td[text()='Picture']/following-sibling::td");
	public By lbAddress = By.xpath("//td[text()='Address']/following-sibling::td");
	public By lbStateandCity = By.xpath("//td[text()='State and City']/following-sibling::td");

	public void inputData(String firstName, String lastName, String email, String phone, String currentAddress,
			String gender, String hobbies) {
		driver.findElement(By.id("firstName")).sendKeys(firstName);
		driver.findElement(By.id("lastName")).sendKeys(lastName);
		driver.findElement(By.id("userEmail")).sendKeys(email);
		// driver.findElement(createXpathByText(genderXpath, gender)).click();
		driver.findElement(By.xpath("//input[@id='gender-radio-1']/..")).click();
		driver.findElement(By.xpath("//*[@id=\"userNumber\"]")).sendKeys(phone);
		driver.findElement(createXpathByText(hobbiesXpath, hobbies)).click();
		setWindow();
		driver.findElement(By.xpath("//input[@type='file']")).sendKeys("/Users/nguyennhatlinh/Downloads/IMG_1388.JPG");
		driver.findElement(By.id("currentAddress")).sendKeys(currentAddress);
	}

	/**
	 * 
	 * @param date: dd MMM yyyy
	 * @return
	 */
	public void inputDate(String date) {
		String[] splittedDate = date.split(" ");
		driver.findElement(By.xpath("//input[@id='dateOfBirthInput']/..")).click();
		WebElement monthElement = driver.findElement(By.xpath("//div/div[1]/select"));
		Select month = new Select(monthElement);
		month.selectByVisibleText(splittedDate[1]);
		WebElement yearElement = driver.findElement(By.xpath("//div/div[2]/select"));
		Select year = new Select(yearElement);
		year.selectByValue(splittedDate[2]);
		String day = splittedDate[0];
		String newDay = "";
		if (day.charAt(0) == '0') {
			newDay = day.replace("0", "");
		} else {
			newDay = day;
		}
		List<WebElement> dayList = driver.findElements(By.xpath("//div[@class='react-datepicker__week']/div"));
		int[] index = new int[2];
		int i = 0;
		for (WebElement e : dayList) {
			if (e.getText().equals("1")) {
				index[i] = dayList.indexOf(e);
				i++;
			}
		}

		for (int k = index[0]; k < index[1] - 1; k++) {
			if (dayList.get(k).getText().equals(newDay)) {
				dayList.get(k).click();
			}
		}
	}

	public void inputDate2(String date) {
		String[] splittedDate = date.split(" ");
		driver.findElement(By.xpath("//input[@id='dateOfBirthInput']/..")).click();
		WebElement monthElement = driver.findElement(By.xpath("//div/div[1]/select"));
		Select month = new Select(monthElement);
		month.selectByVisibleText(splittedDate[1]);
		WebElement yearElement = driver.findElement(By.xpath("//div/div[1]/select"));
		Select year = new Select(yearElement);
		year.selectByVisibleText(splittedDate[2]);
		String day = splittedDate[0];
		String newDay = "";
		if (day.charAt(0) == '0') {
			newDay = day.replace("0", "");
		} else {
			newDay = day;
		}
		String xpathDay = String.format("(//div[@class='react-datepicker__week']/div[text()='%s'])[1]", newDay);
		WebElement dayElement = driver.findElement(By.xpath(xpathDay));
		dayElement.click();
	}

	public void selectSubject(String subject) {
		driver.findElement(By.xpath("//input[@id='subjectsInput']")).sendKeys(subject);
		driver.findElement(By.xpath("//input[@id='subjectsInput']")).sendKeys(Keys.ENTER);
	}

	public void selectStateAndCity(String state, String city) {
		driver.findElement(By.xpath("//input[@id='react-select-3-input']")).sendKeys(state);
		driver.findElement(By.xpath("//input[@id='react-select-3-input']")).sendKeys(Keys.ENTER);
		driver.findElement(By.xpath("//input[@id='react-select-4-input']")).sendKeys(city);
		driver.findElement(By.xpath("//input[@id='react-select-4-input']")).sendKeys(Keys.ENTER);
	}

//Zoomout page
//	public void zoomout() {
//		JavascriptExecutor executor = (JavascriptExecutor) driver;
//		executor.executeScript("document.body.style.zoom = '0.7'");
//	}

	public void clickOnSubmit() {
		WebElement e = driver.findElement(By.id("submit"));
		e.submit();
	}

	public String getDataSubmit(By locator) {
		return driver.findElement(locator).getText();
	}

//	public boolean getDataSubmit(By locator, String expectedData) {
//		boolean result = false;
//		String actualData = driver.findElement(locator).getText();
//		if (actualData.equals(expectedData)) {
//			result = true;
//		}
//		return result;
//	}
	public By createXpathByText(String locatorXpath, String text) {
		String elementXpath = locatorXpath.replace("{@param}", text);
		return By.xpath(elementXpath);
	}

}
