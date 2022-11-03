import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Autocomplete {
    public static void main(String[] args) {
        try {
            System.setProperty("webdriver.chrome.driver", "C:/automation/chrome/chromedriver.exe");
            WebDriver driver = new ChromeDriver();
            //1. Open the website
            driver.get("http://www.webdriveruniversity.com/Autocomplete-TextField/autocomplete-textfield.html");
            driver.manage().window().maximize();

            //Select the textbox
            driver.findElement(By.name("food-item")).sendKeys("A");
            driver.findElement(By.xpath("//*[@id=\"myInputautocomplete-list\"]/div[1]")).click();

            //Button
            driver.findElement(By.id("submit-button")).click();
            //However the list of the auto select can also be displayed
        } catch (Exception e) {
            System.out.println(e);
        }

    }
}
