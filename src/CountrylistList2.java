import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class CountrylistList2 {
    public static void main(String[] args) {
        try {
        System.setProperty("webdriver.chrome.driver", "C:/automation/chrome/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        //1. Open the website
        driver.get("http://www.justwatch.com");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        //Call Javascript to move down the page
            JavascriptExecutor jv = (JavascriptExecutor) driver; //Use JavaScriptExecutor object with WebDriver driver
            jv.executeScript("window.scrollBy(0,3000)");
        //Find the locator. Find the Box under which there are list names.
        //2. Define a WebElement and put the box under it. 3. Now create a list of WebElement which has common tags under this box.
        //Here first we create an element of the whole box and second create a list of WebElements under that....use a loop
            WebElement box = driver.findElement(By.xpath("//*[@id=\"base\"]/div/div/div/div[2]/div[5]/div/div[2]"));
            List<WebElement> countries = box.findElements(By.tagName("a"));
            for (WebElement c : countries){
                System.out.println(c.getText());
            }
            driver.close();
    }catch (Exception e){
        System.out.println("THe exception e is: "+e);
    }
}
}