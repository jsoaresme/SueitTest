package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AdministrativeProcessPage extends BasePage {

    public AdministrativeProcessPage(WebDriver driver) {
        super(driver);
    }

    public AdministrativeProcessPage clickAdministrative() {
        driver.findElement(By.linkText("Administrativos")).click();

        return this;
    }

    public AdministrativeProcessPage clickViewDatailProcess() {
        driver.findElement(By.xpath("//a[@title='Visualizar']")).click();

        return this;
    }

    public AdministrativeProcessPage clickAddFilePDF() {
        WebElement file = driver.findElement(By.xpath("//div[@class='attachments-area']//button"));

        file.sendKeys("C:\\Users\\Jonathan Soares\\IdeaProjects\\sueittest\\src\\test\\resources\\pdf_teste.pdf");
        return this;
    }


}
