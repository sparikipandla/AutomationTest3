package utilities;

import org.openqa.selenium.Alert;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebElementHelper {

	private WebDriver driver;

    public WebElementHelper(WebDriver driver) {
        this.driver = driver;
    }
	
	public Boolean isElementVisible(WebElement element, final long timeout) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, timeout);
            wait.until(ExpectedConditions.visibilityOf(element));
            return true;
        } catch (ElementNotVisibleException e) {
            System.out.println(String.valueOf(e));
        }
        return false;
    }
	
	public Boolean isElementToBeClickable(WebElement element, final long timeout) {
        try {
        	WebDriverWait wait = new WebDriverWait(driver, timeout);
        	wait.until(ExpectedConditions.elementToBeClickable(element));
            return true;
        } catch (Exception e) {
            System.out.println(String.valueOf(e));
        }
        return false;
    }
	
	public Alert isAlertPresent(final long timeout) {
        Alert element = null;

        try {
            WebDriverWait wait = new WebDriverWait(driver, timeout);
            element = wait.until(ExpectedConditions.alertIsPresent());
        } catch (Exception e) {
            System.out.println(String.valueOf(e));
        }
        return element;
    }
}
