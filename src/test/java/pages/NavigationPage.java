package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NavigationPage extends BasePage {

    public NavigationPage(WebDriver driver) {
        super(driver);
    }
    public NavigationPage openDashboard() {
        driver.get("https://sueit.abcdev.net/");

        return this;
    }

    public NavigationPage openClaims() {
        driver.get("https://sueit.abcdev.net/reclamacoes");

        return this;
    }

    public NavigationPage openComments() {
        driver.get("https://sueit.abcdev.net/comentarios");

        return this;
    }

    public NavigationPage openAdministrativeProcess() {
        driver.get("https://sueit.abcdev.net/processos/adm");

        return this;
    }

    public NavigationPage openLegalProcess() {
        driver.get("https://sueit.abcdev.net/processos/jur");

        return this;
    }

    public NavigationPage openUserWeb() {
        driver.get("https://sueit.abcdev.net/usuarios");

        return  this;
    }

    public NavigationPage openUserMobile() {
        driver.get("https://sueit.abcdev.net/usuarios/mobile");

        return this;
    }

    public String getTextTitleHeader() {

        return driver.findElement(By.xpath("//h3[@class='title-header']")).getText();
    }

    public String getTextPageHeader() {

        return driver.findElement(By.xpath("//h3[@class='page-header']")).getText();
    }




}
