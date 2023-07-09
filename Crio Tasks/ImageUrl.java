package demo;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ImageUrl {
      
   ChromeDriver driver = TestCases.getDriver();

public void imgUrl(){

// Navigate to URL  https://in.bookmyshow.com/explore/home/chennai
driver.get("https://in.bookmyshow.com/explore/home/chennai");

//Click on the Right arrow in the Recommended Movie Carosol Using Locator "XPath" (//div[contains(@class,'hxrBcw')])[1]
driver.findElement(By.xpath("(//div[contains(@class,'hxrBcw')])[1]")).click();

WebDriverWait wait = new WebDriverWait(driver, 30);
wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[text()='Recommended Movies']/../../../following-sibling::div/div/div/div[10]"))); 

// Print the images url of the Recommended Movies Using Locator "XPath" //h2[text()='Recommended Movies']/../../../following-sibling::div//img
List<WebElement> ele = driver.findElements(By.xpath("//h2[text()='Recommended Movies']/../../../following-sibling::div//img"));

System.out.println("Following are the "+ele.size()+" image URLs for all the Recommended Movies: ");
for(WebElement e : ele){
    System.out.println(e.getAttribute("src"));
    System.out.println("-----------------------");
}  
// Scroll down to view the "Premier List" Using Locator "XPath" By.xpath("//h2[text()='Premieres']
// WebElement premier =driver.findElement(By.xpath("//h2[text()='Premieres']"));

//  JavascriptExecutor jse = (JavascriptExecutor) driver;
//  jse.executeScript("arguments[0].scrollIntoView();",premier);

// Print the Name of the 2nd item in the "Premier List" Using Locator "XPath" //h2[text()='Premieres']/../../../following-sibling::div/div/div/div[2]//div[3]/div[1]/div
//System.out.println("2nd item in the Premier List : "+driver.findElement(By.xpath("//h2[text()='Premieres']/../../../following-sibling::div/div/div/div[2]//div[3]/div[1]/div")).getText());

// Print the Language of the 2nd item in the "Premier List" Using Locator "XPath" //h2[text()='Premieres']/../../../following-sibling::div/div/div/div[2]//div[3]/div[2]/div
//System.out.println("Language of the 2nd item in the Premier List"+driver.findElement(By.xpath("//h2[text()='Premieres']/../../../following-sibling::div/div/div/div[2]//div[3]/div[2]/div")).getText()); 
}
}
