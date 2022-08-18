package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ElementsPage extends Page {
	public ElementsPage(WebDriver dr) {
		super(dr);
	}

	public TextBoxPage clickOnTextBox() 
	{
		driver.findElement(By.xpath("//span[text() ='Text Box']")).click();
		return new TextBoxPage(driver);
	}
	public CheckBoxPage clickOnCheckBox() 
	{
		driver.findElement(By.xpath("//span[text() ='Check Box']")).click();
		return new CheckBoxPage(driver);
	}
}
