package webDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ElementLocators {
	 public static void main (String []args)
	 {

		 //Creating firefox driver object in webDriver interface
		 System.setProperty("webdriver.gecko.driver","D:/Selenium/geckodriver.exe");
		 WebDriver driver = new FirefoxDriver();//launch firefox browser with blank url
		 driver.get("https://www.google.com/");
		 driver.findElement(By.xpath("Gma")).click();
		// Email.click();
		// Email.sendKeys("London");
		
	 }
}

