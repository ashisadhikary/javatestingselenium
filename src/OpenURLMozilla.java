import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class OpenURLMozilla {
    public static void main(String[] args) {
        //I tried for Mozilla but didnt work. Can we try this in next class.
        try {
            System.setProperty("webdriver.gecko.driver", "C:\\automation\\firefox\\geckodriver.exe");
            WebDriver driver = new FirefoxDriver();
            //driver.navigate().to("https://javaguide.technologychannel.org/");
            
            driver.get("https://javaguide.technologychannel.org/");
        }catch(Exception e){
            System.out.println("The exception is: "+e);

        }
    }
}
