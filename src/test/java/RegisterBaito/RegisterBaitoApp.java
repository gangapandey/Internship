package RegisterBaito;

import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import org.junit.jupiter.api.Assertions;


public class RegisterBaitoApp {

	public static void main(String[] args) 
	{
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://baito.tai.com.np/mv/auth/register");
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		//lastname
				driver.findElement(By.cssSelector("input#last-name")).sendKeys("Rai");
				
				//name
				driver.findElement(By.cssSelector("input#firstName")).sendKeys("Alka");
				
				//firstname katakana
				driver.findElement(By.cssSelector("input#lastNameKatakana")).sendKeys("ララ");
				
				//firstname katakana
				driver.findElement(By.cssSelector("input#firstNameKatakana")).sendKeys("ララ");
				
				//telephone
				driver.findElement(By.cssSelector("input#phone-number")).sendKeys("012345678901");
				
				//email
				driver.findElement(By.cssSelector("input#email-address")).sendKeys("alka.rai@tai.com.np");
				
				//choosegender
				driver.findElement(By.cssSelector("button[value='female']")).click();
				
				//datepicker
				WebElement dob = driver.findElement(By.xpath("//input[contains(@id, 'r6')]"));
				dob.click();
				dob.sendKeys("1990-01-01"); 
//				
				//upload image
				WebElement uploadElement = driver.findElement(By.cssSelector("input[type='file']"));
				uploadElement.sendKeys("C:\\Users\\ASUS Vivobook\\Downloads\\test.jpg");
				
				//telephone
				driver.findElement(By.xpath("//input[@id='postalCode']")).sendKeys("1000000");
				
				//streetnumber
				driver.findElement(By.xpath("//input[@id='streetNumber']")).sendKeys("100-0005 Tokyo, Chiyoda City, Marunouchi 1-1-1");
				
				//buildingname
				driver.findElement(By.xpath("//input[@id='buildingName']")).sendKeys("420");

				
				//Register
				//driver.findElement(By.cssSelector("button.MuiTouchRipple-root css-4mb1j7")).click();
				WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
				WebElement registerButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/div[1]/div/div/div[2]/div/form/button")));
				registerButton.click();
				
				// Check if email already exists 
		        try 
		        {
		            WebElement emailError = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'Email already registered')]")));
		            Assertions.assertTrue(emailError.isDisplayed(), "Email already registered error message is displayed.");
		        } 
		        catch (Exception e) 
		        {
		            System.out.println("The email you provided is already registered. Try with the new one.");
		        }
		        
		        // Check if phone number is already registered
		        try 
		        {
		            WebElement phoneError = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'Phone number already registered')]")));
		            Assertions.assertTrue(phoneError.isDisplayed(), "Phone number already registered error message is displayed.");
		        } 
		        catch (Exception e) 
		        {
		            System.out.println("The phone number is already registered. Please try with a different one.");
		        }
		        
				//confrimregister
				driver.findElement(By.xpath("/html/body/div/div[1]/div/div/div[2]/div/div/div/button[1]")).click();
				
				//reconfrimregister
				driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/div[2]/div/button")).click();

		
	}

}
