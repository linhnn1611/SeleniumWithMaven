package tests;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import junit.framework.Assert;
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
		String dateOfBirth= "16 November 2022";
		String currentAddress= "HaNoi";
		String subject="Maths";
		String gender="Female";
		String state="NCR";
		String city="Delhi";
		String hobbies="Sports";
		
		HomePage homePage = new HomePage(testBase.driver);
		homePage.scroll();
		FormsPage formsPage=homePage.clickOnForm();
		PracticeFormPage practiceFormsPage=formsPage.clickOnPracticeForm();
		practiceFormsPage.inputData(firstName, lastName, userEmail, userNumber, currentAddress, gender, hobbies);
//		practiceFormsPage.inputDate(dateOfBirth);
		practiceFormsPage.selectSubject(subject);
		practiceFormsPage.selectStateAndCity(state, city);
		homePage.scroll();
		practiceFormsPage.clickOnSubmit();
		Assert.assertEquals(practiceFormsPage.getDataSubmit(practiceFormsPage.lbStudentName),firstName+" "+lastName);
		Assert.assertEquals(practiceFormsPage.getDataSubmit(practiceFormsPage.lbStudentEmail),userEmail);
		Assert.assertEquals(practiceFormsPage.getDataSubmit(practiceFormsPage.lbGender),gender);
		Assert.assertEquals(practiceFormsPage.getDataSubmit(practiceFormsPage.lbMobile),userNumber);
//		Assert.assertEquals(practiceFormsPage.getDataInThankForFormAfterSubmit(practiceFormsPage.lbDateofBirth),dateOfBirth);
		Assert.assertEquals(practiceFormsPage.getDataSubmit(practiceFormsPage.lbSubjects),subject);
		Assert.assertEquals(practiceFormsPage.getDataSubmit(practiceFormsPage.lbHobbies),hobbies);
//		Assert.assertEquals(practiceFormsPage.getDataInThankForFormAfterSubmit(practiceFormsPage.lbPicture),);
		Assert.assertEquals(practiceFormsPage.getDataSubmit(practiceFormsPage.lbAddress),currentAddress);
		Assert.assertEquals(practiceFormsPage.getDataSubmit(practiceFormsPage.lbStateandCity),state +" "+city);
		

	}
}
