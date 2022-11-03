import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CopyprineText {
    public static void main(String[] args) {
        try{
            System.setProperty("webdriver.chrome.driver", "C:\\automation\\chrome\\chromedriver.exe");
            WebDriver driver = new ChromeDriver();
            driver.get("http://www.webdriveruniversity.com/Accordion/index.html");
            //First Click the BUtton
            WebElement Cucumber = driver.findElement(By.id("cucumber-accordion"));
            Cucumber.click();
            //Now the xpath in which the text resided
            WebElement text = driver.findElement(By.xpath("//*[@id=\"cucumber-testing-description\"]/p"));
            String text1 = text.getText();
           // System.out.println(text);
            System.out.println("The Text is: "+text1);


        }catch(Exception e){
            System.out.println("Exception"+e);
        }

    }
}
