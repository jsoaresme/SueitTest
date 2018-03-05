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
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.LoginPage;
import suport.Web;

import static org.junit.Assert.assertEquals;

@RunWith(DataDrivenTestRunner.class)
@DataLoader(filePaths = "forgotPassword.csv")
public class ForgotPasswordTest {

    private WebDriver driver;

    @Rule
    public TestName test = new TestName();

    @Before
    public void setUp(){
        driver = Web.createChrome();
    }

    @Test
    public void forgotPassword(
            @Param(name="emailForgot")String email) {
        new LoginPage(driver)
                .clickLink()
                .typeEmail(email)
                .clickRedefinePassword();
        String textValidation = driver.findElement(By.xpath("//div//form//following-sibling::div")).getText();
        assertEquals(textValidation, "  O link para redefinição de senha foi enviado para o seu e-mail!");

    }

    @Test
    public void forgotPasswordFail() {
        new LoginPage(driver)
                .clickLink()
                .typeEmail("not@exist.com.br")
                .clickRedefinePassword();
        String textValidation = driver.findElement(By.xpath("//div//form//following-sibling::div")).getText();
        assertEquals(textValidation, "  Não encontramos nenhum usuário com esse endereço de e-mail.");

    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
