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
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class LinkTest {
    private WebDriver driver;
    private WebDriverManager WebDriverRunner;

    @Before
    public void setUp() {
        // Указываем путь к драйверу Chrome
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\astonuser\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Test
    public void testServiceLink() {
        // Открываем сайт MTS
        driver.get("https://mts.by");

        // Находим элемент "Подробнее о сервисе" в блоке "Онлайн пополнение без комиссии"
        WebElement serviceLink = driver.findElement(By.xpath("//a[contains(text(), 'Подробнее о сервисе')]"));

        // Переходим по ссылке
        serviceLink.click();

        // Здесь можно добавить ожидания, например:
        // Ожидаем появления заголовка или ключевого элемента на новой странице
        WebElement pageHeader = driver.findElement(By.xpath("//h1[contains(text(), 'Порядок оплаты и безопасность интернет платежей')]"));

        // Проверяем, что заголовок страницы соответствует ожидаемому
        Assert.assertEquals("Порядок оплаты и безопасность интернет платежей", pageHeader.getText());
    }

    @After
    public void tearDown() {
        // Закрываем браузер после выполнения теста
        if (driver != null) {
            driver.quit();
        }
    }
}