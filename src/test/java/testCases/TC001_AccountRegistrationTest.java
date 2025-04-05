package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC001_AccountRegistrationTest extends BaseClass
{

	@Test(groups={"Regression","Master"})
	public void verify_account_registration() 
	{
		try {
		logger.info("**** Starting of TC001_AccountRegistrationTest***" );
		HomePage hp=new HomePage(driver);
		hp.clickMyAccount();
		logger.info("Clicked on MyAccount");
		hp.clickRegister();
		logger.info("Clicked on register");
		
		AccountRegistrationPage regpage=new AccountRegistrationPage(driver);
		logger.info("Providing customer details");
		regpage.setFirstName(randomString().toUpperCase());
		regpage.setLastName(randomString().toUpperCase());
		regpage.setEmail(randomString()+"@gmail.com");
		regpage.setTelephone(randomNUmber());
		
		String password=randomAlphaNum();
		
		regpage.setPassword(password);
		regpage.setConPassword(password);
		
		regpage.setPolicyChk();
		regpage.clikBtn();
		
		logger.info("Validation expected message");
		String confmsg=regpage.getConfirmationMsg();
		Assert.assertEquals(confmsg, "Your Account Has Been Created!");
		}
		catch(Exception e)
		{
			logger.error("Test failed");
		}
		logger.info("*********Test completed**********");
	}
		
}
