package pageObject;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import static com.codeborne.selenide.Selenide.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class MainPage
{
    @FindBy (how = How.XPATH, using =  "//h1[text()='System Dashboard']")
    private SelenideElement header;

    @FindBy (how = How.XPATH, using =  "//*[@id='browse_link']")
    private SelenideElement projectButton;

    @FindBy (how = How.XPATH, using =  "//*[@id='admin_main_proj_link_lnk']")
    private SelenideElement TESTButton;

    @FindBy (how = How.XPATH, using =  "//*[@id='create_link']")
    private SelenideElement createTask;

    @FindBy(how = How.XPATH, using =  "//h2[text()='Создание задачи']")
    private SelenideElement headerCreateTask;

    @FindBy(how = How.XPATH, using =  "//*[@id='summary']")
    private SelenideElement subjectCreateTask;

    @FindBy(how = How.XPATH, using =  "//*[@id='mce_0_ifr']")
    private SelenideElement descriptionCreateTask;

    @FindBy(how = How.XPATH, using =  "//*[@id='create-issue-submit']")
    private SelenideElement buttonCreateTask;

    @FindBy(how = How.XPATH, using =  "//*[contains(text(), 'TEST-')]")
    private SelenideElement buttonTask;

    public MainPage isOpened()
    {
        sleep(1000);
        assertEquals(true, header.exists());
        return page(MainPage.class);
    }

    public MainPage openAllOpenIssue()
    {
        projectButton.click();
        TESTButton.click();
        return page(MainPage.class);
    }

    public MainPage ClickCreateTask()
    {
        createTask.click();
        return page(MainPage.class);
    }

    public MainPage isOpenedCreateTask()
    {
        sleep(5000);
        assertEquals(true, headerCreateTask.exists());
        return page(MainPage.class);
    }

    public MainPage PutSubjectCreateTask()
    {
        subjectCreateTask.sendKeys("Oksana's new task");
        return page(MainPage.class);
    }

    public MainPage PutDescriptionCreateTask()
    {
        Selenide.switchTo().frame(descriptionCreateTask);
        $x("//*[@id='tinymce']").sendKeys("Hello World");
        Selenide.switchTo().parentFrame();
        return page(MainPage.class);
    }

    public MainPage ButtonCreateTask()
    {
        buttonCreateTask.click();
        return page(MainPage.class);
    }

    public MainPage ButtonTask()
    {
        buttonTask.click();
        return page(MainPage.class);
    }

}
