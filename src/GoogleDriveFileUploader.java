import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import com.beust.ah.A;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

    public class GoogleDriveFileUploader {
        public static void main(String[] args) throws InterruptedException {

            // Launching browser
            System.setProperty("webdriver.gecko.driver", "C:\\automation\\firefox\\geckodriver.exe");
            WebDriver driver = new FirefoxDriver();
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            // Loading Google
            driver.get("https://www.google.com/");

            // Google Apps icon
            driver.findElement(By.xpath("/html/body/div[1]/div[1]/div/div/div/div[2]/div/div/div/a")).click();

            //only two frames available: parent frame and apps frame, switch frames
            driver.manage().window().maximize();
            driver.switchTo().frame(1);

            //Use manual xxpath, put it in the list and
            List<WebElement> copyAll = driver.findElements(By.xpath("//div[@id='yDmH0d']"));
            // why doesn't the class/classname work at all--> List<WebElement> copyAll = driver.findElements(By.className("VUoKZ"));
            for (WebElement appsName : copyAll) {
                System.out.println(appsName.getText());

                Actions drive = new Actions(driver);
                WebElement googleDrive = driver.findElement(By.xpath("//a[@href='https://drive.google.com/']"));
                drive.moveToElement(googleDrive);
                drive.click().perform();
                Thread.sleep(3000);
                WebElement signIn = driver.findElement(By.xpath("/html/body/header/div[3]/div/div[4]/div/a[1]"));
                signIn.click();
                //new tab opened so gotta switch
                ArrayList<String> tab = new ArrayList<>(driver.getWindowHandles());
                driver.switchTo().window(tab.get(1));
                driver.findElement(By.id("identifierId")).sendKeys("lhamutsering.ptk");
                driver.findElement(By.cssSelector(".VfPpkd-LgbsSe-OWXEXe-k8QpJ > span:nth-child(4)")).click();

                //to navigate back

                driver.switchTo().window(tab.get(0));
                driver.navigate().back();
                int size2 = driver.findElements(By.tagName("iframe")).size();
                System.out.println(size2);
                driver.switchTo().frame(0);
                driver.findElement(By.xpath("/html/body/div/c-wiz/div/div/c-wiz/div/div/div/div[2]/div[2]/button")).click();
            }
        }
    }


