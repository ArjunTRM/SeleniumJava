
	package Shopping;

	import java.io.File;
	import java.io.IOException;

	import org.openqa.selenium.By;
	import org.openqa.selenium.NoSuchElementException;
	import org.openqa.selenium.OutputType;
	import org.openqa.selenium.TakesScreenshot;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.firefox.FirefoxDriver;
	import org.openqa.selenium.interactions.Actions;
	import org.openqa.selenium.support.ui.Select;
	import com.google.common.io.Files;
	import org.testng.annotations.Test;

	public class Flipkart {
		public static  WebDriver driver;
		@Test(priority =1)
	public void openunsignedflip() {
		System.setProperty("webdriver.gecko.driver","D:/Selenium/geckodriver.exe");
		driver = new FirefoxDriver(); 
		driver.get("https://www.flipkart.com/");//launch flipkart shopping site
		driver.findElement(By.xpath("//button[@class='_2AkmmA _29YdH8']")).click();	//Close Login pop-up
			System.out.println("a) Lauched Filpkart in Un-Singed state");
	}
		@Test(priority =2)
		public void chooseoppo() throws InterruptedException {
			//Handling Electronics Hover 
					Actions action=new Actions(driver);
					WebElement Menu= driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[2]/div[1]/ul[1]/li[1]/span[1]")); 
					action.moveToElement(Menu).build().perform(); 
					Thread.sleep(1000);
					//Selecting Oppo from Electronics menu
					driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[2]/div[1]/ul[1]/li[1]/ul[1]/li[1]/ul[1]/li[1]/ul[1]/li[6]/a[1]")).click();
						System.out.println("b) Selected Oppo from Electronics Menu");
					Thread.sleep(1000);
					//Selecting OPPO A3s (Purple, 16 GB), Handling new tab and adding into cart
					String ParentWindowHandle =driver.getWindowHandle();
					driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[3]/div[3]/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/div[1]/a[1]")).click();
						System.out.println("c) Selected item with name OPPO A3s (Purple, 16 GB)");
					Thread.sleep(1000);
					System.out.println("Parent Tab: "+driver.getTitle());
					//Switching New tab loop
					for(String ChildTab:driver.getWindowHandles()) {
						 driver.switchTo().window(ChildTab);
					}
					
					Thread.sleep(1000);
					driver.findElement(By.xpath("//button[@class='_2AkmmA _2Npkh4 _2MWPVK']")).click();
					System.out.println("d) Added Successfully into Cart");
					//Back to flipkart Home screen
					Thread.sleep(1000);
					driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/a[1]/img[1]")).click();
					System.out.println("e) Navigated back to Home Screen of Flipkart");
					Thread.sleep(2000);
					try {
						boolean popup = driver.findElement(By.xpath("//button[@class='_2AkmmA _29YdH8']")).isDisplayed();
						if (popup) {
							driver.findElement(By.xpath("//button[@class='_2AkmmA _29YdH8']")).click();	
						}
					}
					catch(NoSuchElementException refresh) {
						Thread.sleep(2000);
						driver.navigate().refresh();
					}
					driver.navigate().refresh();	
		}
		@Test(priority =3)
		public void checkKart() throws InterruptedException, IOException {
			driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[5]/a[1]/span[1]")).click();
			Thread.sleep(2000);
			//Checking and Verifying cart
			boolean image=driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[3]/form[1]/button[1]")).isDisplayed();
			if(image ==true) {
				System.out.println("f) Passed-Oppo A3s added to cart successfully");
				driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[3]/form[1]/button[1]")).click();
				System.out.println("g) Order Placing....");
				System.out.println(driver.getCurrentUrl());
				//Login
				driver.findElement(By.xpath("//input[@type='text']")).sendKeys("6362364295");
				driver.findElement(By.xpath("//button[@type='submit']")).click();
				Thread.sleep(1000);
				driver.findElement(By.xpath("//input[@type='password']")).sendKeys("Manat@123");
				System.out.println("h) Logged in successfully");
				//Delivery address
				Thread.sleep(1000);
				driver.findElement(By.xpath("//button[@type='submit']")).click();
				Thread.sleep(1000);
				//order summary
				driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/div[1]/div[2]/span[2]/button[1]")).click();
				Thread.sleep(1000);
				System.out.println("i) Order Confirmed");
				//Selecting Netbanking
				driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[4]/div[1]/div[1]/div[1]/div[1]/label[3]/div[2]/div[1]/div[1]")).click();
				System.out.println("h) Netbanking selected");
				Thread.sleep(1000);
				Select OtherBank =new Select (driver.findElement(By.xpath("//select[@class='_1CV081']")));
				OtherBank.selectByVisibleText("Corporation Bank");
				System.out.println("h) Selected Corporation bank");
				Thread.sleep(1000);
				driver.findElement(By.xpath("//button[@type='button']")).click();
				System.out.println("Successfully navigated to Corporation bank Login screen");
				
				//Screenshot of Corporation bank 
				File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		        Files.copy(src, new File("D:/Scrrenshot.png"));
		        System.out.println("i) Corporation bank Login screen screenshot captured");
			}
			else {
				System.out.println("Failed-Oppo A3s not present in the cart");
			}
		
	}
	}


