
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;

    public class TestNGMultipleBrowser {
        public WebDriver driver;
        @BeforeTest
        void beforeClass(String browser){
            if(browser.equalsIgnoreCase("firefox")){
                driver = new FirefoxDriver();
            }else if (browser.equalsIgnoreCase("chrome")){
                driver = new ChromeDriver();
            }else if (browser.equalsIgnoreCase("edge")){
                driver = new EdgeDriver();
            }
            driver.get("https://google.com");
        }
        @Test
        void search(){
            driver.findElement(By.name("q")).sendKeys("Hello");
        }
        @AfterTest
        void quit(){
            driver.quit();
        }

    }


