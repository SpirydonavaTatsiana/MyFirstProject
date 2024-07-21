package Tests;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.List;
import static org.junit.Assert.assertTrue;

public class LogosTest {

    private WebDriver driver;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\astonuser\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
        driver = new ChromeDriver();
    }

    @Test
    public void LogosPresence() {
        driver.get("https://mts.by");
        WebElement onlineReplenishmentBlock = driver.findElement(By.xpath("//div/div/div[2]/section/div"));
        List<String> expectedLogos = List.of("visa.svg", "visa-verified.svg", "mastercard.svg", "mastercard-secure.svg", "belkart.svg");
        for (String logo : expectedLogos) {
            List<WebElement> logoElements = onlineReplenishmentBlock.findElements(By.xpath("//img[contains(@src, '" + logo + "')]"));
            assertTrue("Логотип " + logo + " не найден", logoElements.size() > 0);
        }
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
