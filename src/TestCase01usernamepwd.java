import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.sql.Array;
import java.util.ArrayList;

public class TestCase01usernamepwd {
    public static void main(String[] args) {
        try {
            System.setProperty("webdriver.chrome.driver", "C:/automation/chrome/chromedriver.exe");
            WebDriver driver = new ChromeDriver();
            driver.get("https://webdriveruniversity.com");
            driver.findElement(By.id("login-portal")).click(); //Clicking Login Link
            ArrayList<String> tab = new ArrayList<>(driver.getWindowHandles());
            driver.switchTo().window(tab.get(1)); //driver.switchto.window(tab.get(1) ....
            driver.findElement(By.id("text")).sendKeys("");
            driver.findElement(By.id("password")).sendKeys("");
            driver.findElement(By.id("login-button")).click();
            Thread.sleep(2000);
            //An alert appears whose text validates the test process
            Alert alert = driver.switchTo().alert();
            System.out.println(alert.getText());
            alert.accept();

            //Taking Snapshopt of the result
            File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(src, new File("C:\\snapshots\\1.jpg"));

        } catch (Exception e) {
            System.out.println("The Exception is: " + e);
        }
    }
}
