

package junit.imiguez;

        import io.github.bonigarcia.wdm.WebDriverManager;
        import org.junit.*;
        import org.openqa.selenium.By;
        import org.openqa.selenium.Keys;
        import org.openqa.selenium.WebDriver;
        import org.openqa.selenium.WebElement;
        import org.openqa.selenium.chrome.ChromeDriver;
        import org.openqa.selenium.support.ui.Select;

        import java.util.List;
        import java.util.concurrent.TimeUnit;

public class ATC_AgregarProductoCambiandoTallaYColor {

    WebDriver driver;

    @BeforeClass
    public static void init() {
        System.out.println("Init");
        WebDriverManager.chromedriver().setup();
    }

    @Before
    public void setUp() {
        System.out.println("SetUp");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void atc05() {
        driver.get("http://automationpractice.com/index.php");
        WebElement searchInput = driver.findElement(By.xpath("//*[@id='search_query_top']"));
        searchInput.sendKeys("blouse");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.findElement(By.xpath("/html/body/div[2]/ul/li")).click();
        Select select = new Select(driver.findElement(By.xpath("//*[@id='group_1']")));
        select.selectByValue("3");
        driver.findElement(By.xpath("//*[@id='color_8']")).click();
        driver.findElement(By.xpath("//*[@id='add_to_cart']/button")).click();
        WebElement succes = driver.findElement(By.cssSelector(".layer_cart_product > h2:nth-child(2)"));
        String text = succes.getAttribute("innerText");
        Assert.assertTrue(text.contains("Product successfully added to your shopping cart"));
    }

    @After
    public void clean() {
        System.out.println("Clean");
        if (driver != null)
            driver.close();
    }

}