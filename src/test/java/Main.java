import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import static com.codeborne.selenide.Selenide.closeWebDriver;

public class Main extends PropertiesReader
{
    String url;
    Main()
    {
        url = getProperty("url");
    }

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

   @DisplayName("Тест сравнения количества задач из текста и в списке")
   @Test
    public void Test1()
    {
        Selenide.open(url + "login.jsp?", AuthorizationPage.class)
                .ClickButtonLogin()
                .ClickButtonPassword()
                .ClickButtonSubmit();

        Selenide.open(url + "secure/Dashboard.jspa?", MainPage.class)
                .isOpened()
                .openAllOpenIssue();

        Selenide.open(url + "secure/RapidBoard.jspa?", RapidBoard.class)
                .isOpened()
                .ClickButtonTaskList()
                .EqualTextIssueCountToListIssueCount();
    }

    @DisplayName("Тест на создние задачи и выполнения ее")
    @Test
    public void Test2()
    {
        Selenide.open(url + "login.jsp?", AuthorizationPage.class)
                .ClickButtonLogin()
                .ClickButtonPassword()
                .ClickButtonSubmit();

        Selenide.open(url + "secure/Dashboard.jspa?", MainPage.class)
                .isOpened()
                .ClickCreateTask()
                .isOpenedCreateTask()
                .PutSubjectCreateTask()
                .PutDescriptionCreateTask()
                .ButtonCreateTask()
                .ButtonTask();

        String taskURL = WebDriverRunner.getWebDriver().getCurrentUrl();

        Selenide.open(taskURL, TaskPage.class)
                .isOpened()
                .ButtonInWork()
                .ButtonBuisnessProcess()
                .ButtonDone()
                .ReadyTask();
    }
}
