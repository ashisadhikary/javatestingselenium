import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CheckBox {
    static WebDriver driver;
    public static void main(String[] args) {
        try {
            System.setProperty("webdriver.chrome.driver", "C:/automation/chrome/chromedriver.exe");
            driver = new ChromeDriver();
            //1. Open the website
            driver.get("https://www.webdriveruniversity.com/Dropdown-Checkboxes-RadioButtons/index.html");
            driver.manage().window().maximize();
            //The Default condition is checked in
            WebElement check1 = driver.findElement(By.cssSelector("#checkboxes > label:nth-child(5) > input[type=checkbox]"));
            check1.click(); //It removes the check
            Thread.sleep(2000);
            //NOw check the fourth checkbox
            WebElement check2 = driver.findElement(By.xpath("//*[@id=\"checkboxes\"]/label[4]/input"));
            check2.click();
            Thread.sleep(2000);
            //close the browser
            driver.close();
        } catch (Exception e){
            System.out.println("The Exception: "+e);
        }
    }
}
