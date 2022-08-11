package tests;

import org.testng.annotations.Test;
import static org.testng.Assert.assertTrue;
import pages.ElementsPage;
import pages.HomePage;
import pages.TextBoxPage;

public class TextBoxTest extends TestCase{
	// TestCase01
	@Test
		public void submitSuccessfully() {
			String userName = "Linh";
			String userEmail = "Linh@gmail.com";
			String currentAddress = "Ha Noi";
			String permanentAddress = "Viet Nam";
			
			HomePage homePage = new HomePage(testBase.driver);
			homePage.scroll();
			ElementsPage elementsPage = homePage.clickOnElements();
			TextBoxPage textBoxPage = elementsPage.clickOnTextBox();
			textBoxPage.inputData(userName, userEmail, currentAddress, permanentAddress);
			textBoxPage.clickOnSubmit();
			
			assertTrue(textBoxPage.verifyData(textBoxPage.lbNameElement, userName));
			assertTrue(textBoxPage.verifyData(textBoxPage.lbEmailElement, userEmail));
			assertTrue(textBoxPage.verifyData(textBoxPage.lbCurrentAddressElement, currentAddress));
			assertTrue(textBoxPage.verifyData(textBoxPage.lbPermanentAddressElement, permanentAddress));
		}
	//TestCase02	
	@Test
		public void verifyEmail()
		{
			String userName = "Linh";
			String userEmail = "Linhgmail.com";
			String currentAddress = "Ha Noi";
			String permanentAddress = "Viet Nam";

			HomePage homePage = new HomePage(testBase.driver);
			homePage.scroll();
			ElementsPage elementsPage = homePage.clickOnElements();
			TextBoxPage textBoxPage = elementsPage.clickOnTextBox();
			textBoxPage.inputData(userName, userEmail, currentAddress, permanentAddress);
			textBoxPage.clickOnSubmit();
			assertTrue(textBoxPage.verifyRedBorder(textBoxPage.lbEmailElement));
			
		}
}
