package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;
import utilities.DataProviders;

public class TC003_LoginDDT extends BaseClass {
	@Test(dataProvider="LoginData", dataProviderClass=DataProviders.class,groups="datadriven")
	//getting DataProvider from different class. so, we need DataProider.class Parameter

	public void verify_LoginDDt(String email, String pwd, String exp)
	{
		//HomePage
		logger.info("*********Started Tc_003_LoginDDT *****");
		try
		{;
		HomePage hp= new HomePage(driver);
		hp.clickMyAccount();
		hp.clickLogin();

		//Login
		LoginPage lp= new LoginPage(driver);
		lp.setEmail(email);
		lp.setPassword(pwd);		
		lp.clickLogin();

		//MYAccount
		MyAccountPage macc=new MyAccountPage(driver);
		boolean targetPage=macc.isMyAccountPageExists();


		/*Data is valid - login success - test pass - logout
		 *              - login failed - test fail 
		 * 
		 * Data is invalid - login success - test fail - logout
		 *                 - login failed - test pass - 
		 */

		if(exp.equalsIgnoreCase("Valid"))
		{

			if(targetPage==true)
			{
				macc.clickLogout();
				Assert.assertTrue(true);
			}
			else
			{

				Assert.assertTrue(false);
			}}
		if(exp.equalsIgnoreCase("Invalid"))
		{

			if(targetPage==true)
			{
				macc.clickLogout();
				Assert.assertTrue(false);
			}
			else
			{

				Assert.assertTrue(true);
			}
		}

		}catch(Exception e)
		{

			Assert.fail();
		}

		logger.info("*******Finished TC_003_LoginDDT******");

	}
}








