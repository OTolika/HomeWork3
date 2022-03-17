import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import static com.codeborne.selenide.Selenide.page;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static com.codeborne.selenide.Selenide.sleep;

public class TaskPage
{
    @FindBy(how = How.XPATH, using =  "//*[text()='Редактировать']")
    private SelenideElement edit;

    @FindBy(how = How.XPATH, using =  "//*[text()='Детали задачи']")
    private SelenideElement delailsOfTask;

    @FindBy(how = How.XPATH, using =  "//*[text()='В работе']")
    private SelenideElement buttonInWork;

    @FindBy(how = How.XPATH, using =  "//*[@id='opsbar-transitions_more']/span")
    private SelenideElement buttonBuisnessProcess;

    @FindBy(how = How.XPATH, using =  "//*[text()='Выполнено']")
    private SelenideElement buttonDone;

    @FindBy(how = How.XPATH, using =  "//*[@id='status-val']")
    private SelenideElement ready;

    @Step("Проверка открытия страницы Задачи")
    public TaskPage isOpened()
    {
        sleep(1000);
        assertEquals(true, edit.exists());
        assertEquals(true, delailsOfTask.exists());
        return page(TaskPage.class);
    }
    @Step("Взять задачу в работу")
    public TaskPage ButtonInWork()
    {
        buttonInWork.click();
        return page(TaskPage.class);
    }
    @Step("Выподающее меню")
    public TaskPage ButtonBuisnessProcess()
    {
        buttonBuisnessProcess.click();
        return page(TaskPage.class);
    }
    @Step("Нажать кнопку Выполнено")
    public TaskPage ButtonDone()
    {
        buttonDone.click();
        return page(TaskPage.class);
    }
    @Step("Проверка, что задача Готова")
    public TaskPage ReadyTask()
    {
        sleep(1000);
        String readyText = ready.getText();
        assertEquals("ГОТОВО" , readyText);
        System.out.println("Task is done");
        return page(TaskPage.class);
    }

}
