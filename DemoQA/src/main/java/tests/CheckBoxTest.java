package tests;

import static org.testng.Assert.assertEquals;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.CheckBoxPage;
import pages.ElementsPage;
import pages.HomePage;

public class CheckBoxTest extends TestCase{
//	@Test
	public void verifyCheckBox()
	{
		String expectedResult="You have selected : home desktop notes commands documents workspace react angular veu office public private classified general downloads wordFile excelFile";
		HomePage homePage = new HomePage(testBase.driver);
		homePage.scroll();
		ElementsPage elementsPage = homePage.clickOnElements();
		CheckBoxPage checkBoxPage=elementsPage.clickOnCheckBox();
		checkBoxPage.clickHome();
		Assert.assertEquals(checkBoxPage.getText(), expectedResult);
//		checkBoxPage.verifyText(checkBoxPage.text, b);
	}
//TC CheckAll
	@Test
	public void verifyCheckAll()
	{
		HomePage homePage = new HomePage(testBase.driver);
		homePage.scroll();
		ElementsPage elementsPage = homePage.clickOnElements();
		CheckBoxPage checkBoxPage=elementsPage.clickOnCheckBox();
		checkBoxPage.clickHome();
		checkBoxPage.clickAll();
		
		checkBoxPage.verifyCheckAll(checkBoxPage.lbDesktopElement);
		checkBoxPage.verifyCheckAll(checkBoxPage.lbDocumentsElement);
		checkBoxPage.verifyCheckAll(checkBoxPage.lbDownloadsElement);
	}

}
