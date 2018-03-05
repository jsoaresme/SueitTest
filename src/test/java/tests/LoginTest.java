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
public class LoginTest  {

    private WebDriver driver;

    @Rule
    public TestName test = new TestName();

    @Before
    public void setUp(){
        driver = Web.createChrome();
    }

    @DataLoader(filePaths = "loginSucessTest.csv")
    @Test
    public void loginSucess(
            @Param(name="email")String email,
            @Param(name="password")String password) {

        new LoginPage(driver).login(email, password);

        String textValidation = driver.findElement(By.linkText("Dashboard")).getText();
        assertEquals(textValidation, "Dashboard");
    }

    @DataLoader(filePaths = "loginFailTest.csv")
    @Test
    public void loginFail(
            @Param(name="email")String email,
            @Param(name="password")String password) {
        new LoginPage(driver)
                .login(email,password);

        String textValidation = driver.findElement(By.xpath("//div//form//following-sibling::div")).getText();
        assertEquals(textValidation, "  Usuário ou senha inválidos.");
    }

    @After
    public void tearDown() {
       driver.quit();
    }

}
