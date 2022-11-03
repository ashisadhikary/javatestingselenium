import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.util.ArrayList;

public class Screenshotmultiple {
    public static void main(String[] args) {
        try {
            System.setProperty("webdriver.chrome.driver", "C:\\automation\\chrome\\chromedriver.exe");
            WebDriver driver = new ChromeDriver();
            //1. Open the website
            String[] sites = new String[]{"https://facebook.com", "https://youtube.com", "https://hotmail.com", "https://justwatch.com"};
            for (int i = 0; i<sites.length; i++){
                System.out.println(sites[i]);
                driver.get(sites[i]); // To open Specific Files
                File src = ((TakesScreenshot) driver).getScreenshotAs((OutputType.FILE));
                FileUtils.copyFile(src, new File ("C:\\snapshots\\"+sites[i].substring(7)+".jpg")); //substr is used because :// symbols arent allowed in file name
                }

             //Create a Screenshot

           // File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE); //Create a screenshot
            //FileUtils.copyFile(src, new File("C:\\snapshots\\google.jpg")); //Copy that screenshot to the path
        }catch(Exception e){
            System.out.println("THe Exception is: "+e);
        }
    }

}
