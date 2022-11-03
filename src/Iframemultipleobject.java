import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Iframemultipleobject {
    static WebDriver driver;
    public static void main(String[] args) {
        try {
            System.setProperty("webdriver.chrome.driver", "C:/automation/chrome/chromedriver.exe");
            driver = new ChromeDriver();
            //1. Open Page
            driver.get("https://thulotechnology.github.io/SampleTestWebsite/");
            driver.manage().window().maximize();
            //2. Switch to ourframe and click the first link
            driver.switchTo().frame("ourframe");
            WebElement link1 = driver.findElement(By.xpath("//*[@id=\"content-wrapper\"]/ul/li[1]/a"));
            link1.click();
            System.out.println(driver.getTitle());

            //Normally we change frames, get out from that frame but in this case the third link (element) is
            //also on the same frame so we dont exit In case to exit we have to:
            //3. Now come back to original page with frames
//            driver.switchTo().defaultContent();
            Thread.sleep(2000);
//            //4. Click the second link
            WebElement link2 = driver.findElement(By.xpath("//*[@id=\"content-wrapper\"]/ul/li[1]/ul/li[2]/a"));
            link2.click();
            System.out.println(driver.getTitle());
        }catch(Exception e){
            System.out.println("The Exception"+e);
        }

    }
}
