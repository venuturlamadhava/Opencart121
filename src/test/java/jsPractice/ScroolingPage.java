package jsPractice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ScroolingPage {

	public static void main(String[] args) {
		WebDriver driver=new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(6));
		
		driver.get("https://testautomationpractice.blogspot.com/");

		JavascriptExecutor js=(JavascriptExecutor)driver;
		
		//js.executeScript("window.scrollBy(0,3000)");
		//System.out.println(js.executeScript("return window.pageYOffset;"));
		
		//WebElement ele=driver.findElement(By.xpath("//label[normalize-space()='Gender:']"));
		//js.executeScript("arguments[0].scroolIntoView();", ele);
		//System.out.println(js.executeScript("return window.pageYOffset;"));
		
		js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
		js.executeScript("window.scrollBy(0,-document.body.scrollHeight)");
	}

}
