package jsPractice;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ZoomInZoomOut {

	public static void main(String[] args) {
WebDriver driver=new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(6));
		driver.get("https://testautomationpractice.blogspot.com/");

		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("document.body.style.zoom='50%'");
	}

}
