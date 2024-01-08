import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class KioskTest  extends WebDriverDz{
        @BeforeEach
        public void driverInstallFoKiosk(){
            ChromeOptions options = new ChromeOptions();
//            options.addArguments("--remote-allow-origins=*");
            //открыть Chrome в режиме киоска
            options.addArguments("--start-fullscreen");
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

