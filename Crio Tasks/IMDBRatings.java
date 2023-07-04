package demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class IMDBRatings {
    ChromeDriver driver = TestCases.getDriver();

    public void imdb(){
        //Navigate to the given URL  https://www.imdb.com/chart/top
        driver.get("https://www.imdb.com/chart/top");
        // Print the Highest Rated Movie Using Locator "XPath" (//td[@CLASS='titleColumn'])[1]/a
        System.out.println("Highest Rated Movie :"+driver.findElement(By.xpath("(//td[@CLASS='titleColumn'])[1]/a")).getText());
        // Print the count of the movies included in the table Using Locator "XPath" //tbody/tr
        System.out.println("No of Movies included in the table: "+driver.findElements(By.xpath("//tbody/tr")).size());
        // Select the Sort by Dropdown Using Locator "ID" lister-sort-by-options
        Select sel = new Select(driver.findElement(By.id("lister-sort-by-options")));
        // Select "Release Date" from the dropdown, using visible text   Release Date 
        sel.selectByVisibleText("Release Date");
        // Click on arrow button Using Locator "CSS Selector" div.lister-activated span
        WebElement arrow = driver.findElement(By.cssSelector("div.lister-activated span"));
        arrow.click();
        // Print the oldest movie on the list Using Locator "XPath" (//td[@CLASS='titleColumn'])[1]/a
        System.out.println("Oldest movie on the list: "+driver.findElement(By.xpath("(//td[@CLASS='titleColumn'])[1]/a")).getText());
        // Click on arrow button Using Locator "CSS Selector" div.lister-activated span
        arrow.click();
        // Print the most recent movie on the list Using Locator "XPath" (//td[@CLASS='titleColumn'])[1]/a
        System.out.println("The most recent movie on the list -"+driver.findElement(By.xpath("(//td[@CLASS='titleColumn'])[1]/a")).getText());

        
        // Select "Number of Ratings" from the dropdown, using visible text  Number of Ratings
        sel.selectByVisibleText("Number of Ratings");

        // Print the movie with most user ratings Using Locator "XPath"(//td[@CLASS='titleColumn'])[1]/a
        System.out.println("The movie with most user ratings: "+driver.findElement(By.xpath("(//td[@CLASS='titleColumn'])[1]/a")).getText());
    }
}
