package webDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class Hanling3 {
	public static void main (String []args) throws InterruptedException{
		System.setProperty("webdriver.gecko.driver","D:/Selenium/geckodriver.exe");
		WebDriver driver = new FirefoxDriver();//creating driver object
		driver.get("file:///C:/Users/ARJUN%20T%20R/Desktop/Selenium/Test%20Prgm/link.html");
		driver.findElement(By.xpath("//button[@onclick='myFunction()']")).click();
		
}
}
