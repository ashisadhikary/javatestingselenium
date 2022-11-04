import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class MouseHover {
    public static void main(String[] args) {
        try {
            System.setProperty("webdriver.chrome.driver", "C:\\automation\\chrome\\chromedriver.exe");
            WebDriver driver = new ChromeDriver();
            //OPen the webpage
            driver.get("https://webdriveruniversity.com/Actions/index.html");
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
            //HOver is done with Action class and movelement function.
            //a. create a Webelement locating the hover box (location). b. Create Actions object
            //and pass the WebDriver Object (driver in this case) c. Use action object to movetoelement(of the hover) and perform
            WebElement hover = driver.findElement(By.xpath("//*[@id=\"div-hover\"]/div[1]/button"));
            Actions action = new Actions(driver);
            action.moveToElement(hover).perform();
            Thread.sleep(2000);
            driver.findElement(By.xpath("//*[@id=\"div-hover\"]/div[1]/div/a")).click();
            Thread.sleep(2000);
            //Printe Text of Alert and Close it
            Alert alert = driver.switchTo().alert();
            System.out.println(alert.getText());
            alert.accept();
            //Close the Driver
            Thread.sleep(2000);
            driver.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
