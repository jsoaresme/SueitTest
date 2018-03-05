package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BasePage {
    protected WebDriver driver;

    public BasePage(WebDriver driver){
        this.driver = driver;
    }

    public String getTextToast(){
        return driver.findElement(By.xpath("//p[@class='slideIn']")).getText();
        //div[@class='iziToast-body']//p
    }

    public String getTextTest(){
        return driver.findElement(By.xpath("//div[@id='tblUsers_wrapper']//tbody//tr")).getText();
    }

}
