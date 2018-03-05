package suport;



import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;

public class Screenshot {
    public static void takeScreen(WebDriver driver, String arquivo) {
        File screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(screenshot, new  File(arquivo));
        } catch (Exception e){
            System.out.println("Ocorreu um problema ao copiar o arquivo para pasta" + e.getMessage());
        }

    }

    //Screenshot.takeScreen(driver, "C:\\WorkingQA\\projects\\sueit\\screenshot\\" + Generator.dataHoraParaArquivo() + test.getMethodName() + ".png");
}
