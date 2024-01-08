import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class MaximizeTest extends WebDriverDz {

        @BeforeEach
        public void driverMiximize() {
            ChromeOptions options = new ChromeOptions();
//            options.addArguments("--remote-allow-origins=*");
            options.addArguments("--start-maximized");
            driver = new ChromeDriver(options);
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
            driver.manage().window().maximize();
            logger.info("Открытие браузера в режиме полного окна");
        }
        @Test
        public void openMaximaze() {
//      Открыть Chrome в режиме полного экрана
//      Перейти на https://otus.ru
            driver.get("https://otus.ru");
//      Авторизоваться под каким-нибудь тестовым пользователем(можно создать нового)
//      log:tvgeo777@gmail.com
//      pass: tvGEO777#777
            autorization();
//      Вывести в лог все cookie
            System.out.println(driver.manage().getCookies());
//
        }

        private void autorization() {
            WebElement elEnter = driver.findElement(By.xpath("//*[@id=\"__next\"]//section/div[1]/button"));
            elEnter.click();

            WebElement elFocus = driver.findElement(By.xpath("//input[@name]/.."));
            elFocus.click();
            WebElement elEmail = driver.findElement(By.xpath("//input[@name]"));
            elEmail.sendKeys("tvgeo777@gmail.com");

            elFocus = driver.findElement(By.xpath("//input[@type=\"password\"]/.."));
            elFocus.click();
            WebElement elPassword = driver.findElement(By.xpath("//input[@type=\"password\"]"));
            elPassword.sendKeys("tvGEO777#777");
            elEnter = driver.findElement(By.xpath("//button[./*[text() = 'Войти']]"));
            elEnter.click();
            try {
                Thread.sleep(5000);
            } catch (Exception ignored) {
            }
        }
    }

