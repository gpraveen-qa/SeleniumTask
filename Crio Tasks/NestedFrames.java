package demo;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class NestedFrames {
    ChromeDriver driver = TestCases.getDriver();

    public void nFrame(){
    // Navigate to the given URL  https://the-internet.herokuapp.com/nested_frames
    driver.get("https://the-internet.herokuapp.com/nested_frames");
    // Switch to the Parent Frame Using Locator "Name" 
    driver.switchTo().frame("frame-top");
    // Switch to the first frame Using Locator "Name" frame-left
    driver.switchTo().frame("frame-left");
    // Printing the text of first frame  Using Locator "XPath" //body
    System.out.println(driver.findElement(By.xpath("//body")).getText());
    // Switching to parent frame  
    driver.switchTo().parentFrame();
    // Switching to second frame Using Locator "Name" frame-middle
    driver.switchTo().frame("frame-middle");
    // Printing the text of second frame  Using Locator "XPath" //body
    System.out.println(driver.findElement(By.xpath("//body")).getText());
    // Switching back to parent frame  
    driver.switchTo().parentFrame();
    // Switching to third frame Using Locator "Name" frame-right
    driver.switchTo().frame("frame-right");
    // Printing the text of third frame Using Locator "XPath" //body
    System.out.println(driver.findElement(By.xpath("//body")).getText());
    // Switching to default content  
    driver.switchTo().defaultContent();
    // Switching to bottom frame Using Locator "Name" frame-bottom
    driver.switchTo().frame("frame-bottom");
    // Printing the text of bottom frame Using Locator "XPath" //body
    System.out.println(driver.findElement(By.xpath("//body")).getText());
    }
}
