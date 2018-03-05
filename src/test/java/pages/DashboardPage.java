package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DashboardPage extends BasePage {

    public DashboardPage(WebDriver driver) {
        super(driver);
    }

    public UserPage clickUserMenu() {
        driver.findElement(By.linkText("Usuários")).click();

        return new UserPage(driver);
    }

    public CommentsPage clickCommentsMenu() {
        driver.findElement(By.linkText("Comentários")).click();

        return new CommentsPage(driver);
    }

    public AdministrativeProcessPage clickAdministrativeProcessMenu() {
        driver.findElement(By.linkText("Processos")).click();

        return new AdministrativeProcessPage(driver);
    }

}
