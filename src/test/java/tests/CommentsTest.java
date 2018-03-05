package tests;
import org.easetech.easytest.annotation.DataLoader;
import org.easetech.easytest.annotation.Param;
import org.easetech.easytest.runner.DataDrivenTestRunner;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import pages.LoginPage;
import suport.Web;

import static org.junit.Assert.assertEquals;

@RunWith(DataDrivenTestRunner.class)
public class CommentsTest {

    private WebDriver driver;

    @Rule
    public TestName test = new TestName();

    @Before
    public void setUp(){
        driver = Web.createChrome();
    }

    @DataLoader(filePaths = "comnentsReplayYesTest.csv")
    @Test
    public void replayCommentYesVerify(
            @Param(name="email")String email,
            @Param(name="password")String password){

        String textValidation =  new LoginPage(driver)
                .login(email,password)
                .clickCommentsMenu()
                .clickRefinedSearch()
                .typeAnsweredYes("Sim")
                .clickSearch()
                .clickToView()
                .getTextValidationFeedbackRepliesYes();

        assertEquals(textValidation, "Não há comentários pendentes");
    }

    @DataLoader(filePaths = "comnentsReplay.csv")
    @Test
    public void replayComment(
            @Param(name="email")String email,
            @Param(name="password")String password,
            @Param(name="message")String message){

        String textValidation =  new LoginPage(driver)
                .login(email,password)
                .clickCommentsMenu()
                .clickRefinedSearch()
                .typeAnsweredYes("Não")
                .clickSearch()
                .clickToView()
                .clickReplieMessage()
                .typeMessage(message)
                .clickReplieMessageSend()
                .getTextToast();

        assertEquals(textValidation, "Mensagem enviada com sucesso.");

    }
    @After
    public void tearDown() {
        driver.quit();
    }
}
