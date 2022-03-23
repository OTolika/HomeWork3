package pageObject;

import com.codeborne.selenide.SelenideElement;
import hooks.PropertiesReader;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import static com.codeborne.selenide.Selenide.page;
import io.qameta.allure.Step;

public class AuthorizationPage extends PropertiesReader
{
    String login;
    String password;

    @FindBy (how = How.XPATH, using =  "//*[@id='login-form-username']")
    private SelenideElement loginLine;

    @FindBy (how = How.XPATH, using =  "//*[@id='login-form-password']")
    private SelenideElement passwordLine;

    @FindBy (how = How.XPATH, using =  "//*[@id='login-form-submit']")
    private SelenideElement buttonLogin;

    AuthorizationPage()
    {
            login = getProperty("login");
            password = getProperty("password");
    }

    @Step("Ввод логина {login}")
    public AuthorizationPage DoClickButtonLogin(String login)
    {
        loginLine.click();
        loginLine.sendKeys(login);
        return page(AuthorizationPage.class);
    }
    public AuthorizationPage ClickButtonLogin()
    {
        return DoClickButtonLogin(login);
    }
    @Step("Ввод пароля")
    public AuthorizationPage ClickButtonPassword()
    {
        passwordLine.click();
        passwordLine.sendKeys(password);
        return page(AuthorizationPage.class);
    }

    @Step("Нажатие кнопки войти")
    public AuthorizationPage ClickButtonSubmit()
    {
        buttonLogin.click();
        return page(AuthorizationPage.class);
    }

}
