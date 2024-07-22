package Tests;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class EmptyFieldTest {
    private WebDriver driver;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\astonuser\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Test
    public void checkPlaceholdersOfEmptyFields() {
        driver.get("https://mts.by");
        driver.findElement(By.id("cookie-agree")).click();

        WebElement phoneNumberInput = driver.findElement(By.id("connection-phone"));
        String phonePlaceholder = phoneNumberInput.getAttribute("placeholder");
        assertEquals("Номер телефона", phonePlaceholder, "Плейсхолдер для номера телефона не соответствует ожидаемому.");
        WebElement amountInput = driver.findElement(By.id("connection-sum"));
        String amountPlaceholder = amountInput.getAttribute("placeholder");
        assertEquals("Сумма", amountPlaceholder, "Плейсхолдер для суммы не соответствует ожидаемому.");
        WebElement emailInput = driver.findElement(By.id("connection-email"));
        String emailPlaceholder = emailInput.getAttribute("placeholder");
        assertEquals("E-mail для отправки чека", emailPlaceholder, "Плейсхолдер для E-mail не соответствует ожидаемому.");

        driver.findElement(By.xpath("//div[2]/button/span[1][contains(text(), 'Услуги связи')]")).click();
        driver.findElement(By.xpath("//div[2]/ul/li[2]/p[contains(text(), 'Домашний интернет')]")).click();
        WebElement abonentNumberInput = driver.findElement(By.id("internet-phone"));
        String abonentNumberPlaceholder = abonentNumberInput.getAttribute("placeholder");
        assertEquals("Номер абонента", abonentNumberPlaceholder, "Плейсхолдер для номера абонента не соответствует ожидаемому.");
        WebElement amountInternetInput = driver.findElement(By.id("internet-sum"));
        String amountInternetPlaceholder = amountInternetInput.getAttribute("placeholder");
        assertEquals("Сумма", amountPlaceholder, "Плейсхолдер для суммы не соответствует ожидаемому.");
        WebElement emailInternetInput = driver.findElement(By.id("internet-email"));
        String emailInternetPlaceholder = emailInternetInput.getAttribute("placeholder");
        assertEquals("E-mail для отправки чека", emailPlaceholder, "Плейсхолдер для E-mail не соответствует ожидаемому.");

        driver.findElement(By.xpath("//div[2]/button/span[1][contains(text(), 'Домашний интернет')]")).click();
        driver.findElement(By.xpath("//div[2]/ul/li[3]/p[contains(text(), 'Рассрочка')]")).click();
        WebElement accountNumberInput = driver.findElement(By.id("score-instalment"));
        String accountNumberPlaceholder = accountNumberInput.getAttribute("placeholder");
        assertEquals("Номер счета на 44", accountNumberPlaceholder, "Плейсхолдер для номера счета не соответствует ожидаемому.");
        WebElement amountInstalmentInput = driver.findElement(By.id("instalment-sum"));
        String amountInstalmentPlaceholder = amountInstalmentInput.getAttribute("placeholder");
        assertEquals("Сумма", amountInstalmentPlaceholder, "Плейсхолдер для суммы не соответствует ожидаемому.");
        WebElement emailInstalmentInput = driver.findElement(By.id("instalment-email"));
        String emailInstalmentPlaceholder = emailInstalmentInput.getAttribute("placeholder");
        assertEquals("E-mail для отправки чека", emailInstalmentPlaceholder, "Плейсхолдер для E-mail не соответствует ожидаемому.");

        driver.findElement(By.xpath("//div[2]/button/span[1][contains(text(), 'Рассрочка')]")).click();
        driver.findElement(By.xpath("//div[2]/ul/li[4]/p[contains(text(), 'Задолженность')]")).click();
        WebElement accountArrearsNumberInput = driver.findElement(By.id("score-arrears"));
        String accountArrearsPlaceholder = accountArrearsNumberInput.getAttribute("placeholder");
        assertEquals("Номер счета на 2073", accountArrearsPlaceholder, "Плейсхолдер для номера счета не соответствует ожидаемому.");
        WebElement amountArrearsInput = driver.findElement(By.id("arrears-sum"));
        String amountArrearsPlaceholder = amountArrearsInput.getAttribute("placeholder");
        assertEquals("Сумма", amountArrearsPlaceholder, "Плейсхолдер для суммы не соответствует ожидаемому.");
        WebElement emailArrearsInput = driver.findElement(By.id("arrears-email"));
        String emailArrearsPlaceholder = emailArrearsInput.getAttribute("placeholder");
        assertEquals("E-mail для отправки чека", emailArrearsPlaceholder, "Плейсхолдер для E-mail не соответствует ожидаемому.");
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}