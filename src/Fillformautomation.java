import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Fillformautomation {
    //Adding data in a form where the name of a submit button was absent (use xpath location for that)

        public static void main (String[]args){
            try{
        System.setProperty("webdriver.chrome.driver", "C:/automation/chrome/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://webdriveruniversity.com/Contact-Us/contactus.html");

        //Insert names in text box
                WebElement name = driver.findElement(By.name("first_name"));
                name.sendKeys("Rama");
                WebElement lname = driver.findElement(By.name("last_name"));
                lname.sendKeys("Shrestha");
                WebElement email = driver.findElement(By.name("email"));
                email.sendKeys("rama.shrestha@gmail.com");
                WebElement comment = driver.findElement(By.name("message"));
                comment.sendKeys("I am unable to locate certain information in this website");
                //For some Webelements the name and id arent given. For them we need to find their xpath.
                //in this page no name is given for buttons. We have to right click that element (button in this case)
                // and copy its xpath and paste it into the below xpath string
                WebElement button1 = driver.findElement(By.xpath("//*[@id=\"form_buttons\"]/input[2]"));
                button1.submit();
    }catch(Exception e){
            System.out.println("The Exception is: "+e);
        }

    }
}
