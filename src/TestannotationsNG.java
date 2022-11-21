
import org.testng.annotations.*;

public class TestannotationsNG {
    //public static void main(String[] args) {
        @Test
                void myTest1(){
            System.out.println("1st test Case");
        }
        @BeforeTest
                void myTest2(){
            System.out.println("2nd test Case");

        }
        @AfterTest
                void myTest3(){
            System.out.println("3rd test Case");
        }
        @BeforeSuite
                void myTest4(){
            System.out.println("4th test Case");
        }
        @AfterSuite
                void myTest5(){
            System.out.println("5th Test Case");
        }
    }
//}
