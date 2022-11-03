import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;

//THis program simultaneously tests the username and password four times in the webpage provided.
//THis program has an Alert i.e. after tester gives input and password in the webpage an alert is displayed.
//That alert says validation failed in case of wrong un or pwd and validation successfull in case of right.
//The issue is for every Alerts, an Exception is formed which doesnt allow the program to move further and terminates.
//So here the alert is handled and four consequtive un/pwd are tested. For first un and pwd the alert says invalid which is
//handled by accepting the alert (it can also be checked and handled via a method called isAlertPresent()).
//This program utilizes OOP where a method called testunpwd is used in a class which is called by the object of this class
//passing username and passwords as parameters.
//Here the driver.get("webpage"); is run four times as the function is called four times? Does it mean four instances of
//chrome with that address will open, one new each time? NO ? WHY? -> becasue driver.get("URL") only transfers URL to
//the instance of the browser opened by object WebDriver driver = new ChromeDriver. So only one instance of page and the URL is
//get inside the address bar 4 times.
class Testunpwd{
    public static WebDriver driver = new ChromeDriver();

    //making this instance "driver" of WebDriver public and static
    //becasue it has to be accessed by the isAlertPresent Method outside
    //the testunpwd method.

    //Following function is used to test username and password four times.
    void testunpwd(String un1, String pwd1) {
        try {
            driver.get("https://webdriveruniversity.com/Login-Portal/index.html");
            WebElement un = driver.findElement(By.id("text"));
            WebElement pwd = driver.findElement(By.id("password"));
            WebElement btn = driver.findElement(By.id("login-button"));
            un.sendKeys(un1);
            pwd.sendKeys(pwd1);
            btn.click();
            //Here this prpgram uses following three lines to accept this alert and continue the program.
            //Howeever, it can also call a Boolean method, accept the alert as per type to use it (which I have commented this time)
            Thread.sleep(2000);
            Alert alert = driver.switchTo().alert();
            System.out.println("The Alert for username: "+un1+" and password: "+pwd1+" is: "+alert.getText());
            alert.accept();


            //For unknown alerts we can create a method and deal differently (like one alert wants user to enter data). Accepting alone
            // wont be enough. LIke this program could have also used the isalertpresent() method.
            // To remove alert the function isAlertPresent
            //boolean A = isalertpresent();
            driver.navigate().refresh();
        }catch(Exception e){
            System.out.println("The Exception is: "+e);
        }
    }
    //Here this function accepts the Alert (Accpeting Alert means pressing OK in the ALert Box). So handling Alert differs
    //with alert type. In this question, the alert has a simple OK so accept() might work. But for alerts with both YES/NO
    //or textbox in an alert, we need different ways to handle it:
    //https://www.guru99.com/alert-popup-handling-selenium.html This webpage has details on different alerts
//    public static boolean isalertpresent(){
//        try{
//            Alert alert = driver.switchTo().alert();  //As Alert is a different web element (not in the page we opened) we have
//                                                        //to change the Webdriver to this new object ALERT
//            System.out.println(alert.getText());
//            alert.accept();
//            return true;
//        }catch(Exception e1){
//            return false;
//        }
//    }
}

public class UserPwdtestassign {
    public static void main(String[] args) {
        try{
        System.setProperty("webdriver.chrome.driver", "C:/automation/chrome/chromedriver.exe");

        //Now find locators and pass values, Follow testcase01 sheet inside the folder for practising documentation of tests
        //We create an Object for the class Testunpwd to call the method testunpwd to check un and pwd
            Testunpwd test = new Testunpwd();
        test.testunpwd("",""); //Test Case 1.a

        test.testunpwd("webxyz","webdriver123"); //Test Case 1.b
            Thread.sleep(2000);
        test.testunpwd("webdriver123","testwebdriver"); //1.c
            Thread.sleep(2000);
        test.testunpwd("webdriver123",""); //1.d
            Thread.sleep(2000);
        test.testunpwd("","webdriver123"); //1.e
            Thread.sleep(2000);
        test.testunpwd("webdriver","webdriver123"); //1.f
            Thread.sleep(2000);
    } catch(Exception e){
            System.out.println("The Exception is: "+e);
        }
    }
}
