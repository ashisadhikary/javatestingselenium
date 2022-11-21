import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Mozillatest {
    public static void main(String[] args) {
        System.setProperty("webdriver.gecko.driver", "C:\\automation\\firefox\\geckodriver.exe");
        WebDriver driver = new FirefoxDriver();
        driver.get("https://google.com");
        driver.manage().window().maximize();

    }
}
