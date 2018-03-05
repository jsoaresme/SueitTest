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
import org.openqa.selenium.WebElement;
import pages.LoginPage;
import suport.Web;



@RunWith(DataDrivenTestRunner.class)
public class addPDFProcess {


    private WebDriver driver;

    @Rule
    public TestName test = new TestName();

    @Before
    public void setUp(){
        driver = Web.createChrome();
    }

    @DataLoader(filePaths = "addPDFProcessTest.csv")
    @Test
    public void addFilePDFProcess(
            @Param(name="login")String login,
            @Param(name="password")String password) {


        //String workingDir = System.getProperty("C:\\Users\\Jonathan Soares\\IdeaProjects\\sueittest\\src\\test\\resources\\");


        new LoginPage(driver).login(login, password)
                .clickAdministrativeProcessMenu()
                .clickAdministrative()
                .clickViewDatailProcess();




        WebElement file = driver.findElement(By.xpath("//div[@class='attachments-area']//button"));
                file.sendKeys("C:\\Users\\Jonathan Soares\\IdeaProjects\\sueittest\\src\\test\\resources\\pdf_teste.pdf");



    }

    @After
    public void tearDown() {
        //driver.quit();
    }

}
