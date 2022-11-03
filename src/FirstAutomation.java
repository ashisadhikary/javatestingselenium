import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
public class FirstAutomation {
    public static void main(String[] args) {
        try {
            System.setProperty("webdriver.chrome.driver", "C:\\automation\\chromedriver.exe");
            WebDriver driver = new ChromeDriver();
            driver.get("http://msn.com");
           //gets Title of the Webpage
            String a = driver.getTitle();
            System.out.println(a);
            //findElement
            driver.findElement(By.name ("MSN"));
        }catch( Exception e){
            System.out.println("The Exception is: "+e);
        }
    }

}
