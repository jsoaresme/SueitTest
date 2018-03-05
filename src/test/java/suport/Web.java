package suport;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class Web {

    public static final String USERNAME = "jonathansoaresde1";
    public static final String AUTOMATE_KEY = "zbxFwzPnwSWs8qoXLfZK";
    public static final String URL = "https://" + USERNAME + ":" + AUTOMATE_KEY + "@hub-cloud.browserstack.com/wd/hub";

    public static WebDriver createChrome() {
        // Abrindo o driver
        System.setProperty("webdriver.chrome.driver", "C:/WorkingQA/driver/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        // Navegando para a pagina do Taskit!
        driver.manage().window().maximize();
        driver.get("https://sueit.abcdev.net/login");

        return driver;
    }

    public static WebDriver createBrowserStack() {

        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("browser", "Chrome");
        caps.setCapability("browser_version", "62.0");
        caps.setCapability("os", "Windows");
        caps.setCapability("os_version", "10");
        caps.setCapability("resolution", "1280x800");


        WebDriver driver = null;
        try {
            driver = new RemoteWebDriver(new URL(URL), caps);
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

            // Navegando para a pagina do Taskit!
            driver.get("https://sueit.abcdev.net/login");
        } catch (MalformedURLException e) {
            System.out.println("Ocorreu problema com a url" + e.getMessage());
        }

        return driver;

    }
}
