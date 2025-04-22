package jsPractice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class JavaScriptPractice {

	public static void main(String[] args) {
		WebDriver driver=new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3000));
		
		driver.get("https://testautomationpractice.blogspot.com/");
		
		WebElement SearchBox=driver.findElement(By.xpath("//input[@id='Wikipedia1_wikipedia-search-input']"));
	
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("arguments[0].setAttribute('value','john')", SearchBox);
		
		WebElement search=driver.findElement(By.xpath("//input[@type='submit']"));
		js.executeScript("arguments[0].click()", search);
		
		
		
		//driver.quit();
	}

}
