package demo;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class SearchAmazon {
   ChromeDriver driver = TestCases.getDriver();
    
  public void searchAmazon(){

   //Navigate to the given URL  https://www.google.com/
   driver.get("https://www.google.com/");
  
   //sendKeys "amazon" to Search Bar Using Locator "Name" q
    driver.findElement(By.name("q")).sendKeys("Amazon");
   
    //Click on Search Button Using Locator "XPath" //input[@value='Google Search']
    driver.findElement(By.xpath("//input[@value='Google Search']")).click();

    //Validate Amazon.in In search Results Using Locator "XPath" //h3[text()='Amazon.in']
    boolean isDisplayed = driver.findElement(By.xpath("//h3[text()='Amazon.in']")).isDisplayed();
    System.out.println("Amazon.in is displayed:"+isDisplayed);
    
    }
 
}
