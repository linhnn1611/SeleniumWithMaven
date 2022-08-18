package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;


public class HomePage  extends Page{
	public HomePage(WebDriver dr) {
		super(dr);
		
	}
	public void scroll()
	{
		JavascriptExecutor jse6 = (JavascriptExecutor) driver;
		jse6.executeScript("window.scrollBy(0,250)", "");
	}
	public ElementsPage clickOnElements()
	{
		driver.findElement(By.xpath("//h5[text()='Elements']")).click();
		return new ElementsPage(driver);
		
	}
	public FormsPage clickOnForm()
	{
		driver.findElement(By.xpath("//h5[text()='Forms']")).click();
		return new FormsPage(driver);
	}
}
