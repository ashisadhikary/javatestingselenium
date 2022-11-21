import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.List;

    public class GetAllGoogleAppNames {


        public static void main(String[] args) {

            // Launching browser
            System.setProperty("webdriver.gecko.driver", "C:\\automation\\firefox\\geckodriver.exe");
            WebDriver driver = new FirefoxDriver();

            // Loading Google
            driver.get("https://www.google.com/");
            int size = driver.findElements(By.tagName("iframe")).size();
            System.out.println(size);

            // Google Apps icon
            driver.findElement(By.xpath("/html/body/div[1]/div[1]/div/div/div/div[2]/div/div/div/a")).click();

            //only two frames available: parent frame and apps frame, switch to apps icon frame
            int size2 = driver.findElements(By.tagName("iframe")).size();
            System.out.println(size2);
            driver.manage().window().maximize();
            driver.switchTo().frame(1);

            //put all the apps in a list and print ea
            List<WebElement> copyAll = driver.findElements(By.xpath("//div[@id='yDmH0d']"));
            for (WebElement appsName : copyAll) {
                System.out.println(appsName.getText());}

        }
    }



