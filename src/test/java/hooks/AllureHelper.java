package hooks;

import com.codeborne.selenide.WebDriverRunner;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.NoSuchSessionException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import java.io.File;
import java.io.IOException;
import static io.qameta.allure.Allure.addAttachment;


public class AllureHelper {

    public void afterTestExecution() {
            try {
                File screenshotAs = ((TakesScreenshot) WebDriverRunner.getWebDriver()).getScreenshotAs(OutputType.FILE);
                addAttachment("Screenshot", FileUtils.openInputStream(screenshotAs));
            } catch (IOException | NoSuchSessionException e) {
            }

    }
}