package common;

import org.openqa.selenium.chrome.ChromeDriver;

public class TestBase {
	public ChromeDriver driver;
	public void openBrowser()
	{
		System.setProperty("webdriver.chrome.driver", "/Users/nguyennhatlinh/Downloads/06_AutoationProject/01Tools/chromedriver");
		driver =new ChromeDriver();
		//get link
		driver.get("https://demoqa.com/");
		//mo rong kich thuoc trinh duyet
		driver.manage().window().maximize();
		
	}
}
