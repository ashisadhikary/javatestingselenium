//TO fetch lists, we use the LIST data Structure and <webriver>.findelements (not findelelemt) which locating the locator.
//Now the name in the List is returned by function getText. We dont have getText in the WebElement List data type. So
//we have to change the List into a WebElement data type to run the getText() function under that object
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.LinkedList;
import java.util.List;
class LoadBrowser {
    static public WebDriver driver = new ChromeDriver();
        //Opens the Webpge OR URL
        void initchrome () {
            try {
                driver.get("https://justwatch.com");
                driver.manage().window().maximize();
                //((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight)");
            }catch (Exception e){
                System.out.println("The Exception is: "+e);
            }
    }
    //Checks the List inside the Column and Prints it in console
        void checklists () {
            try{
                List<WebElement> names = driver.findElements(By.xpath("//*[@id=\"base\"]/div/div/div/div[2]/div[5]/div/div[2]/div[3]/div[2]/div/ul"));
                System.out.println(names.size());
                //Now create a loop with WebElement data type and print the getText of that WebElement. NB: The names data type (list) doesnt have getText function.
                for (WebElement current_name : names){
                    System.out.println(current_name.getText());
                }
                    //THus loop doesnt display the name of the List, it displays a path only. WHY?
//                for(int i = 0; i<names.size(); i++) {
//                System.out.println(names.get(i));
//                  }
                }catch (Exception e){
                System.out.println("THe Exception is: "+e);
            }
            driver.close();
    }
    }
public class CountryList {
    //Fetch a list from a WebElement. If we have to fetch more than one list, we use data structures like Linklist, Array
    public static void main(String[] args) {
        //Set the WebDriver and Location
        try {
            //Five steps: 1. Initialize and run the URL 2. Look for the list item (ul or il) in webpage
            //3. Fetch the name of the List items inside a link //4 Convert the List into WebElement datatype(see line 30,31)and topmost comments of this page
            // . 5. Display the link
            System.setProperty("webdriver.chrome.driver", "C:\\automation\\chrome\\chromedriver.exe");
            LoadBrowser l = new LoadBrowser();
            l.initchrome(); //to initialize and get the required URL
            l.checklists(); //to view and display the list
            Thread.sleep(2000);
        }catch (Exception e){
            System.out.println("The Exception is: "+e);
    }
    }
}
