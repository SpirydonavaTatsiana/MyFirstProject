package Tests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

import static org.junit.Assert.assertEquals;

public class BlockTest {

    private WebDriver driver;

    @Before
    public void main() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\astonuser\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
        this.driver = new ChromeDriver();
        driver.get("https://www.mts.by/");
        driver.findElement(By.id("cookie-agree")).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
    }

    @Test
    public void testBlockTitle() {
        String blockTitle = driver.findElement(By.xpath("//h2[contains(text(), 'Онлайн пополнение')]")).getText();
        System.out.println("Название блока: " + blockTitle);
        assertEquals("Онлайн пополнение\nбез комиссии", blockTitle);
    }

    @After
    public void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }
}