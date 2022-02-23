import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import static com.codeborne.selenide.Selenide.page;

public class AuthorizationPage
{
    String login = "tolOksana";
    String password = "123qaz!@#QAZ";

    @FindBy (how = How.XPATH, using =  "//*[@id='login-form-username']")
    private SelenideElement loginLine;

    @FindBy (how = How.XPATH, using =  "//*[@id='login-form-password']")
    private SelenideElement passwordLine;

    @FindBy (how = How.XPATH, using =  "//*[@id='login-form-submit']")
    private SelenideElement buttonLogin;

    public AuthorizationPage ClickButtonLogin()
    {
        loginLine.click();
        loginLine.sendKeys(login);
        return page(AuthorizationPage.class);
    }

    public AuthorizationPage ClickButtonPassword()
    {
        passwordLine.click();
        passwordLine.sendKeys(password);
        return page(AuthorizationPage.class);
    }

    public AuthorizationPage ClickButtonSubmit()
    {
        buttonLogin.click();
        return page(AuthorizationPage.class);
    }

}
