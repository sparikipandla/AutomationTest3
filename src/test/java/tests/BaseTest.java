package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

public class BaseTest {

    public static WebDriver driver;

    // @BeforeClass
    // @Parameters({"browser"})
    public void launchBrowser(String browserType){
        try{
        	if(browserType.equals("chrome")){
                WebDriverManager.chromedriver().setup();
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--disable-notifications");
                driver = new ChromeDriver(options);
            }

            driver.manage().window().maximize();
        }catch (WebDriverException e){
            System.out.println(e.getMessage());
        }

    }

    @AfterClass
    public void tearDownBrowser(){
        driver.quit();
    }
}
