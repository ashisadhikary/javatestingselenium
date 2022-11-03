import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

class Browser {
    //Attributes
    }

class Chrome extends Browser {
    String driver() {
        return ("webdriver.chrome.driver");
    }
   String location() {
        return ("C:\\automation\\chrome\\chromedriver.exe");
    }
}

class Mozilla extends Browser {
    String driver() {
        return ("webdriver.gecko.driver");
    }

    String location() {
        return ("C:\\automation\\chrome\\chromedriver.exe");
    }
}

public class AutomationMain {
    public static void main(String[] args){
        //For Chrome Driver now we can create a Chrome Object and directly call the path and location of the WebDriver
        try {
            Chrome c = new Chrome();
            String drv = c.driver(); //calls function driver for class Chrome with object c and stores in drv
            String loc = c.location();//call location of webdriver path for Chrome
            System.setProperty(drv, loc);
            WebDriver drive = new ChromeDriver();
            drive.get("https://hotmail.com");
        }catch(Exception e){
            System.out.println("THe Exception is: "+e);
        }
        //For Mozilla Browser we can create an object and call their webdriver and location for use anywhere
        try{
            //Below 4 lines are to set the
            Mozilla m = new Mozilla();
            String drv = m.driver();
            String loc = m.location();
            System.setProperty(drv, loc);
            WebDriver drive = new FirefoxDriver();
            drive.get("https://hotmail.com");

        }catch (Exception e){
            System.out.println("The Exception is: "+e.getMessage());
        }
    }
}

