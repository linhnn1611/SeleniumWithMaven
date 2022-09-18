package tests;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pages.WebTablePage;

public class WebTableTest extends TestCase {
//	@Test
	public void searchByFirstNameSuccessfully() {
		String searchKeyWord = "Cie";
		WebTablePage webTablePage = new WebTablePage(testBase.driver);
		webTablePage.navigateTo("https://demoqa.com/webtables");
		webTablePage.inputSearchKeyWord(searchKeyWord);
		assertTrue(webTablePage.verifySearchResults(searchKeyWord, "First Name"));
	}
//	@Test
	public void searchLastNameSucessfully() {
		String searchKeyWordLastName = "Ve";
		WebTablePage webTablePage = new WebTablePage(testBase.driver);
		webTablePage.navigateTo("https://demoqa.com/webtables");
		webTablePage.inputSearchKeyWord(searchKeyWordLastName);
		assertTrue(webTablePage.verifySearchResults(searchKeyWordLastName, "Last Name"));
	}
	@Test(dataProvider="RegistrationData")
	public void verifyTextAfterSubmit(String firstName, String lastName, String email, String age, String salary, String department) {
		WebTablePage webTablePage = new WebTablePage(testBase.driver);
		webTablePage.navigateTo("https://demoqa.com/webtables");
		webTablePage.clickonAdd();
		webTablePage.inputDataRegistrationForm(firstName, lastName, email, age, salary, department);
		assertEquals(webTablePage.getRegistration(firstName).getFirstName(), firstName);
		assertEquals(webTablePage.getRegistration(firstName).getLastName(), lastName);
		assertEquals(webTablePage.getRegistration(firstName).getAge(), age);
		assertEquals(webTablePage.getRegistration(firstName).getEmail(), email);
		assertEquals(webTablePage.getRegistration(firstName).getSalary(), salary);
		assertEquals(webTablePage.getRegistration(firstName).getDepartment(), department);
		
		webTablePage.inputSearchKeyWord(firstName);
		webTablePage.deletedDataByKeyWord();
//		webTablePage.verifyDataAfterSubmit(webTablePage.firstName, firstName);
//		webTablePage.verifyDataAfterSubmit(webTablePage.lastName, lastName);
//		webTablePage.verifyDataAfterSubmit(webTablePage.Email, email);
//		webTablePage.verifyDataAfterSubmit(webTablePage.age, age);
//		webTablePage.verifyDataAfterSubmit(webTablePage.Salary, salary);
//		webTablePage.verifyDataAfterSubmit(webTablePage.Department, department);
	}
	// tach data ra khoi testcase
	@DataProvider (name="RegistrationData")
	public Object[][] createRegistrationData (){
		Object [][] registrationData=new Object[1][6];
		registrationData[0][0]= "Lonh";
		registrationData[0][1]= "Hoa";
		registrationData[0][2]= "linh@gmail.com";
		registrationData[0][3]= "20";
		registrationData[0][4]= "2000";
		registrationData[0][5]= "bonee";
		return registrationData;
	}
	

}