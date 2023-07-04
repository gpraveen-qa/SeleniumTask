package demo;
import java.io.File;
import java.io.IOException;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowHandle {
    ChromeDriver driver = TestCases.getDriver();

    public void winHandle() throws IOException{
    // Navigate to the given URL  https://www.w3schools.com/jsref/tryit.asp?filename=tryjsref_win_open
    driver.get("https://www.w3schools.com/jsref/tryit.asp?filename=tryjsref_win_open");

    //Get the current window handle   
   String mainHandle = driver.getWindowHandle();
    // Switch to the iframe Using Locator "ID" iframeResult
    driver.switchTo().frame("iframeResult");
    // Click on "Try it" button Using Locator "XPath" //button[text()='Try it']
    driver.findElement(By.xpath("//button[text()='Try it']")).click();;
    // Switch to the newly opened window by using window handle  
    Set<String> handles = driver.getWindowHandles();
    for(String a: handles){
        if(!a.equals(mainHandle)){
            driver.switchTo().window(a);
        }
    }
    // Print the URL 
    System.out.println(driver.getCurrentUrl()); 
    // Print the title of the page  
    System.out.println(driver.getTitle());
    // Take a screenshot  
    File f = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
    FileUtils.copyFile(f, new File(".\\screenshot\\screenshot.png"));
    
    driver.close();
     
    // Switch to the original window by using window handle  
    driver.switchTo().window(mainHandle);
    }
}
