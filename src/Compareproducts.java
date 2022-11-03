import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

//Compare and print the price of same item in two different web pages
public class Compareproducts {
    public static void main(String[] args) {
        try {
            String searchItem = "Iphone 14 16 GB Blue";
            String web1 = "https://amazon.com";
            String web2 = "https://flipkart.com";
            //INitialize WebDirver
            System.setProperty("webdriver.chrome.driver", "C:\\automation\\chrome\\chromedriver.exe");
            WebDriver driver = new ChromeDriver();
            //OPen webpages and search the same item
            driver.get(web1);
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
            WebElement search = driver.findElement(By.id("twotabsearchtextbox"));
            search.submit();
            //Now get the value of the first item displayed
            //First we get the value on text. Than we text (parse) the text into number. Make sure to remove commas in the process
            //We use getText() for that
            Thread.sleep(5000);
            String value1 = driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[1]/div[1]/div/span[1]/div[1]/div[3]/div/div/div/div/div/div/div/div[2]/div/div/div[3]/div[1]/div/div[1]/div/a/span/span[1]")).getText();
            System.out.println(value1);
            //Double price = Double.parseDouble(value1);
            //System.out.println("The value from " + web1 + " is" + price);
            //Now the second web to search the same price
            driver.get(web2);
            driver.manage().window().maximize();

        }catch (Exception e){
            System.out.println("Exception"+e);
        }





    }
}
