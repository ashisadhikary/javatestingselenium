import com.beust.jcommander.Parameters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Crossbrowser {
    public WebDriver driver;
    //@Parameters("Browser")
        //Select the appropriate browser
    @BeforeClass
    void Beforeclass(String Browser) {
        if (Browser.equalsIgnoreCase("firefox")) {
            driver = new FirefoxDriver();
        } else if (Browser.equalsIgnoreCase("chrome")) {
            driver = new ChromeDriver();
        } else if (Browser.equalsIgnoreCase("edge")) {
            driver = new EdgeDriver();
        }
        driver.get("https://google.com");
    }
    //test the
    @Test
                void Test(){
            driver.findElement(By.name("q")).sendKeys("Best Books 2022");
        }
        @AfterTest
                void Quit(){
                    driver.quit();
    }

}
