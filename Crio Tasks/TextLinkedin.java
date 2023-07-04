package demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TextLinkedin {
   ChromeDriver driver = TestCases.getDriver();

    public void textPost(){

// Navigate to the given URL  https://www.linkedin.com/
driver.get("https://www.linkedin.com/");
//sendKeys in the "Email or Phone" Field 
driver.findElement(By.id("session_key")).sendKeys("enter_email@gmail.com");
//TsendKeys in the "Password" Field
driver.findElement(By.id("session_password")).sendKeys("enter password");
//Click on "Sign in" Button Using Locator "XPath" //button[@type='submit']
driver.findElement(By.xpath("//button[@type='submit']")).click();
//Print the count of 'Who's viewed your profile' Using Locator "XPath" //span[contains(text(),'viewed your profile')]/../../following-sibling::div/span
String viewCount = driver.findElement(By.xpath("//span[contains(text(),'viewed your profile')]/../../following-sibling::div/span")).getText();
System.out.println("profile view count: "+viewCount);
// Print the count of 'Impressions of your post' Using Locator "XPath" //span[text()='Impressions of your post']/..//../following-sibling::div/span/strong
String impressionCount = driver.findElement(By.xpath("//span[text()='Impressions of your post']/..//../following-sibling::div/span/strong")).getText();
System.out.println("Impressions of your post: "+impressionCount);
// Click on "Start a post" Button Using Locator "XPath" //span[text()='Start a post']
driver.findElement(By.xpath("//span[text()='Start a post']")).click();
// Click on Post visibility options Dropdown Using Locator "Class" Name share-unified-settings-entry-button
driver.findElement(By.className("share-unified-settings-entry-button")).click();
// Select "Connections only" Using Locator "ID" CONNECTIONS_ONLY
driver.findElement(By.id("CONNECTIONS_ONLY")).click();
// Click on "Done" button Using Locator "XPath" //span[text()='Done']
driver.findElement(By.xpath("//span[text()='Done']")).click();
// Click on the text box Using Locator "XPath" //div[@role='textbox']
WebElement textBox = driver.findElement(By.xpath("//div[@role='textbox']"));
textBox.click();
// Type the message in text box Using Locator "XPath" //div[@role='textbox']
textBox.sendKeys("This is an automated test post kindly ignore");
// Click on "Post" button Using Locator "XPath" //span[text()='Post']
driver.findElement(By.xpath("//span[text()='Post']")).click();
// Veify that "Post successful." message is displayed Using Locator "XPath" //span[text()='Post successful.']
boolean isDisplayed = driver.findElement(By.xpath("//span[text()='Post successful.']")).isDisplayed();
System.out.println("Post is displayed? : "+isDisplayed);

    }
}
