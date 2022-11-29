import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class talkLiverRegister {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\fdcar\\Downloads\\Automatio\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
//		driver.findElement(By.className("login")).click();
		
		// Value declaration
		String url = "https://dev-front.machetalk.jp/liver/";
		String email = "sampleautomated@gmail.com";
		String password = "admin";
		String nickName = "Automated Registration";
		String ageValue = "18歳";
		String residenceValue = "日本";
		String areaValue = "神奈川県";
		String performer_jobValue = "フリーター";
		String heightValue = "151 cm";
		String bodyTypeValue = "かなりスリム";
		String personalityValue = "女王様系";
		String [] hobbyValue = {"ゲーム","スポーツ","グルメ"};
		String activeTimeValue = "夜～深夜";
		String selfInroductionValue = "Test Test Test";
		
		// Edit profile web elements declaration
//		WebElement cameraIcon = driver.findElement(By.xpath("//div[@id='camera_icon']"));
//		WebElement nickName = driver.findElement(By.xpath("//input[@class='mail nickname_count']"));
		WebElement charm = driver.findElement(By.xpath("//input[@class='charm_point charm_point_count']"));
		WebElement age = driver.findElement(By.xpath("//select[@name='age']"));
		WebElement residence = driver.findElement(By.xpath("//select[@id='residence']"));
		WebElement area = driver.findElement(By.xpath("//select[@id='area']"));
		WebElement performer_job = driver.findElement(By.xpath("//select[@name='performer_job']"));
		WebElement height = driver.findElement(By.xpath("//select[@name='height']"));
		WebElement body_type = driver.findElement(By.xpath("//select[@name='body_type']"));
		WebElement personality = driver.findElement(By.xpath("//select[@name='personality']"));
		List <WebElement> hobby = driver.findElements(By.xpath("//div[@class='checkbox']/label"));
		WebElement active_time = driver.findElement(By.xpath("//select[@name='active_time']"));
		WebElement self_introduction = driver.findElement(By.xpath("//textarea[@name='self_introduction']"));
		WebElement button_submit = driver.findElement(By.xpath("//button[@class='button size_m']"));
		
		driver.manage().window().maximize(); // maximize window
		driver.get(url); // get url
	
		driver.findElement(By.className("regist")).click();
		driver.findElement(By.xpath("//input[@name='register_mail']")).sendKeys(email);
		driver.findElement(By.xpath("//input[@name='register_password']")).sendKeys(password);
		driver.findElement(By.xpath("//input[@name='register_password_conf']")).sendKeys(password);
		
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		
		driver.findElement(By.name("register_nickname")).sendKeys(nickName);
		driver.findElement(By.id("btnProfileImgUpdate")).click();
		
		Thread.sleep(5000);
		//daily login bunos
		Open_Broadcast.Bonus("dailybonus",driver);
		
		driver.findElement(By.xpath("//a[contains(.,'プロフィール編集')]")).click();
		 		
		
		
		charm.sendKeys("automated test");
		
		// select age
		Select ageDropdown = new Select(age);
		ageDropdown.selectByVisibleText(ageValue);
		
		// select residence
		Select residenceDropdown = new Select(residence);
		residenceDropdown.selectByVisibleText(residenceValue);
		
		
		Thread.sleep(3000);
		
		// select area
		Select areaDropdown = new Select(area);
		areaDropdown.selectByVisibleText(areaValue);
		
		
		// select performer_job
		Select performerJobDropdown = new Select(performer_job);
		performerJobDropdown.selectByVisibleText(performer_jobValue);
		
		// select height
		Select heightDropdown = new Select(height);
		heightDropdown.selectByVisibleText(heightValue);
		
		// select body type
		Select body_typeDropdown = new Select(body_type);
		body_typeDropdown.selectByVisibleText(bodyTypeValue);
		
		// select body type
		Select personalityDropdown = new Select(personality);
		personalityDropdown.selectByVisibleText(personalityValue);
		
		// Select hobbies
		int j=0;
		for(int i=0; i<hobby.size(); i++){
			String hobbyList = hobby.get(i).getText();
			
			List<String> hobbies = Arrays.asList(hobbyValue);
			if(hobbies.contains(hobbyList)) {
				j++;
				hobby.get(i).click();
				if(j == hobbyValue.length) {
					break;
				}
			}
		}
		
		// select active time
		Select active_TimeDropdown = new Select(active_time);
		active_TimeDropdown.selectByVisibleText(activeTimeValue);
		

		// Enter self introduction
		self_introduction.sendKeys(selfInroductionValue);
		
		
		//Submit button
		button_submit.click();
		
	}

}
