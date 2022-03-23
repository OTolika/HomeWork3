package tests;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import hooks.Hooks;
import org.junit.jupiter.api.*;
import pageObject.AuthorizationPage;
import pageObject.MainPage;
import pageObject.TaskPage;

public class Test2 extends Hooks
{
    String url;
    Test2()
    {
        url = getProperty("url");
    }

    @DisplayName("Тест на создние задачи и выполнения ее")
    @Test
    public void RunTest2()
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
