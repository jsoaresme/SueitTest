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
import pages.NavigationPage;
import suport.Web;

import static org.junit.Assert.assertEquals;

@RunWith(DataDrivenTestRunner.class)
public class ApplicationNavigationTest {

    private WebDriver driver;

    @Rule
    public TestName test = new TestName();

    @Before
    public void setUp(){
        driver = Web.createChrome();
    }


    @DataLoader(filePaths = "navigationProfileAdminTest.csv")
    @Test
    public void navigationProfileAdminTest(
            @Param(name="login")String login,
            @Param(name="password")String password) {
        new LoginPage(driver).login(login, password);

        String textDashboad =  new NavigationPage(driver).openDashboard().getTextPageHeader();
        String textClaims = new NavigationPage(driver).openClaims().getTextTitleHeader();
        String textComments = new NavigationPage(driver).openComments().getTextTitleHeader();
        String textAdministrativeProcess = new NavigationPage(driver).openAdministrativeProcess().getTextTitleHeader();
        String textLegalProcess = new NavigationPage(driver).openLegalProcess().getTextTitleHeader();
        String textUserWeb =  new NavigationPage(driver).openUserWeb().getTextTitleHeader();
        String textUserMobile = new NavigationPage(driver).openUserMobile().getTextTitleHeader();

        assertEquals(textDashboad, "Dashboard");
        assertEquals(textClaims, "Reclamações");
        assertEquals(textComments, "Comentários");
        assertEquals(textAdministrativeProcess, "Processos administrativos");
        assertEquals(textLegalProcess, "Processos jurídicos");
        assertEquals(textUserWeb, "Usuários");
        assertEquals(textUserMobile, "Usuários");

    }

    @After
    public void tearDown() {
        driver.quit();
    }


}
