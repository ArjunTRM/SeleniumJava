package webDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Handling {
	public static void main(String [] args){
	System.setProperty("webdriver.gecko.driver","D:/Selenium/geckodriver.exe");
	 WebDriver driver = new FirefoxDriver();//launch firefox browser with blank url
	 driver.get("https://accounts.google.com/signin/v2/identifier?continue=https%3A%2F%2Fmail.google.com%2Fmail%2F&service=mail&sacu=1&rip=1&flowName=GlifWebSignIn&flowEntry=ServiceLogin");
	 driver.findElement(By.xpath("//div[@id='identifierNext']//content[@class='CwaK9']")).click();
	String s= driver.findElement(By.xpath("//div[@class='GQ8Pzc']")).getText();
	System.out.println(s);
}
}
