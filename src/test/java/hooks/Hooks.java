package hooks;

import com.codeborne.selenide.WebDriverRunner;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static com.codeborne.selenide.Selenide.closeWebDriver;

public class Hooks extends PropertiesReader
{
        @BeforeAll
        static void StartOfTest()
        {
            WebDriver driverChrome;
            System.setProperty("webdriver.chrome.driver", "./src/test/resources/chromedriver.exe");
            driverChrome = new ChromeDriver();
            driverChrome.manage().window().maximize();
            WebDriverRunner.setWebDriver(driverChrome);
        }

        @BeforeAll
        public static void allureSubThreadParallel()
        {
            String listenerName = "AllureSelenide";
            if (!(SelenideLogger.hasListener(listenerName)))
            {
                SelenideLogger.addListener(listenerName, new AllureSelenide()
                        .screenshots(true)
                        .savePageSource(false));
            }

        }

        @AfterEach
        public void allureAfterTest()
        {
            new AllureHelper().afterTestExecution();
        }

        @AfterAll
        static void EndOfTest()
        {
            closeWebDriver();
        }

}
