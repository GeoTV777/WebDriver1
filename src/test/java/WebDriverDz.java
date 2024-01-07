import io.github.bonigarcia.wdm.WebDriverManager;
//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.core.Logger;
//import org.checkerframework.checker.units.qual.A;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class WebDriverDz {
//    static Logger logger = LogManager.getLogger(FirstTest.class);
    WebDriver driver;

    @BeforeAll
    public static void driverSetup() {
        WebDriverManager.chromedriver().setup();
//        logger.info("Установка драйвера");
    }

    @BeforeEach
    public void driverInstall() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
//       открыть Chrome в headless режиме
        options.addArguments("--headless");
        driver = new ChromeDriver(options);


//      driver = new ChromeDriver();
//        logger.info("Запуск драйвера");

    }

    @AfterEach
    public void driverStop() {
        if (driver != null) {
//            logger.info("Закрытие браузера");
            driver.close();
            driver.quit();
        }
    }

    @Test
    public void openHeadless() {
//      Перейти на https://duckduckgo.com/
        driver.get("https://duckduckgo.com");
//      Определяем элемент поисковая строка и кликаем по нему
        WebElement elEnter = driver.findElement(By.cssSelector("#searchbox_input"));
        elEnter.click();
//      В поисковой строке вводим "ОТУС" и кликаем по нему
        WebElement elInput = driver.findElement(By.cssSelector("#searchbox_input"));
        elInput.sendKeys("ОТУС");
        elEnter.submit();
//        В открывшемся окне проверяем, что в поисковой выдаче первый результат Онлайн‑курсы для профессионалов, дистанционное обучение

        driver.get("https://duckduckgo.com/?t=h_&q=%D0%BE%D1%82%D1%83%D1%81&ia=web/");
        WebElement elResult = driver.findElement(By.xpath("//*[@id='r1-0']/div[2]/h2/a/span"));
        Assertions.assertEquals("Онлайн‑курсы для профессионалов, дистанционное обучение современным ...", elResult.getText());

    }

}
