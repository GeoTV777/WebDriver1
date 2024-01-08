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
    public class HeadlessTest {
        @BeforeEach
        public void driverInstallFoHeadless() {
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--remote-allow-origins=*");
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

    public class KioskTest {
        @BeforeEach
        public void driverInstallFoKiosk(){
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--remote-allow-origins=*");
            //открыть Chrome в режиме киоска
            options.addArguments("--enable-hardwere-averlays");
            driver = new ChromeDriver(options);
            logger.info("Открытие браузера в режиме киоска");
        }
        @Test
        public void openFullscreen() {
//       Переходим на сайт:
            driver.get("https://p.w3layouts.com/demos_new/template_demo/03-10-2020/photoflash-liberty-demo_Free/685659620/web/index.html?_ga=2.181802926.889871791.1632394818-2083132868.1632394818");
//       Кликаем картинку
//        WebElement elPicture = driver.findElement(By.xpath("/html/body/section[2]/div/ul[2]/li[7]/span"));
//        elPicture.click();
//////        Проверяем открытие картинки в модальном окне
//        WebElement elModalPicture = driver.findElement(By.xpath("/html/body/div[7]/div[3]/div/div/div/div[2]/div[3]"));
//        Assertions.assertTrue(elModalPicture.isDisplayed(),"Нет изображения в модальном окне");
        }
    }

    public class FullscreenTest {
        @BeforeEach
        public void driverFullScreen() {
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--remote-allow-origins=*");
            options.addArguments();
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
}



