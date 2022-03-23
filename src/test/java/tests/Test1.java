package tests;
import com.codeborne.selenide.Selenide;
import hooks.Hooks;
import org.junit.jupiter.api.*;
import pageObject.AuthorizationPage;
import pageObject.MainPage;
import pageObject.RapidBoard;

public class Test1 extends Hooks
{
    String url;
    Test1()
    {
        url = getProperty("url");
    }

    @DisplayName("Тест сравнения количества задач из текста и в списке")
    @Test
    public void RunTest1()
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
}
