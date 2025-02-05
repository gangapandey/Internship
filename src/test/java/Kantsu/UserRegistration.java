package Kantsu;

import java.time.Duration;
import java.util.List;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class UserRegistration {

	public static void main(String[] args) throws InterruptedException 
	{
		WebDriver driver = new ChromeDriver();
		
		WebDriverWait mywait =  new WebDriverWait(driver,Duration.ofSeconds(10));
		
		driver.navigate().to("https://kantsu-proc.dev.tai.com.np/");
		
		driver.manage().window().maximize();
		
		// Registration
		driver.findElement(By.xpath("//input[@id='username']")).sendKeys("admin@tai.com.np");
		
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("taiadmin");
		
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		
		// User Registeration
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@class='page-body-wrapper']//li[4]//a[1]")).click();
		
		driver.findElement(By.xpath("//a[@class='btn-custom btn-create']")).click();
		
		driver.findElement(By.xpath("//input[@id='last_name']")).sendKeys("Test");
		
		driver.findElement(By.xpath("//input[@id='first_name']")).sendKeys("Test");
		
		driver.findElement(By.xpath("//input[@id='username']")).sendKeys("123450");
		
		driver.findElement(By.xpath("//input[@placeholder='メールアドレス']")).sendKeys("test@test.com");
		
		driver.findElement(By.xpath("//input[@placeholder='パスワード']")).sendKeys("test1234");
		
		Thread.sleep(10000);
		
		List<WebElement> checkboxes  = driver.findElements(By.xpath("//div[@class='d-flex']//input[@type='checkbox']"));
		for(int i = 0; i< checkboxes.size(); i++)
		{
			checkboxes.get(i).click();
		}
		
		driver.findElement(By.xpath("//button[contains(text(),'選ぶ')]")).click();
		
		Thread.sleep(5000);
		
		driver.findElement(By.xpath("//input[@id='department_16']")).click();
		
		driver.findElement(By.xpath("//input[@id='department_14']")).click();
		
		driver.findElement(By.xpath("//button[@class='btn btn-primary']")).click();
		
		driver.findElement(By.xpath("//button[contains(text(),'追加')]")).click();
		
		Alert myalert = driver.switchTo().alert();
		System.out.println(myalert.getText());
		myalert.accept(); 

	}

}
