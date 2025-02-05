package Kantsu;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductMaster {

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
		
		// Navigation to product master
		Thread.sleep(6000);
		driver.findElement(By.xpath("//a[contains(text(),'商品マスタ')]")).click();
		
		// Export csv file
		//driver.findElement(By.xpath("//a[@class='btn-custom btn-view ']")).click();
		
		// Product addition
		driver.findElement(By.xpath("//a[@class='btn-custom btn-create']")).click();
		
		driver.findElement(By.xpath("//input[@name='name']")).sendKeys("Monitor");
		
		Thread.sleep(4000);
		WebElement drpSupElem = driver.findElement(By.xpath("//select[@id='supplier_id']"));
		Select drpSup = new Select (drpSupElem);
		drpSup.selectByVisibleText("46 株式会社ユニマットライフ");
		
		driver.findElement(By.xpath("//input[@value='visible']")).click();
		
		driver.findElement(By.xpath("//input[@name='product_price']")).sendKeys("10000");
		
		driver.findElement(By.xpath("//input[@value='tax included']")).click();
		
		Thread.sleep(8000);
		WebElement drpUnitElem = driver.findElement(By.xpath("//select[@id='unit']"));
		Select drpUnit = new Select (drpUnitElem);
		drpUnit.selectByVisibleText("個");
		
		driver.findElement(By.xpath("//input[@name='order_quantity_unit']")).sendKeys("5");
		
		driver.findElement(By.xpath("//input[@name='product_details_item_1']")).sendKeys("9812345678");
		
		driver.findElement(By.xpath("//input[@name='product_details_item_2']")).sendKeys("Alka Rai");
		
		Thread.sleep(12000);
		WebElement drpItemElem = driver.findElement(By.xpath("//select[@id='unit']"));
		Select drpItem = new Select (drpItemElem);
		drpItem.selectByValue("機器・什器等");
		
		driver.findElement(By.xpath("//input[@id='product_details_item_4']']")).sendKeys("50000");
		
		driver.findElement(By.xpath("//input[@id='product_details_item_4']']")).sendKeys("testname");
		
		driver.findElement(By.xpath("//button[contains(text(),'追加')]")).click();
		
		
		
		
		
				
		// searching of items
		
		// Product code 
		driver.findElement(By.xpath("//input[@id='productCode']")).sendKeys("4240");
		
		// supplier id
		WebElement drpSupIdElem = driver.findElement(By.xpath("//select[@id='supplier_code']"));
		Select drpSupId = new Select (drpSupIdElem);
		drpSupId.selectByVisibleText("140");
		
		// supplier name
		Thread.sleep(5000);
		WebElement drpSupNameElem = driver.findElement(By.xpath("//select[@id='supplier_code']"));
		Select drpSupName = new Select (drpSupNameElem);
		drpSupName.selectByVisibleText("DK Corporation");

		// Approved status
//		WebElement drpAppStatusElem = driver.findElement(By.xpath("//select[@id='supplier_code']"));
//		Select  drpAppStatus = new Select (drpAppStatusElem);
//		drpAppStatus.selectByValue("Unapproved");
		
//		driver.findElement(By.xpath("//li[@id='select2-approver-status-result-w226-approved']//font//font[contains(text(),'approved')]")).click();
		
		//status
//		WebElement drpstatuselem = driver.findElement(By.xpath("//select[@id='status']"));
//		Select  drpStatus = new Select (drpstatuselem);
//		drpStatus.selectByValue("Unapproved");
		
		//search button
		driver.findElement(By.xpath("//button[@id='filterOrders']")).click();
	}

}
