package testBase;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Properties;
import java.util.Date;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;




public class BaseClass 
{
public Logger logger;
public static WebDriver driver;
public Properties p;

	
	@BeforeClass(groups= {"Sanity","Regression","Master","DataDriven"})
	@Parameters({"OS","browser"})
	public void setup(String OS,String br) throws IOException
	{
		
		//loading config.propertiesfile
		FileReader file=new FileReader(".\\src\\test\\resources\\config.properties");
		p=new Properties();
		p.load(file);
		
		
		logger=LogManager.getLogger(this.getClass());
		
		
		switch(br.toLowerCase())
		{
		case "chrome" :driver=new ChromeDriver(); break;
		case "edge" :driver=new EdgeDriver(); break;
		case "firefox" :driver=new FirefoxDriver(); break;
		default: System.out.println("Invalid browser name...."); return;
		}
		
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get(p.getProperty("appURL"));
		driver.manage().window().maximize();
	}
	
	@AfterClass(groups= {"Sanity","Regression","Master","DataDriven"})
	public void tearDown()
	{
		driver.quit();
	}
	
	public String randomString()
	{
		String GeneratedString=RandomStringUtils.randomAlphabetic(5);
		return GeneratedString;
	}
	
	public String randomNUmber()
	{
		String GeneratedNum=RandomStringUtils.randomNumeric(10);
		return 	GeneratedNum;
	}
	
	public String randomAlphaNum()
	{
		String GeneratedNum=RandomStringUtils.randomNumeric(3);
		String GeneratedStr=RandomStringUtils.randomAlphabetic(3);
		return 	(GeneratedStr+"*"+GeneratedNum);
	}
	
	public String captureScreen(String tname) throws IOException
	{
		String timeStamp=new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
		
		TakesScreenshot takesScreenshot=(TakesScreenshot) driver;
		File sourceFile=takesScreenshot.getScreenshotAs(OutputType.FILE);
		
		String targetFilePath=System.getProperty("user.dir")+"\\screenshots\\"+tname+"_"+timeStamp+".png";
		File targetFile=new File(targetFilePath);
		
		sourceFile.renameTo(targetFile);
		
		return targetFilePath;
	}
}
