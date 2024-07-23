package Tests;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class OnlineReplenishment {
    private WebDriver driver;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\astonuser\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();

    }

    @Test
    public void checkFillingForm() {
        driver.get("https://mts.by");
        driver.findElement(By.id("cookie-agree")).click();
        String mainWindowHandle = driver.getWindowHandle();
        WebElement phoneNumberInput = driver.findElement(By.id("connection-phone"));
        phoneNumberInput.click();
        phoneNumberInput.sendKeys("297777777");
        WebElement sumInput = driver.findElement(By.id("connection-sum"));
        sumInput.click();
        sumInput.sendKeys("25");
        WebElement emailInput = driver.findElement(By.id("connection-email"));
        emailInput.click();
        emailInput.sendKeys("ivanov456987@gmail.com");
        WebElement continueButton = driver.findElement(By.xpath("//button[contains(text(), 'Продолжить')]"));
        continueButton.click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.numberOfWindowsToBe(2)); // ожидаем открытие нового окна

        // Получение всех идентификаторов окон
        List<String> windowHandles = new ArrayList<>(driver.getWindowHandles());

        // Переключаемся на новое окно (предполагая, что это второе окно в списке)
        for (String handle : windowHandles) {
            if (!handle.equals(mainWindowHandle)) {
                driver.switchTo().window(handle);
                break;
            }
        }


        WebElement cardNumberInput = driver.findElement(By.xpath("//form/div[1]/div[1]/app-input/div/div/div[1]/label[contains(text(), 'Номер карты')]")); //html/body/app-root/div/div/div/app-payment-container/section/div/app-card-page/div/div[1]/app-card-input/form/div[1]/div[1]/app-input/div/div/div[1]/label
        String cardNumberPlaceholder = cardNumberInput.getAttribute("placeholder");
        assertEquals("Номер карты", cardNumberPlaceholder, "Плейсхолдер для номера карты не соответствует ожидаемому.");

        WebElement expiryDateInput = driver.findElement(By.name("expirationDate"));
        String expiryDatePlaceholder = expiryDateInput.getAttribute("placeholder");
        assertEquals("Срок действия", expiryDatePlaceholder, "Плейсхолдер для срока действия не соответствует ожидаемому.");

        WebElement codeCVCInput = driver.findElement(By.name("verification_value"));
        String codeCVCPlaceholder = codeCVCInput.getAttribute("placeholder");
        assertEquals("CVC", codeCVCPlaceholder, "Плейсхолдер для CVC не соответствует ожидаемому.");

        WebElement holderNameInput = driver.findElement(By.xpath("//div[1]/app-card-input/form/div[1]/div[3]/app-input/div/div/div[1]/label[contains(text(), 'Имя держателя (как на карте)')]"));
        String holderNamePlaceholder = holderNameInput.getAttribute("placeholder");
        assertEquals("Имя держателя (как на карте)", holderNamePlaceholder, "Плейсхолдер для имени держателя карты не соответствует ожидаемому.");

        String amountPaymentRub = driver.findElement(By.xpath("//app-payment-container/section/div/div/div[1][contains(text(), '25.00 BYN')]")).getText();
        System.out.println("Название блока: " + amountPaymentRub);
        Assert.assertEquals("25.00 BYN", amountPaymentRub);

        String phoneNumber = driver.findElement(By.xpath("//div/div/div[1]/span[1][contains(text(), 'Оплата: Услуги связи Номер:375297777777')]")).getText();
        System.out.println("Название блока: " + phoneNumber);
        Assert.assertEquals("Оплата: Услуги связи Номер:375297777777", phoneNumber);
    }
        // Вернуться обратно в основное окно
        //driver.switchTo().window(mainWindow);
}

