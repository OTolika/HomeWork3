import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import java.util.List;
import static com.codeborne.selenide.Selenide.page;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static com.codeborne.selenide.Selenide.sleep;

public class RapidBoard
{
    @FindBy(how = How.XPATH, using =  "//*[@id='subnav-title']/span")
    private SelenideElement header;

    @FindBy(how = How.XPATH, using =  "//*[@data-link-id='com.pyxis.greenhopper.jira:project-sidebar-plan-scrum']")
    private SelenideElement taskList;

    @FindBy(how = How.XPATH, using =  "//*[@class='ghx-issue-count']")
    private SelenideElement issueCount;

    @FindBy(how = How.XPATH, using =  "//*[contains(@class, 'js-issue-list')]")
    private SelenideElement issueList;

    @Step("Проверка открытия страницы Список задач")
    public RapidBoard isOpened()
    {
        sleep(1000);
        assertEquals(true, header.exists());
        return page(RapidBoard.class);
    }
    @Step("Переход на отображение Список задач")
    public RapidBoard ClickButtonTaskList()
    {
        taskList.click();
        return page(RapidBoard.class);
    }
    @Step("Взятие количества задач из текста")
    public int TextIssueCount()
    {
        String s = issueCount.getText();
        int a = s.indexOf(" ");
        int count = Integer.parseInt(s.substring(0, a));
        return count;
    }
    @Step("Взятие количества элементов в списке задач")
    public int ListIssueCount()
    {
        List<WebElement> e = issueList.findElements(By.className("js-issue"));
        return e.size();
    }
    @Step("Проверка соответствия количества задач из текста и в списке")
    public RapidBoard EqualTextIssueCountToListIssueCount()
    {
        int t = TextIssueCount();
        int l = ListIssueCount();
        System.out.println("TextIssueCount = " + t);
        System.out.println("ListIssueCount = " + l);
        assertEquals(t, l);
        return page(RapidBoard.class);
    }


}
