import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;

public class ScreenshotmultipleHash {
    public static void main(String[] args) throws IOException {
        System.setProperty("webdriver.chrome.driver", "C:\\automation\\chrome\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        //Create a hash of URL's and their names for flename
        HashMap <String, String> websites = new HashMap<String, String>();
        websites.put("facebook","https://facebook.com");
        websites.put("youtube", "https://youtube.com");
        websites.put("justwatch", "https://justwatch.com");
        //Inout these URLs into the hash variable
        //In hashmap the data is stored in 2 dimension, its called keys and values.
        // The first sets are keys like ("facebook", youtube and justwatch in this case
        // the second set is called Values (https://youtube.com, https://facebook.com and ....)
        //The first set is called values (facebook, youtube, justwatch) in this case.
        System.out.println(websites.keySet()); //prints facebook, youtube and justwatch
        System.out.println("--------------");
        for (String web : websites.keySet()){ //they are the sets of keys (see above for keys).. it is the firstdimension
            System.out.println(web); //print initial keys
            System.out.println(websites.get(web));//print values. Here websites.get(web) means to get the value of key web.
            //OPen the Website
            driver.get(websites.get(web)); //open the websites

            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
            //Take Screenshot of the opened webpage
            File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(src, new File ("C:\\snapshots\\"+web+1+".jpg"));
        }
     }
}
