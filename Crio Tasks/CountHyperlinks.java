package demo;

import org.openqa.selenium.chrome.ChromeDriver;

public class CountHyperlinks {
   ChromeDriver driver = TestCases.getDriver();

    public void countLinks(){
        // Navigate to the given URL  https://in.bookmyshow.com/explore/home/chennai
        driver.get("https://in.bookmyshow.com/explore/home/chennai");
        //Locate the hyperlinks present on page using Using Locator "Tag Name" a
        int count = driver.findElementsByTagName("a").size();
        //Print the count of the hyperlinks  
        System.out.println("hyperlinks count: "+count);
    }
}
