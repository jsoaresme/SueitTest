package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ForgotPasswordPage extends BasePage {

    public ForgotPasswordPage(WebDriver driver) {
        super(driver);
    }

    public ForgotPasswordPage typeEmail(String email) {
        driver.findElement(By.id("inputEmail")).sendKeys(email);

        return this;
    }

    public ForgotPasswordPage clickRedefinePassword() {
        driver.findElement(By.xpath("//button")).click();;

        return new ForgotPasswordPage(driver);
    }


}
