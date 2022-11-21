import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

//OPen Google Map, search restuarants near me, and display restuarants within 5 mile distance
public class Maptest {
    public static void main(String[] args) {
        try {
            System.setProperty("webdriver.chrome.driver", "C:\\automation\\chrome\\chromedriver.exe");
            WebDriver driver = new ChromeDriver();
            //open the map website
            driver.get("https://maps.google.com");
            driver.manage().window().maximize();
            WebElement searchBox = driver.findElement(By.name("q"));
            searchBox.sendKeys("Restuarants near me");
            driver.findElement(By.xpath("//*[@id=\"searchbox-searchbutton\"]")).click();
            Thread.sleep(4000);
            //Create a list of names displayed
            List<WebElement> names = driver.findElements(By.xpath("//*[@id=\"base\"]/div/div/div/div[2]/div[5]/div/div[2]/div[3]/div[2]/div/ul"));
            System.out.println(names.size());
            //Now create a loop with WebElement data type and print the getText of that WebElement. NB: The names data type (list) doesn't have getText function.
            for (WebElement current_name : names){
                System.out.println(current_name.getText());
            }

            // Use Filers of Price
            driver.findElement(By.xpath("//*[@id=\"QA0Szd\"]/div/div/div[1]/div[2]/div/div[1]/div/div/div[2]/div[1]/div[2]/div/div[5]/div[2]/div[1]/div/button")).click();

        }catch (Exception e){
            System.out.println("The exceprion is: "+e);
        }
    }
}
