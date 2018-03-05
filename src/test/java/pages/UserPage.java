package pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class UserPage extends BasePage {

    public UserPage(WebDriver driver) {
        super(driver);
    }


    public UserPage clickUserMenu() {
        driver.findElement(By.linkText("Usuários")).click();

        return this;
    }

    public UserPage clickUserWebMenu() {
        driver.findElement(By.linkText("Web")).click();

        return this;
    }

    public UserPage clickUserMobileMenu() {
        driver.findElement(By.linkText("Mobila")).click();

        return this;
    }

    public UserPage clickNewUser() {
        driver.findElement(By.xpath("//div[@id='page-wrapper']/div/div/div/div[2]/a")).click();

        return this;
    }

    public UserPage typeName(String name) {
        driver.findElement(By.id("name")).sendKeys(name);

        return this;
    }

    public UserPage typeEmail(String email) {
        driver.findElement(By.id("email")).sendKeys(email);

        return this;
    }

    public UserPage typeProfile(String profile){
        WebElement campoType = driver.findElement(By.name("profile"));
        new Select(campoType).selectByVisibleText(profile);

        return this;
    }

    public UserPage typePassowrd(String password) {
        driver.findElement(By.id("password")).sendKeys(password);

        return this;
    }

    public UserPage typeConfirmPassword(String confirmPassword) {
        driver.findElement(By.id("password_confirmation")).sendKeys(confirmPassword);

        return this;
    }

    public UserPage clickSave() {
        driver.findElement(By.xpath("//div//button[@type='submit']")).click();

        return this;
    }

    public UserPage clickRemoveUser() {
        driver.findElement(By.xpath("//div[@id='tblUsers_wrapper']//tbody//tr//td[contains(text(),'Test')]//following-sibling::td/a[@title='Apagar']")).click();

        return this;
    }

    public UserPage clickConfirmRemoveUser() {
        driver.findElement(By.xpath("//body[@class='modal-open']/div[@class='bootbox modal fade in']/div/div/div[3]/button[2]")).click();

        return this;
    }

}
