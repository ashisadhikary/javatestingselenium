import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ImdbMoviesearch {
    public static void main(String[] args) {
        try {
            System.setProperty("webdriver.chrome.driver", "C:/automation/chrome/chromedriver.exe");
            WebDriver driver = new ChromeDriver();
            driver.get("https://imdb.com");

            //Now search for a movie in IMDB
            WebElement searchbox = driver.findElement(By.id("suggestion-search"));
            searchbox.sendKeys("Seven Years in Tibet");
            searchbox.submit();
        }catch(Exception e){
            System.out.println("The exception is: "+e);
        }
    }}

