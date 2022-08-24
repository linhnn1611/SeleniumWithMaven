package pages;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;


public class Page {
	public WebDriver driver;
	public Page(WebDriver dr) {
		this.driver = dr;
	}
	public void setWindow () {
		Dimension dm= new Dimension(700,1000);
		driver.manage().window().setSize(dm);
	}
}
