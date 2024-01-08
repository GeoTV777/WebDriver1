import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import org.checkerframework.checker.units.qual.A;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import java.time.Duration;

public class WebDriverDz {
    static Logger logger = (Logger) LogManager.getLogger("WebDriverDZ");
    WebDriver driver;

    @BeforeAll
    public static void driverSetup() {
        WebDriverManager.chromedriver().setup();
        logger.info("Установка драйвера");
    }

    @AfterEach
    public void driverStop() {
        if (driver != null) {
           logger.info("Закрытие браузера");
            driver.close();
            driver.quit();
        }
    }





}



