package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CheckBoxPage extends Page {
	public CheckBoxPage(WebDriver dr) {
		super(dr);
	}
	public By lbDesktopElement = By.xpath("//span[contains(text(),'Desktop')]");
	public By lbDocumentsElement = By.xpath("//span[contains(text(),'Documents')]");
	public By lbDownloadsElement = By.xpath("//span[contains(text(),'Downloads')]");
	public By text;
	public String getText()
	{
		String actualResult ="";
		List<WebElement> spanElements = driver.findElements(By.xpath("//*[@id='result']/span"));
		for (WebElement e:spanElements) {
			actualResult = actualResult + " " + e.getText();
		} return actualResult;
		
	}

	public void clickHome() {
		driver.findElement(By.xpath("//body/div[@id='app']/div[1]/div[1]/div[2]/div[2]/div[2]/div[1]/ol[1]/li[1]/span[1]/label[1]/span[1]/*[1]")).click();
	}

//	public boolean verifyText(By locator, String expectedData) {
//		boolean result = false;
//		String actualData = driver.findElement(text).getText();
//		if (actualData.equals(expectedData)) {
//			result = true;
//		}
//		return result;
//
//	}
	public void clickAll()
	{
		driver.findElement(By.xpath("//body/div[@id='app']/div[1]/div[1]/div[2]/div[2]/div[2]/div[1]/ol[1]/li[1]/span[1]/button[1]/*[1]")).click();
	}
	public boolean verifyCheckAll(By locator)
	{
		boolean result=false;
		String css=driver.findElement(locator).getCssValue("rct-icon rct-icon-uncheck");
		if(css!="")
			result=true;
		return result;
	}
}
