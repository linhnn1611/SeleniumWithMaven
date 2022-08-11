package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckBoxPage extends Page {
	public CheckBoxPage(WebDriver dr) {
		super(dr);
	}
	public By lbDesktopElement = By.xpath("//span[contains(text(),'Desktop')]");
	public By lbDocumentsElement = By.xpath("//span[contains(text(),'Documents')]");
	public By lbDownloadsElement = By.xpath("//span[contains(text(),'Downloads')]");
	public By text;
	public void getText()
	{
		String a1=driver.findElement(By.xpath("//span[contains(text(),'You have selected :')]")).getText();
		String a2=driver.findElement(By.xpath("//span[contains(text(),'home')]")).getText();
		String a3=driver.findElement(By.xpath("//span[contains(text(),'desktop')]")).getText();
		String a4=driver.findElement(By.xpath("//span[contains(text(),'notes')]")).getText();
		String a5=driver.findElement(By.xpath("//span[contains(text(),'commands')]")).getText();
		String a6=driver.findElement(By.xpath("//span[contains(text(),'documents')]")).getText();
		String a7=driver.findElement(By.xpath("//span[contains(text(),'workspace')]")).getText();
		String a8=driver.findElement(By.xpath("//span[contains(text(),'react')]")).getText();
		String a9=driver.findElement(By.xpath("//span[contains(text(),'angular')]")).getText();
		String a10=driver.findElement(By.xpath("//span[contains(text(),'veu')]")).getText();
		String a11=driver.findElement(By.xpath("//span[contains(text(),'office')]")).getText();
		String a12=driver.findElement(By.xpath("//span[contains(text(),'public')]")).getText();
		String a13=driver.findElement(By.xpath("//span[contains(text(),'private')]")).getText();
		String a14=driver.findElement(By.xpath("//span[contains(text(),'classified')]")).getText();
		String a15=driver.findElement(By.xpath("//span[contains(text(),'general')]")).getText();
		String a16=driver.findElement(By.xpath("//span[contains(text(),'downloads')]")).getText();
		String a17=driver.findElement(By.xpath("//span[contains(text(),'wordFile')]")).getText();
		String a18=driver.findElement(By.xpath("//span[contains(text(),'excelFile')]")).getText();
		String text=a1.concat(" ").concat(a2).concat(" ").concat(a3).concat(" ").concat(a4).concat(" ").concat(a5).concat(" ").concat(a6).concat(" ").concat(a7).concat(" ").concat(a8).concat(" ").concat(a9).concat(" ").concat(a10).concat(" ").concat(a11).concat(" ").concat(a12).concat(" ").concat(a13).concat(" ").concat(a14).concat(" ").concat(a15).concat(" ").concat(a16).concat(" ").concat(a17).concat(" ").concat(a18);
	}

	public void clickHome() {
		driver.findElement(By.xpath("//body/div[@id='app']/div[1]/div[1]/div[2]/div[2]/div[2]/div[1]/ol[1]/li[1]/span[1]/label[1]/span[1]/*[1]")).click();
	}

	public boolean verifyText(By locator, String expectedData) {
		boolean result = false;
		String actualData = driver.findElement(text).getText();
		if (actualData.equals(expectedData)) {
			result = true;
		}
		return result;

	}
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
