package tests;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import pages.FormsPage;
import pages.HomePage;
import pages.PracticeFormPage;

public class PracticeFormTest extends TestCase {

//TC 04
	@Test
	public void submitPractice() {
		String firstName= "Linh";
		String lastName= "Nhat";
		String userEmail= "linh@gmail.com";
		String userNumber= "0962742580";
		String dateOfBirth= "16 Nov 1996";
		String currentAddress= "HaNoi";
		
		HomePage homePage = new HomePage(testBase.driver);
		homePage.scroll();
		FormsPage formsPage=homePage.clickOnForm();
		PracticeFormPage practiceFormsPage=formsPage.clickOnPracticeForm();
		practiceFormsPage.zoomout();
		practiceFormsPage.inputData(firstName, lastName, userEmail, userNumber, currentAddress);
		practiceFormsPage.inputDate(dateOfBirth);
		practiceFormsPage.clickOnSubmit();
		

	}
}
