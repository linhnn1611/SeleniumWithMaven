package tests;

import pages.CheckBoxPage;
import pages.ElementsPage;
import pages.HomePage;

public class CheckBoxTest extends TestCase{
	public void verifyCheckBox()
	{
		String b="You have selected : home desktop notes commands documents workspace react angular veu office public private classified general downloads wordFile excelFile";
		HomePage homePage = new HomePage(testBase.driver);
		homePage.scroll();
		ElementsPage elementsPage = homePage.clickOnElements();
		CheckBoxPage checkBoxPage=elementsPage.clickOnCheckBox();
		checkBoxPage.clickHome();
		checkBoxPage.verifyText(checkBoxPage.text, b);
	}
//TC CheckAll	
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
