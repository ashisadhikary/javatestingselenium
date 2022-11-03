import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;
import java.util.ArrayList;

//Multiplt Tabs (not Multiple WebPages)
//Open webdriveruniversity. Click Contact US. A next page will open in new tab. This program deals with different tabs.

public class MultipleTabs {
    //static WebDriver driver;
    public static void main(String[] args) {
        try {
            System.setProperty("webdriver.chrome.driver", "C:/automation/chrome/chromedriver.exe");
            WebDriver driver = new ChromeDriver();
            //1. Open the website
            driver.get("https://webdriveruniversity.com");
            driver.manage().window().maximize();
            //2. Check the Contact US Link
            WebElement contact_us = driver.findElement(By.xpath("//*[@id=\"contact-us\"]/div/div[1]/h1"));
            contact_us.click();
            //Make a 2 second implicitwait
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
            //3. Now this contact us page will open in new TAB.
            //To Store different tabs we create a ArrayList and store each tab in each poin
            //getWindowHandles() method identifies distinct TABS in browser
            ArrayList<String> chrome_tabs; //Define an array variable ( = new ArrayList<String>(driver.getWindowHandles());)
            chrome_tabs = new ArrayList<>(driver.getWindowHandles());
            System.out.println("-------Different TABS------first time----- ");
            System.out.println("THe Array of TAB size: "+chrome_tabs.size());
            for (int i = 0; i<chrome_tabs.size(); i++)
            System.out.println("The "+i+ "th tab is: "+chrome_tabs.get(i));
            //Now Switch to the New TAB i.e. the Contact_US page. Array(0) is the first page and Array(1) is new.
            driver.switchTo().window(chrome_tabs.get(1)); //ArrayList_var.get(Integer i) where i is from 0 onwards
            //4. Now The WebElements for Contact US TAB in the same browser. New TAB (or webpage) in the same browser
           // WebElement name
            driver.findElement(By.xpath("//*[@id=\"contact_form\"]/input[1]")).sendKeys("Ashis");
            //WebElement cast
            driver.findElement(By.xpath("//*[@id=\"contact_form\"]/input[2]")).sendKeys("Adhikary");
            //WebElement email
            driver.findElement(By.xpath("//*[@id=\"contact_form\"]/input[3]")).sendKeys("ashis_adhikary@hotmail.com");
            //WebElement msg
            driver.findElement(By.xpath("//*[@id=\"contact_form\"]/textarea")).sendKeys("Your website is informative");
            //Reser the page for the first TEST
            driver.findElement(By.xpath("//*[@id=\"form_buttons\"]/input[1]")).click();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
            //7. Test Submit Button with wrong Email Address
            // WebElement name
            driver.findElement(By.xpath("//*[@id=\"contact_form\"]/input[1]")).sendKeys("Ashis");
            //WebElement cast
            driver.findElement(By.xpath("//*[@id=\"contact_form\"]/input[2]")).sendKeys("Adhikary");
            //WebElement email
            driver.findElement(By.xpath("//*[@id=\"contact_form\"]/input[3]")).sendKeys("ashis_adhikaryhotmail");
            //WebElement msg
            driver.findElement(By.xpath("//*[@id=\"contact_form\"]/textarea")).sendKeys("Your website is informative");
            //Click Submit Button
            driver.findElement(By.xpath("//*[@id=\"form_buttons\"]/input[2]")).click();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
            System.out.println("--------After wrong email and Submit click-------------");
            System.out.println(driver.getTitle());
            System.out.println(driver.getCurrentUrl());
            for (int i = 0; i<chrome_tabs.size(); i++)
                System.out.println(chrome_tabs.get(i));
            //Here rather than closing and opening the Contact_US TAB again we can navigate back to the same page and make other tests
            //BUt here we will be using different TABS
            //driver.navigate().back();
            driver.close();
            //Now after the worng entry the program gives a message (Not Alert).
            //8. Close this TAB again switch to first TAB and again click Contact_US for correct entry
            driver.switchTo().window(chrome_tabs.get(0)); //Will take to the Original first TAB
            //Now we have to click the Contact_US Link Again
            driver.findElement(By.xpath("//*[@id=\"contact-us\"]/div/div[1]/h1")).click();
            //9. Now we need to open the same contact_US page to enter correct data.
            // 9. But Now we cant use the existing Handle (and Array). So we deine a new array again. NB: OLD ARRAY DOESN'T WORK ONCE WE CLOSE THE TAB
            chrome_tabs = new ArrayList<>(driver.getWindowHandles());
            System.out.println(chrome_tabs);
            driver.switchTo().window(chrome_tabs.get(1)); //Now we have to reswitch to the Contact_US TAB again. The array used before doesnt work here.
            System.out.println("----------------------");
            System.out.println(driver.getTitle());
            System.out.println(driver.getCurrentUrl());
            System.out.println(driver.getWindowHandles());
            for (int i = 0; i<chrome_tabs.size(); i++)
            System.out.println(chrome_tabs.get(i));
            //10. Enter Real Correct Data
            //10. Point to Remember: THe TAB opened again has a new session so webElements used in previous session might not work in this case
            //Here, in previous session of COntact_US we used WebElements name, cast and so on..it might not work now. Here ,
            //we can directly send the keys
            driver.findElement(By.xpath("//*[@id=\"contact_form\"]/input[1]")).sendKeys("Ashis"); //sending name
            driver.findElement(By.xpath("//*[@id=\"contact_form\"]/input[2]")).sendKeys("Adhikary");
            driver.findElement(By.xpath("//*[@id=\"contact_form\"]/input[3]")).sendKeys("ashis_adhikary@hotmail.com");
            driver.findElement(By.xpath("//*[@id=\"contact_form\"]/textarea")).sendKeys("Informative Page");
            driver.findElement(By.xpath("//*[@id=\"form_buttons\"]/input[2]")).click();

            System.out.println("--After Entering Correct Data--------");
            System.out.println(driver.getCurrentUrl());
            System.out.println(driver.getTitle());
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
            driver.close();

            }catch (Exception e){
            System.out.println("The Exception is: "+e);
        }

    }
}
