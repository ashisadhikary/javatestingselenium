import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

class Browserinfo{

        String location = "C:\\automation\\chrome\\chromedriver.exe";
        String web = "webdriver.chrome.driver";

}
public class Knowyourbrowser {
    public static void main(String[] args) {
        Browserinfo b = new Browserinfo();
        System.setProperty(b.web, b.location);
        ChromeOptions chr = new ChromeOptions();
        String s = chr.getBrowserName();
        System.out.println(s);
        String s1 = chr.getBrowserVersion();
        System.out.println(s1);
        //WebDriver driver = new ChromeDriver();
   }

}
