import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Googlemapsearch {
    public static void main(String[] args) {
        try {
            System.setProperty("webdriver.chrome.driver", "C:/automation/chrome/chromedriver.exe");
            WebDriver driver = new ChromeDriver();

            //OPen any webpage or site
            driver.get("https://maps.google.com");
            driver.manage().window().maximize();
            //Search for a particular thing on the map
            //1. FInd the identifier (locator) for the Search Text box where we enter text for search
            //There are various ways like Name, ID to uniquely identify them.
            //We can either create a new object for WebElement or Directly use the WebDriver object to identify the element.
            //Like driver.findElement(By.id("ID_NAME")); will identify BUT to pass value we need an object of the
            //WebElement. So it is better to create an object of the WebElement and using that object to either identify
            //the locator or pass value for test

            WebElement locator = driver.findElement(By.id("searchboxinput"));
            locator.sendKeys("Apartment near me");
            //Only Clicking Submit doesnt work as Maps.Google wants users to press the arrow button nearby so
            //here we have to identify that button first and click enter in it i.e. submit
            locator = driver.findElement(By.xpath("//*[@id=\"hArJGc\"]/img"));
            locator.submit();

        }catch (Exception e){
            System.out.println("The Exception is: "+e);
        }
    }
}
