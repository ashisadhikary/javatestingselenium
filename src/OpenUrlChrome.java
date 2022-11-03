import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
public class OpenUrlChrome {
    public static void main(String[] args) {
        //1. First we have to define and initialize the browser's webdriver which is specific for each browser
        //2. Then create an object for the Webdriver and use that object for operations
        //1.
        try {
            System.setProperty("webdriver.chrome.driver", "C:\\automation\\chrome\\chromedriver.exe");
            //2.
            WebDriver driver = new ChromeDriver();
            //driver.navigate().to("https://javaguide.technologychannel.org/");
            driver.get("https://yahoo.com");
            //manage the size of browser
            driver.manage().window().maximize();

            driver.get("https://google.com");
            driver.manage().window().maximize();

            WebElement text = driver.findElement(By.name("q"));
            text.sendKeys("Download + Visio + Text Editor+ HTML");
            text.submit();
            //driver.
            //displaying Title
//            String Title = driver.getTitle();
//            System.out.println("The title is: "+Title);
        }catch (Exception e){
            System.out.println("The Exception is: "+e);
        }
    }
}
