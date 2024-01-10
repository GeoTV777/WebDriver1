import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;

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



