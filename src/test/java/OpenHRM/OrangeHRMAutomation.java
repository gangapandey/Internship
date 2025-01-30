package OpenHRM;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class OrangeHRMAutomation {

	public static void main(String[] args) throws InterruptedException 
	{
		WebDriver driver = new ChromeDriver();
		
		WebDriverWait mywait =  new WebDriverWait(driver,Duration.ofSeconds(10));
		
		driver.navigate().to("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		
		driver.manage().window().maximize();
		
		
		// --------   login with valid credentials --------------------
		//Dynamically locators are changing so we use this approach
		//driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys("Admin");
		WebElement usernameField = mywait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Username']"))
		);
		usernameField.sendKeys("Admin");
		
				
		WebElement PasswordField = mywait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Password']"))
		);
		PasswordField.sendKeys("admin123");
					
		driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();
				
				
		// -------  verifying if the login was successful by checking the page title or a specific element --------
		
		String pageTitle =  driver.getTitle();
		if (pageTitle.equals("OrangeHRM"))
		{
			System.out.println("Login Successful");
		}
		else
		{
			System.out.println("Login invalid");
		}
		
		
		// --------- login with invalid credentials    need to do with testng framework  ------------
		/*WebElement usernameField = mywait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Username']"))
		);
		usernameField.sendKeys("Admin");
				
		WebElement PasswordField = mywait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Password']"))
		);
		PasswordField.sendKeys("123");
					
		driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();
		
		String pageTitle = driver.getTitle();
		
		if (pageTitle.equals("OrangeHRM")) {
            System.out.println("Login Successful");
        } else {
            System.out.println("Login invalid");
        }
        */
		
		
		// ---------------- Adding Employeee ---------------------
		
		WebElement pim = mywait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[normalize-space()='PIM']"))
		);
		pim.click();
		
		WebElement addEmployee = mywait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[normalize-space()='Add Employee']"))
		);
		addEmployee.click();
		
		//firstname
		WebElement firstname = mywait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='First Name']")));
		firstname.sendKeys("Tara");
		
		//empid
		WebElement EmpId = mywait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='oxd-input-group oxd-input-field-bottom-space']//div//input[@class='oxd-input oxd-input--active']")));
		EmpId.sendKeys("0808");
		
		//upload image
		WebElement uploadElement = driver.findElement(By.cssSelector("input[type='file']"));
		uploadElement.sendKeys("C:\\Users\\ASUS Vivobook\\Downloads\\test.jpg");
		
		//lastname
		WebElement Lastname = mywait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Last Name']")));
		Lastname.sendKeys("Rai");
		
		//save btn
		WebElement savebtn = mywait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='Save']")));
		savebtn.click();
		
		
		Thread.sleep(9000);
		
		//----------  verify if the employee is successfully added or not ---------------------
		
		String confirmMsg = driver.findElement(By.xpath("//h6[normalize-space()='Personal Details']")).getText();
		if (confirmMsg.contains("Personal Details"))
		{
			System.out.println("Employee added successfully");
		}
		else
		{
			System.out.println("Failed to add employee");
		}
		
		
		
		// ------------ searching employee by name --------------
		
		WebElement emplist = mywait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[normalize-space()='Employee List']"))
		);
		emplist.click();
		
//		WebElement searchemp = mywait.until(
//				ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='oxd-grid-4 orangehrm-full-width-grid']//div[1]//div[1]//div[2]//div[1]//div[1]//input[1]"))
//		);
//		searchemp.sendKeys("Alkaa");
		
		WebElement searchempid = mywait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='oxd-input-group oxd-input-field-bottom-space']//div//input[@class='oxd-input oxd-input--active']"))
		);
		searchempid.sendKeys("0458");
		
		WebElement searchclick = mywait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='Search']"))
		);
		searchclick.click();
		
		
		Thread.sleep(5000);
		
		// display record found or not
		
//		String recordmsg = driver.findElement(By.xpath("//span[@class='oxd-text oxd-text--span']")).getText();
//		if (recordmsg.contains("Records Found"))
//		{
//			System.out.println("Your entered record is found");
//		}
//		else
//		{
//			System.out.println("Your entered record is not found");
//		}
		
		
		// ----------  validating id record --------------
		
		String recordmsg = driver.findElement(By.xpath("//span[@class='oxd-text oxd-text--span']")).getText();
		if (recordmsg.contains("Records Found"))
		{
			System.out.println("Your entered record is found");
		}
		else
		{
			System.out.println("Your entered record is not found");
		}
		
		
		
		// ---------- File uploading ---------------------
		
		WebElement confignavigate = mywait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='oxd-topbar-body-nav-tab-item']"))
		);
		confignavigate.click();
		
		// dropdown
		WebElement dataimport = mywait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[normalize-space()='Data Import']"))
		);
		dataimport.click();
		
		
		// ----------  Browse to upload file ---------------
		
		Thread.sleep(5000);
		WebElement uploadFile = driver.findElement(By.cssSelector("input[type='file']"));
		uploadFile.sendKeys("C:\\Users\\ASUS Vivobook\\Downloads\\importData.csv");

		
		
		// ----------- Delete an employee record ------------------
		
		WebElement pim3 = mywait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[normalize-space()='PIM']"))
		);
		pim3.click();
		
		WebElement emplist2 = mywait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[normalize-space()='Employee List']"))
		);
		emplist2.click();
		
		Thread.sleep(3000);
		
		WebElement searchemp = mywait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='oxd-grid-4 orangehrm-full-width-grid']//div[1]//div[1]//div[2]//div[1]//div[1]//input[1]"))
		);
		searchemp.sendKeys("Tara");
		
		WebElement deletebtn = mywait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='orangehrm-paper-container']//button[2]"))
		);
		deletebtn.click();
		
		
		// Wait for confirmation popup to appear
		WebElement deletePopup = mywait.until(
		        ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@role='document']"))
		);
		
		WebElement deletebtnyes = mywait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='Yes, Delete']"))
		);
		deletebtnyes.click();
		
		Thread.sleep(5000);
		List<WebElement> noRecordsMsg = driver.findElements(By.xpath("//span[normalize-space()='No Records Found']"));

	    if (!noRecordsMsg.isEmpty()) {
	        System.out.println("Your entered record deleted successfully.");
	    } else {
	        System.out.println("Deletion failed! Record still exists.");
	    }
		
		Thread.sleep(5000);
		
		
		
		// ------------- logout -------------------
		
		Thread.sleep(5000);
		driver.findElement(By.xpath("//p[@class='oxd-userdropdown-name']")).click();
				
		driver.findElement(By.xpath("//a[normalize-space()='Logout']")).click();

	}

}
