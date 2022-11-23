import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

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
		
//		Login test = new Login();
//		test.login(driver);
		
//		Register test = new Register();
//		test.register();
		
		Bonus("login", driver);
		Thread.sleep(1000);
		Bonus("dailybonus", driver);
		
		driver.findElement(By.xpath("//a[@class='button size_m']")).click();
		driver.findElement(By.id("count_text")).sendKeys("automated broadcast");
		driver.findElement(By.xpath("//ul/li[2]")).click();
		driver.findElement(By.cssSelector("button.btn_style")).click();
		Thread.sleep(6000);
		driver.findElement(By.cssSelector("button.button_open")).click();
		
		Thread.sleep(10000);
		
		// Locating the Main Menu (Parent element)
		WebElement mainMenu = driver.findElement(By.className("video"));
		
		//Instantiating Actions class
		Actions actions = new Actions(driver);
		
		//Hovering on main menu
		actions.moveToElement(mainMenu);

		// Locating the element from Sub Menu
		//WebElement subMenu = driver.findElement(By.id("btn-sound_own"));

		//To mouseover on sub menu
		//actions.moveToElement(subMenu);

		//build()- used to compile all the actions into a single step 
		//actions.click().build().perform();
		Thread.sleep(1000);
		driver.findElement(By.id("btn-sound_own")).click();
		Thread.sleep(5000);
		driver.findElement(By.id("btn-invite")).click();
		
	}
	
	static void Bonus(String act, WebDriver driver) throws InterruptedException
	{
		WebDriverWait w =new WebDriverWait(driver,Duration.ofSeconds(10));
		switch (act) {
		case "dailybonus" :
			try {
				boolean doGetBonusPresence = driver.findElement(By.id("doGetBonus")).isDisplayed();
				boolean doGetBonusEnabled = driver.findElement(By.id("doGetBonus")).isDisplayed();
				if(doGetBonusPresence == true && doGetBonusEnabled == true)	
				{
					driver.findElement(By.id("doGetBonus")).click();
					w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".btn_style.btn_green.modal_close")));
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
			driver.findElement(By.className("login")).click();
			driver.findElement(By.name("login_mail")).sendKeys("2021-1@gmail.com");
			driver.findElement(By.name("login_password")).sendKeys("admin");
			driver.findElement(By.className("btn_style")).click();
			break;
		  default :
				break;
		}

		
	}
	
	
	

}
