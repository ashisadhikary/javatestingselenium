import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import java.time.Duration;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.concurrent.TimeUnit;

public class Googlefavbooksearch {
    public static void main(String[] args) {
        try {
            //System.setProperty("webdriver.gecko.driver", "C:/automation/firefox/geckodriver.exe");
            //WebDriver driver = new FirefoxDriver();

            System.setProperty("webdriver.chrome.driver", "C:/automation/chrome/chromedriver.exe");
            WebDriver driver = new ChromeDriver();
            driver.get("http://google.com");
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            //Open the Google apps icon
            driver.findElement(By.xpath("//*[@id=\"gbwa\"]/div/a")).click();
            //Now change to the frame inside this APP, the name of this frame is APP.
            //To find that iframe name, after clicking the nine dots and opening menus, right click on the new frame. As shown in
            //guru99.com the presence of frame in the click menu validates its a frame. Inside the inspect page press Ctrl + f and
            //type iframe. It will traverse you to different frames and the name of the frame.
            driver.switchTo().frame("app");
            //Print the names of the app menus first. To print the list, first we have to select the component that has all the lists contained
            //Here, the main app frame defines a ul which has different menus as lists. So the below xpath is the xpath of ul.
            //after selecting ul we collect the list of menus through common factors on it, here it is <li> tag
            WebElement iframe1 = driver.findElement(By.xpath("//*[@id=\"yDmH0d\"]/c-wiz/div/div/c-wiz/div/div/ul[1]"));
            List<WebElement> menu_names = iframe1.findElements(By.tagName("li"));
            for (WebElement a: menu_names) {
                System.out.println(a.getText());
                }
            System.out.println("--------------------");
            //Now click the Account menu inside this frame. Find the xpath manually.
            driver.findElement(By.xpath("//*[@id=\"yDmH0d\"]/c-wiz/div/div/c-wiz/div/div/ul[1]/li[1]/a")).click();
            //Now the second part is to traverse back into the main page and use mouse hover to open another menu tab youtube
            driver.navigate().back();
            //now get the size of the frame
            System.out.println(driver.findElements(By.tagName("iframe")).size());
            //The frame selected is still "APP" so we can just click the menu but this time we use mouse hover
            //first click on the nine dots. We have to go to the earlier frame, here we will use mouse hover to click
            driver.switchTo().frame(0);
            driver.navigate().refresh(); //refresh the page because it showed error of not identifying the iframe
            Actions click = new Actions(driver);
            WebElement nine_dots = driver.findElement(By.cssSelector("#gbwa > div > a")); //locating nine dots with another tag
            click.moveToElement(nine_dots);
            click.click().perform();
            //clicking the youtube menucd 
            driver.switchTo().frame("app");
            driver.findElement(By.cssSelector("#yDmH0d > c-wiz > div > div > c-wiz > div > div > ul.LVal7b.u4RcUd > li:nth-child(4) > a > div > span")).click();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

    }
}
