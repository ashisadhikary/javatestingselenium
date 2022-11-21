import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;
import java.util.List;

public class Googlefavbooksearch {
    public static void main(String[] args) {
        try {
            System.setProperty("webdriver.chrome.driver", "C:/automation/chrome/chromedriver.exe");
            //new Object for webdriver
            WebDriver driver = new ChromeDriver();
            driver.get("http://google.com");
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
            //create a webElement object to search the searchbox in google
            // The name q is the name of the name assigned to the searchbox by google.com
            WebElement searchbox = driver.findElement(By.name("q"));
            searchbox.sendKeys("The End of History");
            searchbox.submit();
            //driver.manage().window().wait();
            //Thread.sleep(3000);
            driver.findElement(By.xpath("/html/body/div[4]/div[2]/div/div[2]/div/div/div[1]/div/div/div/a")).click();
            //Print the size of iframes
            int frame_size = driver.findElements(By.tagName("iframe")).size();
            System.out.println(frame_size);

            //First create a list of the items inside the nine-dots
            //1. change to the new frame 2. select the xpath of the frame which has that list and 3. find the list
            //We have to make sure that we select the locator into a webelelement under which there is this list
            //driver.switchTo().frame(app);
            //Its hard to locate xpath of the menu inside the google as it disappears once the inspect is clicked. We have to open the menu and
            //right click on the menu and select inspect which will open the <ul> in the inspect menu which is the desired locator.
            //To find the xpath we select the list (ul) which contains the list as List <WebElement> than we print the <li> inside it.
            driver.switchTo().frame("app");
            WebElement frame_1 = driver.findElement(By.xpath("//*[@id=\"yDmH0d\"]/c-wiz/div/div/c-wiz/div/div/ul[1]"));
            //WebElement frame_1 = driver.findElement(By.xpath("//*[@id=\"gb\"]/div/div[2]/iframe"));
            List<WebElement> item_names = frame_1.findElements(By.tagName("li"));
            for (WebElement c : item_names)
                System.out.println(c.getText());
            System.out.println("---------------------");
            //Now clicking the Account Menu.
            WebElement element1 = driver.findElement(By.xpath("//*[@id=\"yDmH0d\"]/c-wiz/div/div/c-wiz/div/div/ul[1]/li[1]/a"));
            System.out.println(element1.getText());
            //System.out.println(driver.getTitle());
            element1.click();
            System.out.println("---------------");
            //Now using mouse hover to click another menu. 1. navigate back 2. a new frame pops up. press Ctrl+f and type iframe in inspect menu to select
            //appropriate frame name. here it is callout. 3. again press the nine dots and use mouse hover to press some other menu now (Youtube).
            driver.navigate().back();
            driver.switchTo().frame(0); //go to the root frame
            System.out.println(driver.getCurrentUrl());
            //select the callout frame
            driver.switchTo().frame("callout");//switch to the frame
            WebElement no_Thanks = driver.findElement(By.xpath("//*[@id=\"yDmH0d\"]/c-wiz/div/div/c-wiz/div/div/div/div[2]/div[2]/button"));
            System.out.println(no_Thanks.getText());
            no_Thanks.click();
            //Now shift to the 9 dots frame
            driver.switchTo().frame("app");
            driver.findElement(By.xpath("/html/body/div[4]/div[2]/div/div[2]/div/div/div[1]/div/div/div/a")).click(); //click the nine dots
            //now locate youtube by xpath inside the 9 menu
            WebElement element2_hover = driver.findElement(By.xpath("//*[@id=\"yDmH0d\"]/c-wiz/div/div/c-wiz/div/div/ul[1]/li[4]/a"));
            System.out.println(element2_hover.getText());
            //use hover and click perform
            Actions action = new Actions(driver);
            action.moveToElement(element2_hover).click().perform();
        }catch (Exception e){
            e.notifyAll();
        }

    }
}
