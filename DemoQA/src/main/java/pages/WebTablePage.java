package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class WebTablePage extends Page {
	public WebTablePage(WebDriver dr) {
		super(dr);
	}

	public By firstName = By.xpath("(//div[@class='rt-tbody']//div[@role='row'])[1]/div[1]");
	public By lastName = By.xpath("(//div[@class='rt-tbody']//div[@role='row'])[1]/div[2]");
	public By age = By.xpath("(//div[@class='rt-tbody']//div[@role='row'])[1]/div[2]");
	public By email = By.xpath("(//div[@class='rt-tbody']//div[@role='row'])[1]/div[2]");
	public By salary = By.xpath("(//div[@class='rt-tbody']//div[@role='row'])[1]/div[2]");
	public By department = By.xpath("(//div[@class='rt-tbody']//div[@role='row'])[1]/div[2]");

	public void inputSearchKeyWord(String searchKeyWord) {
		driver.findElement(By.id("searchBox")).sendKeys(searchKeyWord);
	}

	public boolean verifySearchResults(String keyword, String fieldName) {
		boolean result = true;
		List<WebElement> elementList = driver.findElements(getXpathByTableHeader(fieldName));
		for (WebElement e : elementList) {
			if (!e.getText().contains(keyword))// neu khong thoa man la false
				result = false;
		}
		return result;
		//// *[@role='row']/div[1]
		// lay dong //*[text()='First
		//// Name']/../../../following-sibling::div//div[@role='row']/div[1]
	}

	By getXpathByTableHeader(String fieldName) {
		By result = null;
		switch (fieldName) {
		case "First Name": {
			result = By.xpath("//*[@role='row']/div[1]");
			break;
		}

		case "Last Name": {
			result = By.xpath("//*[@role='row']/div[2]");
			break;
		}
		case "Age": {
			result = By.xpath("//*[@role='row']/div[3]");
			break;
		}
		case "Email": {
			result = By.xpath("//*[@role='row']/div[4]");
			break;
		}
		case "Salary": {
			result = By.xpath("//*[@role='row']/div[5]");
			break;
		}
		case "Department": {
			result = By.xpath("//*[@role='row']/div[6]");
			break;
		}
		default:
			System.out.println("truyen sai field name");

		}
		return result;
	}

	public void clickonAdd() {
		driver.findElement(By.xpath("//button[@id='addNewRecordButton']")).click();
	}

	public void inputDataRegistrationForm(String firstName, String lastName, String email, String age, String salary,
			String department) {
		driver.findElement(By.id("firstName")).sendKeys(firstName);
		driver.findElement(By.id("lastName")).sendKeys(lastName);
		driver.findElement(By.id("userEmail")).sendKeys(email);
		driver.findElement(By.id("age")).sendKeys(age);
		driver.findElement(By.id("salary")).sendKeys(salary);
		driver.findElement(By.id("department")).sendKeys(department);
		driver.findElement(By.id("submit")).click();
	}

	public boolean verifyDataAfterSubmit(By locator, String expectedData) {
		boolean result = false;
		String actualData = driver.findElement(locator).getText();
		if (actualData.equals(expectedData)) {
			return true;
		}
		return result;
	}

	public RegistrationEntity getRegistration(String searchKeyword) {
		RegistrationEntity registration = new RegistrationEntity();
		List<WebElement> firstRowElements = driver
				.findElements(By.xpath("//*[@role='grid']/div[2]/div[1]//div[@role='gridcell']"));
		registration.setFirstName(firstRowElements.get(0).getText());
		registration.setLastName(firstRowElements.get(1).getText());
		registration.setEmail(firstRowElements.get(2).getText());
		registration.setAge(firstRowElements.get(3).getText());
		registration.setSalary(firstRowElements.get(4).getText());
		registration.setDepartment(firstRowElements.get(5).getText());
		return registration;
	}

	public void deletedDataByKeyWord() {
		List<WebElement> deleteElements = driver.findElements(By.xpath("//span[@title='Delete']"));
		if (deleteElements.size() != 0) {
			for (WebElement e : deleteElements) {
				e.click();
			}
		}
	}

}
