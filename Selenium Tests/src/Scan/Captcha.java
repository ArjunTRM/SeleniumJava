package Scan;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Captcha {
	public static void main (String []args) throws InterruptedException{
		System.setProperty("webdriver.gecko.driver","D:/Selenium/geckodriver.exe");
		WebDriver driver = new FirefoxDriver();//creating driver object
		driver.get("https://www.irctc.co.in/nget/train-search");
		driver.findElement(By.xpath("//a[@id='loginText']")).click();
		
}
}

