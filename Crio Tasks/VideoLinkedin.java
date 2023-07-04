package demo;
import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class VideoLinkedin {
   ChromeDriver driver = TestCases.getDriver();

    public void videoPost() throws AWTException{

// Navigate to the given URL  https://www.linkedin.com/
driver.get("https://www.linkedin.com/");
//sendKeys in the "Email or Phone" Field 
driver.findElement(By.id("session_key")).sendKeys("enter_your_email@gmail.com");
//TsendKeys in the "Password" Field
driver.findElement(By.id("session_password")).sendKeys("enter your password");
//Click on "Sign in" Button Using Locator "XPath" //button[@type='submit']
driver.findElement(By.xpath("//button[@type='submit']")).click();
//Click on "Video" Button Using Locator "XPath" //button[@aria-label='Add a video']
driver.findElement(By.xpath("//button[@aria-label='Add a video']")).click();

//Upload file using Robot class  
Robot rb = new Robot();
rb.delay(3000);
        
    //We have to pass path of the file using StringSelection
    StringSelection ss = new StringSelection("Z:\\Downloads\\Tree.mp4");
        //status_codes.jpeg //SeleniumCheetSheet.jpg  //Tree.mp4

    Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss,null);
    
    //rb.keyPress(KeyEvent.VK_CONTROL);
    //rb.keyPress(KeyEvent.VK_C);
    rb.keyPress(KeyEvent.VK_CONTROL);
    rb.keyPress(KeyEvent.VK_V);
    rb.keyPress(KeyEvent.VK_ENTER);

    rb.keyRelease(KeyEvent.VK_CONTROL);
    rb.keyRelease(KeyEvent.VK_V);
    rb.keyRelease(KeyEvent.VK_ENTER);
    
//Click on "Done" button Using Locator "XPath" //span[text()='Done']
driver.findElement(By.xpath("//span[text()='Done']")).click();
//send keys about the file uploaded in description Using Locator "XPath" //div[contains(@aria-label,'editor for creating content')]

WebElement textbox = driver.findElement(By.xpath("//div[contains(@aria-label,'editor for creating content')]"));
textbox.sendKeys("This Video is uploaded through automation using Robot Class.");

// Click on "Post" button Using Locator "XPath" //span[text()='Post']
driver.findElement(By.xpath("//span[text()='Post']")).click();

WebDriverWait wait = new WebDriverWait(driver,20);
//Explicitly wait for 30 sec for visibility of view post Using Locator "Link Text" View post
wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("View post")));

// Veify that "Post successful." message is displayed Using Locator "XPath" //span[text()='Post successful.']
boolean isDisplayed = driver.findElement(By.xpath("//span[text()='Post successful.']")).isDisplayed();
System.out.println("Post is displayed? : "+isDisplayed);

    }
}
