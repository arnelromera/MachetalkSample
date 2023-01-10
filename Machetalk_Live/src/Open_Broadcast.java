import java.time.Duration;
import java.util.NoSuchElementException;

import javax.swing.Action;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import com.google.common.base.Function;
public class Open_Broadcast {
	
	public static void main(String[] args) throws InterruptedException {
		
		// TODO Auto-generated method stub
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--use-fake-ui-for-media-stream=10");
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\fdcar\\Downloads\\Automatio\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver(options);
		
		driver.manage().window().maximize();
		driver.get("https://dev-front.machetalk.jp/liver/");
		
		driver.findElement(By.className("login")).click();
		
		test a = new test();
		
//		Login test = new Login();
//		test.login(driver);
		
//		Register test = new Register();
//		test.register();
		Bonus("login", driver);
		
		Thread.sleep(3000);
		Bonus("dailybonus", driver);
		
		
		driver.findElement(By.xpath("//a[@class='button size_m']")).click();
		System.out.println("The login button is clicked");
		driver.findElement(By.id("count_text")).sendKeys(a.roomName);
		driver.findElement(By.xpath("//ul/li[2]")).click();
		driver.findElement(By.cssSelector("button.btn_style")).click();
		
		Thread.sleep(5000);
		driver.findElement(By.cssSelector("button.button_open")).click();
		
		
		Thread.sleep(10000);
//		Thread.sleep(2000);
		WebElement sound = driver.findElement(By.id("btn-sound_own"));
		WebElement video = driver.findElement(By.id("btn-invite"));
		//WebElement video = driver.findElement(By.className("video"));
		//Instantiating Actions class
		Actions actions = new Actions(driver);
		
		//Hovering on main menu
		actions.moveToElement(sound).click().build().perform();
		Thread.sleep(6000);
		actions.moveToElement(video).click().build().perform();

		// Locating the element from Sub Menu
		//WebElement subMenu = driver.findElement(By.id("btn-sound_own"));

		//To mouseover on sub menu
		//actions.moveToElement(subMenu);

		//build()- used to compile all the actions into a single step 
		//actions.click().build().perform();
//		Thread.sleep(2000);
//		driver.findElement(By.id("btn-sound_own")).click();
//		Thread.sleep(5000);
//		driver.findElement(By.id("btn-invite")).click();
		
	}
	
	static void Bonus(String act, WebDriver driver) throws InterruptedException
	{
		// Waiting 30 seconds for an element to be present on the page, checking
		// for its presence once every 5 seconds.
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
	       .withTimeout(Duration.ofSeconds(30))
	       .pollingEvery(Duration.ofSeconds(5))
	       .ignoring(NoSuchElementException.class);
		
		switch (act) {
		case "dailybonus" :
			try {
				boolean doGetBonusPresence = driver.findElement(By.id("doGetBonus")).isDisplayed();
				boolean doGetBonusEnabled = driver.findElement(By.id("doGetBonus")).isDisplayed();
				if(doGetBonusPresence == true && doGetBonusEnabled == true)	
				{
					System.out.println("The daily login modal bonus is displayed");
					driver.findElement(By.id("doGetBonus")).click();
					Thread.sleep(5000);
					System.out.println("The daily login get modal bonus is displayed");
					driver.findElement(By.cssSelector(".btn_style.btn_green.modal_close")).click();			
				}
			}
			catch(Exception e){
				
				System.out.println("The get bonus modal is not displayed.");
			}
			break;
			
		case "register" :
			break;
			
		case "login" :
			WebElement doGetBonus = wait.until(new Function<WebDriver, WebElement>() {
			     public WebElement apply(WebDriver driver) {
			    	 if(driver.findElement(By.name("login_mail")).isEnabled())	
						{
			    		 return driver.findElement(By.name("login_mail"));
						}
			    	 else
			    	 {
			    		 return null;
			    	 }
			     }
			   });
			System.out.println("The login page is displayed");
			doGetBonus.sendKeys("vccccn@gmail.com");
			driver.findElement(By.name("login_password")).sendKeys("admin");
			driver.findElement(By.xpath("//button[@class='btn_style btn_green']")).click();
			break;
		  default :
			  break;
		}
	}
}
