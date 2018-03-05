package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    //LOGIN
    public LoginPage typeEmail(String email) {
        driver.findElement(By.id("inputEmail")).sendKeys(email);

        return this;
    }

    public LoginPage typePassword (String password) {
        driver.findElement(By.id("inputPassword")).sendKeys(password);

        return this;

    }

    public DashboardPage clickLogin() {
        driver.findElement(By.xpath("//button")).click();

        return new DashboardPage(driver);
    }

    public DashboardPage login(String email, String password) {
        typeEmail(email);
        typePassword(password);
        clickLogin();

        return new DashboardPage(driver);
    }

    //FORGOT PASSWORD
    public ForgotPasswordPage clickLink() {
        driver.findElement(By.linkText(" Esqueceu a senha?")).click();

        return new ForgotPasswordPage(driver);
    }


}
