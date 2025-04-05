package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;

public class TC002_LoginTest extends BaseClass
{
	@Test(groups={"Sanity","Master"})
	public void verify_login()
	{
		
		logger.info("*********** Starting TC_002_LoginTest*********");
		try {
		//Home page
		
		HomePage hp=new HomePage(driver);
		hp.clickMyAccount();
		hp.clickLogin();
		
		
		//Login page
		LoginPage lp=new LoginPage(driver);
		lp.setEmail(p.getProperty("email"));
		lp.setPassword(p.getProperty("password"));
		lp.clickLogin();
		
		//MyAccount
		MyAccountPage macc=new MyAccountPage(driver);
		
		boolean trargetPage=macc.isMyAccountPageExists();
		
		Assert.assertTrue(trargetPage);
	}
	catch(Exception e)
	{
		Assert.fail();
	}
		logger.info("****Finished TC_002_LoginTest");
		
	}
	
}

