import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class Listofnames {
    public static void main(String[] args) {
        try {
            System.setProperty("webdriver.chrome.driver", "C:/automation/chrome/chromedriver.exe");
            WebDriver driver = new ChromeDriver();
            //1. Open the website
            driver.get("http://www.webdriveruniversity.com/Data-Table/index.html");
            driver.manage().window().maximize();
            //Wait Implicit
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
            //2. Find The List element
            List< WebElement> names = driver.findElements(By.xpath("/html/body/div/div[9]/div[1]/ul[3]/ul"));
            for (WebElement current_name : names)
                System.out.println(current_name.getText());
            }catch(Exception e){
            System.out.println(e);
        }
        }
}
