package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FormsPage extends Page{
	public FormsPage(WebDriver dr) {
		super(dr);
	}
	
	public PracticeFormPage clickOnPracticeForm()
	{
		driver.findElement(By.xpath("//span[text() ='Practice Form']")).click();
		return new PracticeFormPage(driver);
	}

}
