package webDriver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class New {
	 public static void main (String []args)
	 {

		 //Creating firefox driver object in webDriver interface
		 System.setProperty("webdriver.gecko.driver","D:/Selenium/geckodriver.exe");
		 WebDriver driver = new FirefoxDriver();//launch firefox browser with blank url
		 
}
}

