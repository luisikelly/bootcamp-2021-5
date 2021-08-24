package selenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class Selenium101Test {

    WebDriver driver;

    @BeforeClass
    public static void SetUp(){
        System.out.println("Setup");
        WebDriverManager.edgedriver().setup();
    }

    @Before
    public void init(){
        System.out.println("init");
        driver = new EdgeDriver();
    }

    @After
    public void close(){
        System.out.println("After");
       if(driver != null){
           driver.close();
       }
    }

    @Test
    public void test() {
        // Your test code here
        System.out.println("Driver Chrome Configurado!");
    }


}
