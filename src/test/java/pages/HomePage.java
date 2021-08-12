package pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.WaitHelper;
import utilities.WebElementHelper;

public class HomePage extends BasePage {
	
	private WebElementHelper webElementHelper;
    private WaitHelper waitHelper;
    private int explicitTimeOut;

	@FindBy(css = "input.EggTimer-start-time-input-text")
	WebElement startTimeInputText;

	@FindBy(css = "button")
	WebElement startButton;
	
	@FindBy(css = "p.ClassicTimer-time")
	WebElement timerElement;

	public HomePage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		waitHelper = new WaitHelper(driver);
		webElementHelper = new WebElementHelper(driver);
        explicitTimeOut = waitHelper.getExplicitTimeout();
	}
	
	public void enterTime(String value){
		webElementHelper.isElementVisible(startTimeInputText, explicitTimeOut);
		startTimeInputText.clear();
		startTimeInputText.sendKeys(value);
    }
	
	public void startTimer(){
        webElementHelper.isElementToBeClickable(startButton, explicitTimeOut);
        startButton.click();
    }

	public String getCountDownText(){
		webElementHelper.isElementVisible(timerElement, explicitTimeOut);
		return timerElement.getText();
    }
	
	public void acceptAlert() {
		try {
	        Alert alert = driver.switchTo().alert();
	        String alertText = alert.getText();
	        System.out.println("Alert data: " + alertText);
	        alert.accept();

	    } catch (NoAlertPresentException e) {
	        e.printStackTrace();
	    }
	}
}
