package com.myntraProjectFinalUpdated1;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
public class App 
{
    
    WebDriver driver;

    By search = By.xpath("//*[@id=\"desktop-header-cnt\"]/div[2]/div[3]/input");

    @BeforeMethod
    public void setup() throws InterruptedException
    {
    	System.setProperty("webdriver.chrome.driver","C:\\Users\\dell\\Downloads\\chromedriver_win32 (5)\\chromedriver.exe" );
    	driver = new ChromeDriver();
    	driver.get("https://www.myntra.com");
    	
    	driver.manage().window().maximize();
    	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
    }
    
    public void verifyTitle()
    {
    	String actualTitle= driver.getTitle();
    	String expectedTitle="Online Shopping for Women, Men, Kids Fashion & Lifestyle - Myntra";
    	Assert.assertEquals(actualTitle,expectedTitle);
    	
    	boolean flag=driver.findElement(By.xpath("/html/head/title")).isDisplayed();
    	Assert.assertTrue(flag);
    	
    }

    @Test
    public void search() throws InterruptedException 
    {
    
    driver.findElement(search).sendKeys("mobile cases");
   
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

    driver.findElement(search).sendKeys(Keys.ENTER);
    
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    	
    driver.findElement(By.xpath("//*[@id=\"desktopSearchResults\"]/div[1]/section/div[1]/div[1]/div/div/div")).click();


    driver.findElement(By.xpath("//*[@id=\"desktopSearchResults\"]/div[1]/section/div[1]/div[1]/div/div/div/ul/li[6]/label")).click();
    
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    WebElement l = driver.findElement(By.xpath("//*[@id=\"desktopSearchResults\"]/div[2]/section/ul/li[3]/a/div[1]/div"));

    Actions a = new Actions(driver);
    a.moveToElement(l).click().perform();
    
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

    Set<String> windowhandles = driver.getWindowHandles();
    Iterator<String> iterator = windowhandles.iterator();
    String parent = iterator.next();
    String child = iterator.next();
    driver.switchTo().window(child);

    JavascriptExecutor js = (JavascriptExecutor) driver;
    js.executeScript("window.scrollBy(0,250)", "");

    driver.findElement(By.xpath("//*[@id=\"mountRoot\"]/div/div[1]/main/div[2]/div[2]/div[2]/div[2]/div/div[1]")).click();
    
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
   
    driver.findElement(By.xpath("//*[@id=\"mountRoot\"]/div/div[1]/main/div[2]/div[2]/div[2]/div[2]/div/a")).click();
    
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    driver.findElement(By.xpath("//*[@id=\"cartItemsList\"]/div/div/div/div[2]/div[1]/div/div[1]")).click();
   
   
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
   driver.findElement(By.xpath("//*[@id=\"appContent\"]/div/div/div/div/div[2]/div[3]/button/div")).click();

    
   driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

    String mobileNumber = "9131503109";
    driver.findElement(By.xpath("//*[@id=\"reactPageContent\"]/div/div/div[2]/div[2]/div[1]/input")).clear();
    driver.findElement(By.xpath("//*[@id=\"reactPageContent\"]/div/div/div[2]/div[2]/div[1]/input")).sendKeys(mobileNumber);
  
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    
    driver.findElement(By.xpath("//*[@id=\"reactPageContent\"]/div/div/div[2]/div[2]/div[3]")).click();
     Thread.sleep(5000);
    
   
    }

    @AfterMethod
    public void tearDown()
    {
    	
    	driver.quit();
    	
    }

    
    
    
    
}
