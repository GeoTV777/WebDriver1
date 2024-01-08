import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class HeadlesTest extends WebDriverDz {

        @BeforeEach
        public void driverInstallFoHeadless() {
            ChromeOptions options = new ChromeOptions();
//            options.addArguments("--remote-allow-origins=*");
//       открыть Chrome в headless режиме headless
            options.addArguments("--headless");
            driver = new ChromeDriver(options);
            logger.info("Открытие браузера в режиме headless");
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
//        В открывшемся окне проверяем, что в поисковой выдаче первый результат Онлайн‑курсы для профессионалов,
//        дистанционное обучение
//        Если не добавить окончание фразы - "современным ...", то не сработает
//        По заданию точно ли выдача поисковой строки ДОЛЖНА совпадать с ожидаемым результатом?))))))

            driver.get("https://duckduckgo.com/?t=h_&q=%D0%BE%D1%82%D1%83%D1%81&ia=web/");
            WebElement elResult = driver.findElement(By.xpath("//*[@id='r1-0']/div[2]/h2/a/span"));
            Assertions.assertEquals("Онлайн‑курсы для профессионалов, дистанционное обучение современным ...",
                    elResult.getText());
        }
    }
