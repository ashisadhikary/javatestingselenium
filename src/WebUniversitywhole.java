import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.ArrayList;

class Testsactivity{
    //A public WebDriver to use in all methods
    public static WebDriver driver = new ChromeDriver();
    //A Public ArrayList to
    public static ArrayList<String> tabs;

    void Contactus() {
        try {
            driver.get("https://webdriveruniversity.com");
            driver.findElement(By.xpath("//*[@id=\"contact-us\"]/div/div[1]/h1")).click();
            driver.manage().window().maximize();
            System.out.println("Clicked COntact US: "+driver.getWindowHandle());
            //First we have to switch to the new TAB becasue it is a new TAB in the browser
            //driver.getWindowHandles() is used to create a list of different instances of TABS of webpages
            windowhandle(); //Calls Method which activates the newly opened TAB from the main URL. If multiple pages are opened at once, we need a loop
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
            System.out.println("Switched to the new TAB: "+driver.getWindowHandle());
            // We perform three stage of tests in COntact US: a. data entry and reset button driver. wrong email address and Submit and
            //c. Right Entry and Submit. We will navigate the page backwards after b for second time entry. For multiple tabs see multipleTabs.java
            //for the same contact_US form
            //a. data entry and reset button
            driver.findElement(By.xpath("//*[@id=\"contact_form\"]/input[1]")).sendKeys("Rama");//Name Inputbox
            driver.findElement(By.xpath("//*[@id=\"contact_form\"]/input[2]")).sendKeys("Shrestha");//Last name Inputbox
            driver.findElement(By.xpath("//*[@id=\"contact_form\"]/input[3]")).sendKeys("rama_shrestha@gmail.com");//Email Box
            driver.findElement(By.xpath("//*[@id=\"contact_form\"]/textarea")).sendKeys("NIce Website"); //Message Box
            driver.findElement(By.xpath("//*[@id=\"form_buttons\"]/input[1]")).click(); //Reset Button
            System.out.println("--------Reset Test---------");
            System.out.println(driver.getCurrentUrl());
            System.out.println(driver.getTitle());
            System.out.println(driver.getWindowHandles());
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
            //b . test with wrong email add and Submit BUtton
            driver.findElement(By.xpath("//*[@id=\"contact_form\"]/input[1]")).sendKeys("Rama");//Name Inputbox
            driver.findElement(By.xpath("//*[@id=\"contact_form\"]/input[2]")).sendKeys("Shrestha");//Last name Inputbox
            driver.findElement(By.xpath("//*[@id=\"contact_form\"]/input[3]")).sendKeys("rama_shresthacom");//Email Box
            driver.findElement(By.xpath("//*[@id=\"contact_form\"]/textarea")).sendKeys("NIce Website"); //Message Box
            driver.findElement(By.xpath("//*[@id=\"form_buttons\"]/input[2]")).click(); //Submit Button
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
            System.out.println("----Wrong Email Click Submit--------");
            System.out.println(driver.getCurrentUrl());
            System.out.println(driver.getTitle());
            System.out.println(driver.getWindowHandles());
            //Now navigate to the previous page. The message is displayed in a webpage not an ALERT
            driver.navigate().back();
            //Enter proper value now and Submit. FOr navigate.back other text remain same in the inputbox. Just need to update the email.
            //check the text in the inputbox
            driver.findElement(By.xpath("//*[@id=\"contact_form\"]/input[3]")).clear(); //Clear Email Box
            driver.findElement(By.xpath("//*[@id=\"contact_form\"]/input[3]")).sendKeys("rama_shrestha@gmail.com");//Email Box
            driver.findElement(By.xpath("//*[@id=\"form_buttons\"]/input[2]")).click(); //Submit Button
            System.out.println("----Right Input CLick Submit--------");
            System.out.println(driver.getCurrentUrl());
            System.out.println(driver.getTitle());
            System.out.println(driver.getWindowHandles());
            driver.close();

        } catch (Exception e1) {
            System.out.println("The exception e1 is: " + e1);
        }
    }
        void Loginportal(){
        //Click the Login Portal to test the Login Screen
            System.out.println("----------2. Login Portal---------");
            driver.switchTo().window(tabs.get(0));
            System.out.println(driver.getTitle());
            System.out.println(driver.getCurrentUrl());
            driver.findElement(By.id("login-portal")).click(); //Clicking Login Link
            windowhandle();
            System.out.println("After changing window tab:---");
            System.out.println(driver.getTitle());
            System.out.println(driver.getCurrentUrl());
//            tabs = new ArrayList<>(driver.getWindowHandles());
//            driver.switchTo().window(tabs.get(1));
            //Enter wrong set of usernames and passwords first and check
            driver.findElement(By.id("text")).sendKeys("wronguser");
            driver.findElement(By.id("password")).sendKeys("wrongpass");
            driver.findElement(By.id("login-button")).click();
            //Now there is an alert. In such cases we have to switch to ALERT and OK it (for this type of alert).
            driver.switchTo().alert().accept();
            //Now enter the correct username and password
            driver.findElement(By.id("text")).sendKeys("webdriver");
            driver.findElement(By.id("password")).sendKeys("webdriver123");
            driver.findElement(By.id("login-button")).click();
            System.out.println("--------After coreect un and pwd------");
            System.out.println(driver.switchTo().alert().getText());
            driver.switchTo().alert().accept();
            driver.close();
        }
        void buttonCLicks() throws InterruptedException {
            System.out.println("------Button Clicks------");
            driver.switchTo().window(tabs.get(0)); //Again Activate the Original Window
            driver.findElement(By.id("button-clicks")).click();
            windowhandle();
            //Create a webelement and use xpath to click the first button
            WebElement button = driver.findElement(By.xpath("//*[@id=\"button1\"]"));
            button.click();
            Thread.sleep(3000);
            //A new Webelement pops up, which is not an alert (for alert one cant click the webpage unless the alert is solved
            //following code clicks on the display popped up
            driver.findElement(By.xpath("//*[@id=\"myModalClick\"]/div/div/div[3]/button")).click();
            //For second button the question asks to use the javascript and css locator
            //For cssSelector we can use # for id, and . for name
            //CSS format is: css = "element_name[attribute ='value']"
            //e.g. "input[first_name ='raju']"
            driver.findElement(By.cssSelector("span[id='button2']")).click();
            //driver.findElement()



        }
        //THis funciton will create an array of the windowhandles and store them in tabs. Also it always activates the newly opened TAB.
        //Suitable to deal with two tabs at a time. If more than 2 are opened we need a loop and condition to select appropriate TAB
        public static void windowhandle(){ //This function creates an array of WindowHandles and activates the newly opened TAB always.
        tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
    }
}


class WebUniversitywhole {
    public static void main(String[] args) {
        try {
            System.setProperty("webdriver.chrome.driver", "C:\\automation\\chrome\\chromedriver.exe");
            Testsactivity test = new Testsactivity();
            //WebDriver driver = new ChromeDriver();
            //driver.get("https://webdriveruniversity.com");
            //For Contact US Link Testing, Passing WebDriver driver to the method to use the same browser session
            test.Contactus();
            //For Login Page Testing
            test.Loginportal();
           //for Button Testing
            test.buttonCLicks();

        }catch (Exception e){
            System.out.println("The Exception is: "+e);
        }

    }
}
