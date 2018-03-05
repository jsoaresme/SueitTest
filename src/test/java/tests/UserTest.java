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

import java.util.Random;


import static org.junit.Assert.assertEquals;

@RunWith(DataDrivenTestRunner.class)
public class UserTest {

    private WebDriver driver;

    private Random random = new Random();
    private int numberRandom = random.nextInt(100);

    @Rule
    public TestName test = new TestName();

    @Before
    public void setUp(){
        driver = Web.createChrome();
    }


    @DataLoader(filePaths = "userCreateTest.csv")
    @Test
    public void createUser(
            @Param(name="login")String login,
            @Param(name="password")String password,
            @Param(name="name")String name,
            @Param(name="email")String email,
            @Param(name="profile")String profile,
            @Param(name="newpassword")String newpassword,
            @Param(name="newconfirmepassword")String newconfirmepassword) {

         String textValidation =  new LoginPage(driver)
                .login(login,password)
                .clickUserMenu()
                .clickUserWebMenu()
                .clickNewUser()
                .typeName(name + numberRandom)
                .typeEmail(numberRandom + email)
                .typeProfile(profile)
                .typePassowrd(newpassword)
                .typeConfirmPassword(newconfirmepassword)
                .clickSave()
                .getTextToast();

         String textValidationTost = "Usuário(a) Test" + numberRandom + " cadastrado(a) com sucesso.";
         assertEquals(textValidation, textValidationTost);

    }

    @DataLoader(filePaths = "userRemoveTest.csv")
    @Test
    public void removeUser(
            @Param(name="login")String login,
            @Param(name="password")String password) {

        String textValidation =  new LoginPage(driver)
                .login(login,password)
                .clickUserMenu()
                .clickUserWebMenu()
                .clickRemoveUser()
                .clickConfirmRemoveUser()
                .getTextToast();

        assertEquals(textValidation, textValidation);

    }

    @After
    public void tearDown() {
       driver.quit();
    }
}
