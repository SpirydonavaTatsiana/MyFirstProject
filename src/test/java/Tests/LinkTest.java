package Tests;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;

public class LinkTest {
    private WebDriver driver;
    private WebDriverManager WebDriverRunner;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\astonuser\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Test
    public void testServiceLink() {
        driver.get("https://mts.by");
        driver.findElement(By.id("cookie-agree")).click();
        WebElement serviceLink = driver.findElement(By.xpath("//a[contains(text(), 'Подробнее о сервисе')]"));
        serviceLink.click();
        WebElement pageHeader = driver.findElement(By.xpath("//div/div/div/div/ul/li[3]/span/span[contains(text(), 'Порядок оплаты и безопасность интернет платежей')]"));
        Assert.assertEquals("Порядок оплаты и безопасность интернет платежей", pageHeader.getText());
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}