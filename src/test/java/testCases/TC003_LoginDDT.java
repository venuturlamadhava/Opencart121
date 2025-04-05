package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;
import utilities.DataProviders;


public class TC003_LoginDDT extends BaseClass{
	
	@Test(dataProvider = "LoginData", dataProviderClass = DataProviders.class,groups={"DataDriven","Master"})
	public void verify_LoginDDT(String email, String pwd,String exp){
	
	
	logger.info("***********login TC003_LoginDDT started***********" );
	try {
	HomePage hp=new HomePage(driver);
	logger.info("Clicking on 'My Account'");
	hp.clickMyAccount();
	logger.info("'My Account' clicked successfully");
	hp.clickLogin();
	
	
	//Login page
	LoginPage lp=new LoginPage(driver);
	lp.setEmail(email);
	lp.setPassword(pwd);
	lp.clickLogin();
	
	//MyAccount
	MyAccountPage macc=new MyAccountPage(driver);
	boolean targetPage=macc.isMyAccountPageExists();
	
	if(exp.equalsIgnoreCase("Valid"))
	{
		if(targetPage==true)
		{
			Assert.assertTrue(true);
			macc.clickLogout();
		}
		else
		{
			Assert.assertTrue(false);
		}
	}
	
	
	if(exp.equalsIgnoreCase("Invalid"))
	{
		if(targetPage==true)
		{
			Assert.assertTrue(false);
			macc.clickLogout();
		}
		else
		{
			Assert.assertTrue(true);
		}
	}
	}
	catch(Exception e)
	{
		Assert.fail();
	}
	

	logger.info("***********login TC003_LoginDDT ended***********" );
	
	}

	
}
