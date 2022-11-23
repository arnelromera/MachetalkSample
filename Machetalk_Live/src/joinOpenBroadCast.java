import java.time.Duration;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.bidi.log.Log;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class joinOpenBroadCast {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--use-fake-ui-for-media-stream=10");
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\fdcar\\Downloads\\Automatio\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver(options);
		
		driver.manage().window().maximize();
		driver.get("https://dev-front.machetalk.jp/");
		
		String[] broadcastName = {"Chilling"};
		String[] giftCategoryName = {"定番"};
		String[] giftName = {"流石です"};
		
		driver.findElement(By.cssSelector(".button_login.btn_style.btn_green-o")).click();
		
		WebDriverWait w =new WebDriverWait(driver,Duration.ofSeconds(10));
		w.until(ExpectedConditions.visibilityOfElementLocated(By.name("login_mail")));
		
		Login test = new Login();
		test.login(driver);
		
//		w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#reload_update")));
//		driver.findElement(By.cssSelector("#reload_update")).click();
		Thread.sleep(10000);
		joinBroadcast(driver,broadcastName);
		
		Thread.sleep(3000);
		Set<String> windows = driver.getWindowHandles(); //[parentid,childid,subchildId]

		Iterator<String>it = windows.iterator();

		String parentId = it.next();

		String childId = it.next();
		
		driver.switchTo().window(childId);

		Thread.sleep(10000);
		
		int a = 5;
		for(int i = 0; i<a;i++)
		{
			driver.findElement(By.cssSelector("#inputComment")).sendKeys("Automated comments");
			driver.findElement(By.cssSelector("button[type='submit']")).click();
		}
		
//		driver.findElement(By.xpath("//body[1]/div[2]/div[2]/div[2]/div[2]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]")).click();
		categoryList(driver,giftCategoryName);
		
		Thread.sleep(5000);
		addGift(driver,giftName);
			
//		driver.switchTo().window(parentId);
	}
	public static void joinBroadcast(WebDriver driver,String[] broadcastName) {
		List<WebElement> broadcast = driver.findElements(By.xpath("//div[@class='room']"));
		
		for(int i=0; i<broadcast.size(); i++) {
			
			String broadcastlist = broadcast.get(i).getText();
			
			List<String> itemsNeededList = Arrays.asList(broadcastName);
			
			if(itemsNeededList.contains(broadcastlist)) 
			{
				driver.findElements(By.xpath("//div[@class='liver ng-scope']")).get(i).click();
			}
		}
		
	}
	public static void categoryList(WebDriver driver,String[] giftCategoryName) {
		List<WebElement> categoryName = driver.findElements(By.cssSelector(".swiper-slide"));
		
		for(int i=0; i<categoryName.size(); i++) {
			
			String categorylist = categoryName.get(i).getText();
			
			List<String> giftCategoryNameList = Arrays.asList(giftCategoryName);
			
			if(giftCategoryNameList.contains(categorylist)) 
			{
				driver.findElements(By.cssSelector(".swiper-slide")).get(i).click();
			}
		}
		
	}
	public static void addGift(WebDriver driver,String[] giftName) {
		
		List<WebElement> giftNameElement = driver.findElements(By.xpath("//div[@class='list-item ng-scope']/p"));
		
		for(int i=0; i<giftNameElement.size(); i++) {
			
			String giftNameList = giftNameElement.get(i).getText();
			
			List<String> giftasdfNameList = Arrays.asList(giftName);
		
			if(giftasdfNameList.contains(giftNameList)) 
			{
				int count = 5;
				for(int i1=0; i1<count; i1++) {
					driver.findElements(By.xpath("//div[@class='list-item ng-scope']")).get(i).click();
				}
				
			}
		}
		
	}
	

}
