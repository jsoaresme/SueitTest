package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class CommentsPage extends BasePage {

    public CommentsPage(WebDriver driver) {
        super(driver);
    }

    public CommentsPage clickRefinedSearch() {
        driver.findElement(By.xpath("//button[@title='Pesquisar']")).click();

        return this;
    }

    public CommentsPage typeAnsweredYes(String option) {
        WebElement optionType = driver.findElement(By.xpath("//select[@name='answered']"));
        new Select(optionType).selectByVisibleText(option);

        return this;
    }

    public CommentsPage clickSearch() {
        driver.findElement(By.xpath("//button[@class='btn btn-primary btn-report search-messages']")).click();

        return this;
    }

    public CommentsPage clickToView() {
        driver.findElement(By.xpath("//a[@title='Visualizar']")).click();

        return this;
    }

    public String getTextValidationFeedbackRepliesYes() {
        return driver.findElement(By.xpath("//div[@class='alert alert-info']")).getText();
    }

    public String getTextValidationFeedbackRepliesNot() {
        return driver.findElement(By.xpath("//div[@class='not-answered-warning']/p")).getText();
    }

    public CommentsPage clickReplieMessage() {
        driver.findElement(By.xpath("//button[@class='btn btn-primary btn-sm cta-answer']")).click();

        return this;
    }


    public CommentsPage typeMessage(String message) {
        driver.findElement(By.xpath("//div[@class='answer-message-wrapper']//textarea")).sendKeys(message);

        return this;
    }
    public CommentsPage clickReplieMessageSend() {
        driver.findElement(By.xpath("//button[@class='btn btn-primary btn-sm pull-right btn-send-msg']")).click();

        return this;
    }





    //textarea[@id='message']


}
