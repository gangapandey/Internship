package CuraHealthCare;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CuraHealthCare {

	public static void main(String[] args) throws InterruptedException 
	{
		WebDriver driver = new ChromeDriver();
		
		WebDriverWait mywait =  new WebDriverWait(driver,Duration.ofSeconds(10));
		
		driver.navigate().to("https://katalon-demo-cura.herokuapp.com/");
		
		driver.manage().window().maximize();
		
		//Make appointment button
		driver.findElement(By.xpath("//a[@id='btn-make-appointment']"))	.click();
		
		//login
		
		driver.findElement(By.xpath("//input[@id='txt-username']")).sendKeys("John Doe");
		
		driver.findElement(By.xpath("//input[@id='txt-password']")).sendKeys("ThisIsNotAPassword");
		
		driver.findElement(By.xpath("//button[@id='btn-login']")).click();
		
		//Making appointment
		
		WebElement drpdown= driver.findElement(By.xpath("//select[@id='combo_facility']"));
		Select dpdown= new Select(drpdown);
		dpdown.selectByValue("Tokyo CURA Healthcare Center");
		
		driver.findElement(By.xpath("//input[@id='chk_hospotal_readmission']")).click();
		
		driver.findElement(By.xpath("//input[@id='radio_program_none']")).click();
		
		driver.findElement(By.xpath("//input[@id='txt_visit_date']")).sendKeys("31/01/2025");
		
		driver.findElement(By.xpath("//textarea[@id='txt_comment']")).sendKeys("Chest Infection with high fever");
		
		driver.findElement(By.xpath("//button[@id='btn-book-appointment']")).click();
		
		//go back to homepage
		driver.findElement(By.xpath("//a[normalize-space()='Go to Homepage']")).click();
		
		//logout
		driver.findElement(By.xpath("//i[@class='fa fa-bars']")).click();
		Thread.sleep(5000);
		
		driver.findElement(By.xpath("//a[normalize-space()='Logout']")).click();

	}

}
