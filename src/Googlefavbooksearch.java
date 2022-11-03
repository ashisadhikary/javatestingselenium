import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Googlefavbooksearch {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","C:/automation/chrome/chromedriver.exe");
        //new Object for webdriver
        WebDriver driver = new ChromeDriver();
        driver.get("http://google.com");

        //create a webElement object to search the searchbox in google
        // The name q is the name of the name assigned to the searchbox by google.com
        WebElement searchbox = driver.findElement(By.name("q"));
        searchbox.sendKeys("The End of History");
        searchbox.submit();

    }
}
