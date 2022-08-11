package tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import common.TestBase;

public class TestCase {
	public TestBase testBase = new TestBase(); // khoi tao bien global de o ngoai

	@BeforeMethod
	public void openBrowser() 
	{
		testBase.openBrowser(); // goi den ham openBrowser
	}
//	@AfterMethod
	public void closeBrowser()
	{
		testBase.driver.quit();
	}
}
