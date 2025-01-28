package LoginBaito;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.List;

public class LoginBaitoApp {

	public static void main(String[] args) 
	{
		WebDriver driver = new ChromeDriver();
   	 
   	 try {
            // Step 1: Open the login page
            driver.get("https://baito.tai.com.np/mv");
            
            driver.manage().window().maximize();

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

            // Step 2: Enter phone number
            WebElement phoneField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"phone\"]")));
            phoneField.sendKeys("012345678901");  

            // Step 3: Submit phone number
            WebElement submitButton = driver.findElement(By.xpath("//*[@id='root']/div[1]/div/div/div[2]/form/div[2]/button"));
            submitButton.click();

            // Step 4: Get OTP from Alert Box
            wait.until(ExpectedConditions.alertIsPresent());
            Alert alert = driver.switchTo().alert();
            String otpText = alert.getText();
            System.out.println("Retrieved OTP: " + otpText);

            // Step 5: Extract OTP from the alert text
            String otp = otpText.split(" ")[otpText.split(" ").length - 1];
            System.out.println("Extracted OTP: " + otp);

            // Step 6: Dismiss the alert
            alert.accept();

            // Step 7: Input the OTP digits in the form
            List<WebElement> otpInputs = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//input[@type='number' and @inputmode='numeric']")));
            for (int i = 0; i < otp.length(); i++) {
                otpInputs.get(i).sendKeys(String.valueOf(otp.charAt(i)));
            }
            System.out.println("OTP successfully entered.");

            // Step 8: Submit OTP
            WebElement loginButton = driver.findElement(By.cssSelector("#root > div.MuiStack-root.css-1fjbfmt > div > div > div.MuiBox-root.css-19midj6 > form > div.MuiBox-root.css-11y5us4 > button.MuiButtonBase-root.MuiButton-root.MuiButton-contained.MuiButton-containedPrimary.MuiButton-sizeMedium.MuiButton-containedSizeMedium.MuiButton-colorPrimary.MuiButton-fullWidth.MuiButton-root.MuiButton-contained.MuiButton-containedPrimary.MuiButton-sizeMedium.MuiButton-containedSizeMedium.MuiButton-colorPrimary.MuiButton-fullWidth.css-189dd52"));
            loginButton.click();
            System.out.println("Logged in.");

            // Step 9: Verify login success
            WebDriverWait shortWait = new WebDriverWait(driver, Duration.ofSeconds(5));
            System.out.println("Logged in successfully.");

        } 
   	 catch (Exception e) 
   	 	{
            System.out.println("An error occurred: " + e.getMessage());
        } 

	}

}
